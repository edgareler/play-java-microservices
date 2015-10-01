package controllers;

import play.*;
import play.mvc.*;

import org.json.JSONObject;
import org.json.JSONObject;

import play.libs.ws.*;
import play.libs.Json;
import play.libs.F.Function;
import play.libs.F.Promise;
import play.data.*;

import org.json.JSONObject;

public class Service extends Controller {

	//@BodyParser.Of(BodyParser.Json.class)
    public Promise<Result> authenticate() {
    	Boolean authorized = false;

    	DynamicForm requestData = Form.form().bindFromRequest();

    	String login = requestData.get("login");
    	String password = requestData.get("password");
    	
    	if(!login.equals("") && !password.equals("")){
    		authorized = true;
    	}
    	
    	
    	if(authorized == true){

    		String url = "https://edgarsys.com:9443/";

    	    Promise<Result> jsonPromise = WS.url(url).get().map(
	    		response -> (Result) ok(response.asJson())
    	    );
    	    
    	    return jsonPromise;	
    	} else {
    		
    		return Promise.promise(() -> (Result) status(401, "Unauthorized"));
    		
    		//return (Result) ok("Unauthorized");
    		//return status(401, "Unauthorized");
/*
    		return Promise.promise(() -> void())
                    .map(() -> status(401, "Unauthorized"));*/
    	}   
    }

}
