package PracticeRest.Assured;

//import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.config.SSLConfig;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import org.hamcrest.*;


public class Practice1 {
    
	
   public static void main(String args[]) {
	RestAssured.baseURI = "https://postman-echo.com";
	RestAssured.config = RestAssured.config().sslConfig(SSLConfig.sslConfig().relaxedHTTPSValidation());

	  Response response = RestAssured.given().auth().basic("postman", "password")
	    .when()
	    .get("/basic-auth");
	    
	 int response1 = response.getStatusCode();
	 String str = response.asPrettyString();
	 
	 System.out.println(response1);
	 System.out.print(str);

	 //test2
	 
	 
	 
	 
	
	}
   

}
