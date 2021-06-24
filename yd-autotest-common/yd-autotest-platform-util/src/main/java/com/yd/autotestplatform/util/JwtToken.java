package com.yd.autotestplatform.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.UUID;

/**
 * <p>
 *  生成token
 *  JSON Web Token (JWT)是一个开放标准(RFC 7519)，它定义了一种紧凑的、自包含的方式，用于作为JSON对象在各方之间安全地传输信息。
 *  该信息可以被验证和信任，因为它是数字签名的
 *
 *  JSON Web Token由三部分组成，它们之间用圆点(.)连接。这三部分分别是：
 *  .Header  (base64编码)
 *  .Payload  (base64编码，包含需要加密的信息)
 *  .Signature （散列算法（Header里写出了算法方式）加密后的值）
 * </p>
 * 加密
 * @author: yd
 * @version: V1.0
 * @contact:
 * @date: 2021-06-23 8:36
 * @Email: 664720125@qq.com
 */
public class JwtToken {

    private static Long expiration= 1800000L;  // 30分钟过期(1秒=1000毫秒(ms) ): 30 * 60 * 1000
//    private final Long EXPIRATION= 5000l;  // 测试用 5s过期 : 5 * 1000
//    private final String SIGNING_KEY = "xx00250";  //加盐加密是一种对系统登录口令的加密方式，它实现的方式是将每一个口令跟一个n位随机数相关联，这个n位随机数叫做”盐“（salt）
    private final static String SIGNING_KEY = UUID.randomUUID().toString().replace("-", "");

    public static String creatToken(String subject){
        long timeMillis = System.currentTimeMillis();
        String token = Jwts.builder()
                .setIssuer("test")
                .setIssuedAt(new Date(timeMillis))
                .setExpiration(new Date(timeMillis + expiration))
                .setSubject(subject)
                .signWith(SignatureAlgorithm.HS256, SIGNING_KEY)
                .compact();
        return token;
    }

    public static String parseToken(String token){
        String subject = Jwts.parser().setSigningKey(SIGNING_KEY).parseClaimsJws(token).getBody().getSubject();
        return subject;
    }

    public static void setExpiration(Long expiration) {
        JwtToken.expiration = expiration;
    }
}
