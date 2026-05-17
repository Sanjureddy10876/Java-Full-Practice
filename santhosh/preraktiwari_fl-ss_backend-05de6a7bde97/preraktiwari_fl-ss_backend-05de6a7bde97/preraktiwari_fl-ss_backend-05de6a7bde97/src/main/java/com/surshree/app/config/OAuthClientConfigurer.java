package com.surshree.app.config;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class OAuthClientConfigurer {
    private String clientId;
    private String clientSecret;
    private String grantTypePassword;
    private String authorizationCode;
    private String refreshToken;
    private String implicit;
    private String grantTypeClientCredentials;
    private String scopeApi;
    private String[] redirectUris;
    private int accessTokenValiditySeconds;
    private int refreshTokenValiditySeconds;

    public static OAuthClientConfigurer INSTANCE = new OAuthClientConfigurer();

    private static final List<OAuthClientConfigurer> CLIENT_CONFIGURERS = new ArrayList<>();

    static{
        setClientConfig();
    }

    public static List<OAuthClientConfigurer> getOAuthConfigs(){
        return CLIENT_CONFIGURERS;
    }

    private static void setClientConfig(){
        OAuthClientConfigurer client = new OAuthClientConfigurer();
        client.setClientId("web");
        client.setClientSecret("webpass");
        client.setGrantTypePassword("password");
        client.setAuthorizationCode("authorization_code");
        client.setRefreshToken("refresh_token");
        client.setImplicit("implicit");
        client.setGrantTypeClientCredentials("client_credentials");
        client.setScopeApi("apiAccess");
        client.setRedirectUris(new String[] {"http://localhost:8081"});
        client.setAccessTokenValiditySeconds(1 * 60 * 60);
        client.setRefreshTokenValiditySeconds(6 * 60 * 60);
        CLIENT_CONFIGURERS.add(client);
    }
}
