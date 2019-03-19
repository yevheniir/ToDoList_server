package com.yevhenii.to_do_list.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;

import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.yevhenii.to_do_list.model.Role;
import com.yevhenii.to_do_list.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Service
public class TokenService {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    private TokenProperties properties;
    private String issuer;
    private Algorithm algorithm;
    private JWTVerifier verifier;

    @Autowired
    public TokenService(TokenProperties properties, @Value("${spring.application.name}") String issuer) throws UnsupportedEncodingException {
        this.properties = properties;
        this.issuer = issuer;
        this.algorithm = Algorithm.HMAC256(properties.getSecret());
        this.verifier = JWT.require(algorithm).acceptExpiresAt(0).build();
    }

    public String encode(User user) {
        LocalDateTime now = LocalDateTime.now();

            return JWT.create()
                    .withIssuer(issuer)
                    .withSubject(user.getEmail())
                    .withIssuedAt(Date
                            .from(now.atZone(ZoneId.systemDefault())
                                    .toInstant()))
                    .withExpiresAt(Date
                            .from(now.plusSeconds(properties.getMaxAgeSeconds())
                                    .atZone(ZoneId.systemDefault())
                                    .toInstant()))
                    .withArrayClaim("role", user
                            .getRoles()
                            .stream()
                            .map(Role::getRole)
                            .toArray(String[]::new))
                    .withClaim("usr", user.getUsername())
                    .sign(algorithm);
    }

    public DecodedJWT decode(String token) {
        return this.verifier.verify(token);
    }
}