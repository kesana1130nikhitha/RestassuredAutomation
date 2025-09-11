package PracticeRest.Assured;

import io.restassured.RestAssured;
import io.restassured.config.RedirectConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.config.SSLConfig;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class chapter5three {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RestAssured.baseURI = "https://the-internet.herokuapp.com";
		
//		 RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
//			RestAssured.config = RestAssured.config().sslConfig(SSLConfig.sslConfig().relaxedHTTPSValidation());
//		

//		 RestAssured.config = RestAssuredConfig.config()
//		            .redirect(RedirectConfig.redirectConfig().followRedirects(true));

		
		  Response res = RestAssured.given().redirects().follow(false
		   ).
		    		when().
		get("/status_codes/301");
		  
	  System.out.println("Response:" + res.getStatusCode());
		  
		   
		  
	
		
		
		
		
	}

}
