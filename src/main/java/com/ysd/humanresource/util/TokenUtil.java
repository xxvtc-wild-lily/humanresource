package com.ysd.humanresource.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
/**		
 * 		依赖
 * 		<dependency>
			<groupId>io.jsonwebtoken</groupId>
			<artifactId>jjwt</artifactId>
			<version>0.6.0</version>
		</dependency>
		
		
	token工具类
 * @author Sor3
 *
 */
public class TokenUtil {
	private static String secretKey ="123";
	/**
	 * 根据用户名以及用户id生成token
	 * @param name 用户名
	 * @param id 用户id
	 * @param lastLoginTime 最后登录时间
	 * @return token字符串
	 */
	public static String createToken(String id,String name,Date lastLoginTime) {
		JwtBuilder builder = Jwts.builder()
							//设置id
							 .setId(id) 
							//设置用户名
							 .setSubject(name)
							//设置最后登录时间
							 .setIssuedAt(lastLoginTime)
							//设置过期时间
							 .setExpiration(new Date(lastLoginTime.getTime()+1000*60*20))
							 //设置签名密钥及盐值
							 .signWith(SignatureAlgorithm.HS256, secretKey.getBytes())
							//设置自定义属性，可添加多个键值对
							.claim("secretKey", secretKey)
				;
		return builder.compact();
	}
	/**
	 * 解析token
	 * @param token 要解析的token
	 * @return 获取到的一个键值对集合 （存储的是生成token时放入的相关信息）
	 */
	public static Claims parserTonken(String token){
		Claims body = Jwts.parser()
		.setSigningKey(secretKey.getBytes())
		.parseClaimsJws(token)
		.getBody();
		return body;
	}
	
}
