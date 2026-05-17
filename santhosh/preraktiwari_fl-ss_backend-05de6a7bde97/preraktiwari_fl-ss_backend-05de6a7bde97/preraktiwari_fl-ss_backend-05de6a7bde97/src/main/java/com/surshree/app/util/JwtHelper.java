package com.surshree.app.util;

import com.surshree.app.domain.entities.UserEntity;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtHelper {
    private String SECRET_KEY = "puisecret";

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public boolean isUserRegistered(String token){
        final Claims claims = extractAllClaims(token);
        return claims.get("is_user_registered", Boolean.class);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }
    private Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
    }

    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    public String generateTokenUnRegisteredUser(UserDetails userDetails) {
        return generateToken(userDetails, false);
    }

    public String generateTokenRegisteredUser(UserDetails userDetails) {
        return generateToken(userDetails, true);
    }

    private String generateToken(UserDetails userDetails, boolean isUserRegistered) {
        Map<String, Object> claims = new HashMap<>();
        UserEntity entity = (UserEntity)userDetails;
        claims.put("is_user_registered", isUserRegistered);
        return createToken(claims, userDetails.getUsername());
    }

    private String createToken(Map<String, Object> claims, String subject) {
        return Jwts.builder().setClaims(claims)
                             .setSubject(subject)
                             .setIssuedAt(new Date(System.currentTimeMillis()))
                             .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                             .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                             .compact();
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    @Bean
    public JwtHelper getJwtHelper(){
        return new JwtHelper();
    }
}
