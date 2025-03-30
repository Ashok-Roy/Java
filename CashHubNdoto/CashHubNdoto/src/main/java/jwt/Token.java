package jwt;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.*;

import Model.Parameters;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

public class Token 
{ 
	static String key="E7A2F3A38860E6D1E9E02E94EEB0FCB030A4D3E1F0294362A4CBE8F67BDEB56F";
	static byte [] secret =Base64.getDecoder().decode(key);

	public static String getToken(Parameters param)
	{
		
       Instant ins=Instant.now();
	
		String jwt=Jwts.builder().setSubject("authentication").
				setIssuedAt(Date.from(ins)).
				claim("username",param.getUserid()).
				setExpiration(Date.from(ins.plus(24,ChronoUnit.HOURS))).
				signWith(Keys.hmacShaKeyFor(secret)).compact();
		
		
		return jwt;
		
		
	}

	public static Claims decodeJwt(String token)
	{
		
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		
		Claims claims=(Claims) Jwts.parser()
				.setSigningKey(Base64.getDecoder()
				.decode(key))
				.parseClaimsJws(token).getBody();
		String subject=(String) claims.get("username");
		Date date=claims.getExpiration();
		System.out.println(subject +"::: " +format.format(date));
		return claims;
		
	}
	

}
