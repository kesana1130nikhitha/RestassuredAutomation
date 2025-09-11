package PracticeRest.Assured;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Chap5seven {
	
	public static void main(String[] args) {
		
		
		RestAssured.baseURI = "https://restful-booker.herokuapp.com";
		
		 Response res = RestAssured.given()
		.contentType("application/xml ")
		.accept("application/xml")
		.pathParam("id", 119)
		.when().
		get("/booking/{id}");
		 
		 System.out.println(res.asPrettyString());
		
		
		
	}

}
