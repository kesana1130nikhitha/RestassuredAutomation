package PracticeRest.Assured;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Chap5nine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		 RestAssured.baseURI = "https://reqres.in";
		 RestAssured.useRelaxedHTTPSValidation();
		 
		  Response response = RestAssured.
		 given().log().all().
		 
		 when()
		 .get("/api/users");
		 
		  
		  System.out.println(response.getBody().asString());
		 
		 // Print TOp level key 
		 
		 
		
	}

}
