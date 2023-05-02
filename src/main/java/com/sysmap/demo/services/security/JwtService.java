package com.sysmap.demo.services.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.UUID;

@Service
public class JwtService implements IJwtService {

    private final long EXPIRATION_TIME = 7200000;
    private final String KEY = "u7x!A%D*F-JaNdRgUkXp2s5v8y/B?E(H";

    public String generateToken(String email) {
        return Jwts
                .builder()
                .setSubject(userId)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public boolean IsValidToken (String token, UUID userId) {
        var claims = Jwts.parserBuilder().setSigningKey(genSignInKey()).build().parseClaimsJws((token).getbody());

        var sub = claims.getSubject();
        var tExpiration = claims.getExpiration();

        return userId.toString().equals(sub) && tExpiration.before(new Date());
    }

    private Key genSignInKey() {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(KEY));
    }
}
