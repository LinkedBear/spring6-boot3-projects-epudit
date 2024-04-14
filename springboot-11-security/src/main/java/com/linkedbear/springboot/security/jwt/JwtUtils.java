package com.linkedbear.springboot.security.jwt;

import com.linkedbear.springboot.security.entity.SecurityUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.userdetails.User;
import org.springframework.util.StringUtils;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;
import java.util.Date;
import java.util.UUID;

public abstract class JwtUtils {
    
    public static final String JWT_PAYLOAD = "user";
    public static final String JWT_HEADER = "authorization";
    /** 分割jwt与刷新令牌的标识 */
    public static final String JWT_SLIPTER = "abcdefg.uvwxyz";
    
    public static final char ENCODE_CHAR = 'a';
    
    /**
     * 向客户端响应jwt访问+刷新令牌
     * @param response
     * @param user
     * @param privateKey
     * @param accessExpire
     * @param refreshExpire
     */
    public static void writeJwtToken(HttpServletResponse response, User user, PrivateKey privateKey,
            int accessExpire, int refreshExpire) {
        String jwtToken = JwtUtils.generateJwtToken(user, privateKey, accessExpire);
        String refreshToken = JwtUtils.generateRefreshToken(user, privateKey, refreshExpire);
//        response.addHeader(JWT_HEADER, jwtToken);
        response.addHeader(JWT_HEADER, jwtToken + JWT_SLIPTER + refreshToken);
    }
    
    /**
     * 生成jwt令牌
     * @param user
     * @param privateKey
     * @param expire 秒
     * @return
     */
    public static String generateJwtToken(User user, PrivateKey privateKey, int expire) {
        return Jwts.builder().claim(JWT_PAYLOAD, JsonUtils.toJson(user)).id(createJtl())
                .expiration(new Date(System.currentTimeMillis() + expire * 1000))
                .signWith(privateKey, Jwts.SIG.RS256).compact();
    }
    
    /**
     * 生成刷新令牌
     * @param user
     * @param expire 秒
     * @return
     */
    public static String generateRefreshToken(User user, PrivateKey privateKey, int expire) {
        String tokenJson = JsonUtils.toJson(user);
        String encodedTokenJson = encodeRefreshToken(tokenJson);
        return Jwts.builder().claim(JWT_PAYLOAD, encodedTokenJson).id(createJtl())
                .expiration(new Date(System.currentTimeMillis() + expire * 1000))
                .signWith(privateKey, Jwts.SIG.RS256).compact();
    }
    
    /**
     * 解析jwt令牌
     * @param token
     * @param publicKey
     * @return
     */
    public static TokenPayload parseToken(String token, PublicKey publicKey) {
        Jws<Claims> claimsJws = Jwts.parser().verifyWith(publicKey).build().parseSignedClaims(token);
        Claims claims = claimsJws.getPayload();
        TokenPayload payload = new TokenPayload();
        payload.setId(claims.getId());
        payload.setExpiration(claims.getExpiration());
        payload.setUser(JsonUtils.parseObject(claims.get(JWT_PAYLOAD).toString(), SecurityUser.class));
        return payload;
    }
    
    /**
     * 解析jwt令牌中的载荷部分
     * @param token
     * @param publicKey
     * @return
     */
    public static String getTokenPayload(String token, PublicKey publicKey) {
        Jws<Claims> claimsJws = Jwts.parser().verifyWith(publicKey).build().parseSignedClaims(token);
        Claims claims = claimsJws.getPayload();
        return claims.get(JWT_PAYLOAD).toString();
    }
    
    public static String createJtl() {
        return new String(Base64.getEncoder().encode(UUID.randomUUID().toString().getBytes()));
    }
    
    /**
     * 编码token中的信息
     * @param tokenJson
     * @return
     */
    public static String encodeRefreshToken(String tokenJson) {
        StringBuilder sb = new StringBuilder(tokenJson.length() + 10);
        sb.append("refresh ");
        char[] chars = tokenJson.toCharArray();
        for (char c : chars) {
            c ^= ENCODE_CHAR;
            sb.append(c);
        }
        String encodedTokenJson = sb.toString();
        return new String(Base64.getEncoder().encode(encodedTokenJson.getBytes()));
    }
    
    /**
     * 解码token中的信息
     * @param encodedToken
     * @return
     */
    public static String decodeRefreshToken(String encodedToken) {
        if (!StringUtils.hasText(encodedToken)) {
            return "";
        }
        
        String encodedTokenJson = new String(Base64.getDecoder().decode(encodedToken.getBytes()));
        if (encodedTokenJson.length() <= 8) {
            return "";
        }
        encodedTokenJson = encodedTokenJson.substring(8);
        StringBuilder sb = new StringBuilder(encodedTokenJson.length());
        char[] chars = encodedTokenJson.toCharArray();
        for (char c : chars) {
            c ^= ENCODE_CHAR;
            sb.append(c);
        }
        return sb.toString();
    }
}
