package com.boring.personalfin.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.interfaces.RSAKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Date;
import java.util.UUID;

@Service
public class JwtUtilService {
    final
    Algorithm algorithm;

    public JwtUtilService(Algorithm algorithm) {
        this.algorithm = algorithm;
    }

    public String generateToken(String subject){
        return JWT.create().withIssuer("boring")
                .withSubject(subject)
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis() + 5000L))
                .withJWTId(UUID.randomUUID()
                        .toString())
                .sign(algorithm);
    }
    public String getSubjectFromToken(String token){
        JWTVerifier verifier = JWT.require(algorithm)
                .withIssuer("boring")
                .build();
        return verifier.verify(token).getSubject();
    }

}
