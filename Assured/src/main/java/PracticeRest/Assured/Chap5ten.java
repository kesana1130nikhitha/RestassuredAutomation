package PracticeRest.Assured;

import org.json.JSONObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Chap5ten {
	
	public static void main(String[] args) {
		
		
		
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
		RestAssured.useRelaxedHTTPSValidation();
		
		Response response = RestAssured.given()
		
		
		.when().get("/posts?5");
		
		System.out.println(response.getBody().asString());
		
		
		//JSONObject json = new JSONObject(response);
		
		
		//print top level values
//		
//		for(String key : json.keySet()) {
//			
//			System.out.println("key:" + json.get(key));
//			
//		}
		
		
		//print user data 
		
		
		
		
		
		
		
		
		
		
		
	}

}
