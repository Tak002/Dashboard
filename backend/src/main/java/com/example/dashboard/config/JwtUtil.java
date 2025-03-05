package com.example.dashboard.config;


import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.Jwts;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtUtil {
    @Value("${JWT.SECRET}")
    private String SECRET_KEY;
    @Value("${JWT.EXPIRATION}")
    private long EXPIRATION;

    private SecretKey signKey;

    private SecretKey getSigningKey() {
        if (signKey==null){
            byte[] keyBytes = Decoders.BASE64.decode(this.SECRET_KEY);
            signKey = Keys.hmacShaKeyFor(keyBytes);
        }
        return signKey;
    }

    public String generateToken(String email){
        return Jwts.builder()
                .subject(email)
                .issuedAt(new Date())
                .expiration(new Date((new Date()).getTime() + EXPIRATION))
                .signWith(getSigningKey())
                .compact();
    }

    public boolean isToken(String token){
        try{
            Jwts.parser().verifyWith(getSigningKey())
                    .build()
                    .parseSignedClaims(token)
                    .getPayload();
        } catch (Exception e) {return false;}
        return true;
    }

    public String getEmailInToken(String token){
        return Jwts.parser().verifyWith(getSigningKey())
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }

}
