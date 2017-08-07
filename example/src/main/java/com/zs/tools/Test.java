package com.zs.tools;

import java.io.UnsupportedEncodingException;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.interfaces.DecodedJWT;

public class Test {

	public static void main(String[] args) {
		try {
		    Algorithm algorithm = Algorithm.HMAC256("secret");
		    String token = JWT.create()
		        .withIssuer("auth0")
		        .sign(algorithm);
		    System.out.println(algorithm);
		    
		    Algorithm algorithm1 = Algorithm.HMAC256("secret");
		    JWTVerifier verifier = JWT.require(algorithm1)
		        .withIssuer("auth0")
		        .build(); //Reusable verifier instance
		    DecodedJWT jwt = verifier.verify(token);
		    System.out.println(jwt.getIssuedAt());
		    
		} catch (UnsupportedEncodingException exception){
		    //UTF-8 encoding not supported
		} catch (JWTCreationException exception){
		    //Invalid Signing configuration / Couldn't convert Claims.
		}
	}
	
}
