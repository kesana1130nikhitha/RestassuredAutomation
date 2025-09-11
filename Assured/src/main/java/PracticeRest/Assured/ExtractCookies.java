package PracticeRest.Assured;

import java.util.Map;

import io.restassured.RestAssured;

public class ExtractCookies {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		
		RestAssured.baseURI = "https://postman-echo.com";
		
		RestAssured.useRelaxedHTTPSValidation();
		
		//Map<String, String> allcookies =
		String cook = RestAssured.given().cookies("Communication", "Key Skill")
		.
		when().
		
	
	get("/cookies/set").then().log().all().
	
	extract().response().getCookie("sails.sid");
		
		
		
		
		System.out.println(cook);
		
		
		// in order to handle one key-value pair of Map data structure -> use entrySet and if you wnat to handle the key only then use 
		
		//keySet and if you wnat to handle the value then use valueSet 
		
		//allcookies.entrySet().forEach(entry -> System.out.println(" key  :" + entry.getKey() + " " + "value :" +entry.getValue()));
		
		

	}

}
