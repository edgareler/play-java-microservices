package controllers;

import java.math.BigInteger;
import java.security.SecureRandom;

import play.*;
import play.mvc.*;

import org.json.JSONObject;

public class Service extends Controller {

	//@BodyParser.Of(BodyParser.Json.class)
    public Result addToken() {
		JSONObject jso = new JSONObject();
    	
    	jso.put("token", generateToken());
    	
    	//return ok(index.render("Your new application is ready."));
        return ok(jso.toString());
    }
    
    public Result removeToken(String token) {
    	return ok();
    }
    
    public String generateToken(){
    	SecureRandom random = new SecureRandom();
    	
    	String token = new BigInteger(255, random).toString(32);
    	
    	return token;
    }

}
