package controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import play.*;
import play.mvc.*;
import play.data.*;
import views.html.*;
import play.libs.ws.*;
import play.libs.F.Function;
import play.libs.F.Promise;
import models.Account;
import models.Transaction;

import org.json.JSONObject;

public class Application extends Controller {

	// public Promise<Result> index() {
    public Result index() {
    	ArrayList<Account> accounts = new ArrayList<Account>();
    	
    	accounts.add(new Account(1L, "Account 01", 1L, 1500.08f));
    	accounts.add(new Account(2L, "Account 02", 1L, 1500.08f));
    	accounts.add(new Account(3L, "Account 03", 1L, 1500.08f));
    	accounts.add(new Account(4L, "Account 04", 1L, 1500.08f));
    	
        return ok(index.render(accounts));
    }
    
    public Result customerHome() {
    	return ok();
    }
    
    public Result adminHome() {
    	return ok();
    }

    public Result loginPage() {
    	return ok(login.render());
    }

    public Promise<Result> loginSubmit() {
    	DynamicForm requestData = Form.form().bindFromRequest();
    	
    	String login = requestData.get("bankLogin");
    	String password = requestData.get("bankPassword");
    	
    	String url = "https://edgarsys.com:9444/";

	    Promise<Result> jsonPromise = WS.url(url).setContentType("application/x-www-form-urlencoded")
	    		.post("login=" + login + "&password=" + password).map(resp -> {
					JSONObject jso = new JSONObject(resp.asJson().toString());
					System.out.println("JSON: " + jso.toString());
					response().setCookie("identifierToken", jso.getString("token"), 450);
					
	    			return redirect(routes.Application.index());
		});
	    
	    return jsonPromise;	
    	
    	//return ok();
    }
    
    public Result transactions(Long account) {
    	ArrayList<Transaction> transactionsList = new ArrayList<Transaction>();
    	
    	transactionsList.add(new Transaction(1L, account, new Date(), 39.95f, "Withdrawal"));
    	transactionsList.add(new Transaction(2L, account, new Date(), 39.95f, "Withdrawal"));
    	transactionsList.add(new Transaction(3L, account, new Date(), 39.95f, "Deposit"));
    	transactionsList.add(new Transaction(4L, account, new Date(), 39.95f, "Withdrawal"));
    	transactionsList.add(new Transaction(5L, account, new Date(), 39.95f, "Deposit"));
    	transactionsList.add(new Transaction(6L, account, new Date(), 39.95f, "Deposit"));
    	
    	return ok(transactions.render("Account " + account, transactionsList));
    }
    
    public Result moneyTransfer() {
    	return ok();
    }
    
    public Result moneyTransferSubmit(){
    	return ok();
    }
    
}
