package PracticeRest.Assured;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Chapter5four {

	
	public static void main(String[] args) {
		
		RestAssured.baseURI = "https://the-internet.herokuapp.com";
		 Response res = RestAssured.given()
      .when()
  	.get("/status_codes/404");
		 
		 System.out.print(res.getStatusCode());
		 
  	
		
	}
	
	
}
