package PracticeRest.Assured;

import java.util.HashMap;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Headers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		RestAssured.baseURI = "https://restful-booker.herokuapp.com";
		
		
		Map <String , String> headers = new HashMap<>();
		
		headers.put("Content-Type" ,"application/json");
		headers.put("Accept" , "application/json");
		
		  Response res = RestAssured.given().header("Content-Type" ,"application/json")
				  .header("Accept" , "application/json")
				  .body("{\r\n"
				  		+ "    \"username\" : \"admin\",\r\n"
				  		+ "    \"password\" : \"password123\"\r\n"
				  		+ "}")
		.when().post("/auth")
		
		.then().extract().response();
		
		
		  System.out.println(res.getBody().asPrettyString());
		  
		
		
		
		
	}

}
