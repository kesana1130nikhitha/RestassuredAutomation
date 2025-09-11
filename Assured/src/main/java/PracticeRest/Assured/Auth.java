package PracticeRest.Assured;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;

public class Auth {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RestAssured.baseURI ="https://postman-echo.com";
		RestAssured.useRelaxedHTTPSValidation();
		RestAssured.given().auth().basic("postman", "password")
		.when().get("/basic-auth").then().log().all().statusCode(200);
		
		
		
		//Response 2 
		
		 RestAssured.given().auth().basic("postmana", "password").when()
				.get("https://postman-echo.com/basic-auth").then().log().all().statusCode(401);
		 //Digest authentication 
		 
		 
		 RestAssured.given().log().all().
		 auth().digest("postman", "password").when().get("https://postman-echo.com/digest-auth")
		 .then().log().all().statusCode(200);
		 
		 
		 //API -key Authentiction
		 
		 
		 RestAssured.given().queryParam("appid","123").when()
		 
		 .get("https://api.openweathermap.org/data/2.5/weather?q=chennai").then().log().all()
		 .statusCode(200);
		 
		

	}

}
