package com.example.my_diary_project.auth;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@PropertySource("classpath:security.properties")
@Component
public class TokenProvider {

    @Value("${secret-key}")
    private String secretKey;
    @Value("${expiration-hours}")
    private long expirationHours;
    @Value("${issuer}")
    private String issuer;

    public String createToken(String userSpecification) {
        return Jwts.builder()
            .signWith(SignatureAlgorithm.HS512, secretKey.getBytes())
            .setSubject(userSpecification)
            .setIssuer(issuer)
            .setIssuedAt(Timestamp.valueOf(LocalDateTime.now()))
            .setExpiration(Date.from(Instant.now().plusSeconds(expirationHours * 60)))
            .compact();
    }

    public String validateTokenAndGetSubject(String token) {
        return Jwts.parser()
            .setSigningKey(secretKey.getBytes())
            .parseClaimsJws(token)
            .getBody()
            .getSubject();
    }
}
