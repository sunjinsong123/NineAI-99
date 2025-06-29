package com.nineai.nineai.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.experimental.UtilityClass;

import javax.crypto.SecretKey;
import java.util.Date;

@UtilityClass
public class JwtUtil {

    /** 建议放到 nacos / env；示例用随机密钥演示 */
    private final SecretKey SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    /** 1 小时过期 */
    private static final long EXPIRE_MILLIS = 60 * 60 * 1000;

    public String generateToken(String subject) {
        long now = System.currentTimeMillis();
        return Jwts.builder()
                .setSubject(subject)           // 一般存 userId / username
                .setIssuedAt(new Date(now))
                .setExpiration(new Date(now + EXPIRE_MILLIS))
                .signWith(SECRET_KEY)
                .compact();
    }

    public boolean validate(String token) {      // 供过滤器使用
        try {
            Jwts.parser().setSigningKey(SECRET_KEY).build().parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
