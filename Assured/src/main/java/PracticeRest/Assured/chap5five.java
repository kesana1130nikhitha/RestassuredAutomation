package PracticeRest.Assured;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class chap5five {
	
	public static void main(String[] args) {
		
		RestAssured.baseURI = "https://the-internet.herokuapp.com";
		
		 Response res = RestAssured
		.when()
		.get("/status_codes/500");
		
		 System.out.println(res.getStatusCode()
				 );
		
	}

}
