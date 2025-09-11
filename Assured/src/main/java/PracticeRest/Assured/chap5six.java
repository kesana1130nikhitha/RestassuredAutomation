package PracticeRest.Assured;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class chap5six {
	
public static void main(String[] args) {
		
		RestAssured.baseURI = "https://restful-booker.herokuapp.com";
		
		  String res = RestAssured
		.when()
		.get("/booking").
		then().log().all().toString();
		  
		 // JsonPath json = new JsonPath(res);
		  
		  System.out.println(res);
		 
		
	}

}
