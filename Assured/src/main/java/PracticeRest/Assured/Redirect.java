package PracticeRest.Assured;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Redirect {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		RestAssured.baseURI = "https://simple-tool-rental-api.glitch.me";
	
		
		    Response Res = RestAssured.given().log().all().redirects().follow(true).and().relaxedHTTPSValidation().
		    		
		    		when().get("/status")
		.then().extract().response();
		   
		   System.out.println("response:" + Res.getStatusCode());
		   
		   
		   System.out.println("response:" + Res.getBody().asPrettyString());
	
	}

}
