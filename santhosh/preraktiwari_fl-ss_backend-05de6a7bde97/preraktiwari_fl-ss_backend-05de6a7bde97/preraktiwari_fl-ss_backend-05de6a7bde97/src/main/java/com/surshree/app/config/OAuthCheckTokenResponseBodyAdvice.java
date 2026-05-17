package com.surshree.app.config;

import com.surshree.app.domain.entities.UserDetailsEntity;
import com.surshree.app.domain.entities.UserEntity;
import com.surshree.app.services.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.provider.endpoint.CheckTokenEndpoint;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.Map;
import java.util.Optional;

@ControllerAdvice(assignableTypes = {CheckTokenEndpoint.class})
public class OAuthCheckTokenResponseBodyAdvice implements ResponseBodyAdvice<Object> {

    @Autowired
    CustomUserDetailsService userService;

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
                                  Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request,
                                  ServerHttpResponse response) {
        if (body instanceof Exception) {
            // If check_token fails, response is an Exception instead of Map, so skip the method.
            return body;
        }
        @SuppressWarnings("unchecked")
        Map<String, Object> customResponse = (Map<String, Object>) body;

        String userName = (String)customResponse.get("user_name");
        UserEntity user = (UserEntity) userService.loadUserByUsername(userName);
        user.getAuthorities();
        customResponse.put("firstName", user.getFirstName());
        customResponse.put("middleName", user.getMiddleName());
        customResponse.put("lastName", user.getLastName());
        customResponse.put("dob", user.getDob());
        customResponse.put("isActive", user.getIsActive());
        customResponse.put("gender", user.getGender());
        customResponse.put("roles", user.getRoles());
        customResponse.put("functions", user.getFunctions());


        if(user.getDetails() != null) {
            UserDetailsEntity details = user.getDetails();
            customResponse.put("profilePicture", details.getProfilePicture());
            customResponse.put("profileVideo", details.getProfileVideo());
            customResponse.put("city", details.getAddress().getAddressCity());
            customResponse.put("state", details.getAddress().getAddressState());
            customResponse.put("country", details.getAddress().getAddressCountry());
        }

        return customResponse;
    }

}
