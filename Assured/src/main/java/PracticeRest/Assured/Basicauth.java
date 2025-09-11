package PracticeRest.Assured;

import io.restassured.RestAssured;


public class Basicauth {
	
	public static void main(String[] args)
	{
		RestAssured.baseURI = "https://the-internet.herokuapp.com";
		   int res = RestAssured.given().
		when().get("/status_codes/200").
		then().extract().statusCode();
		
		System.out.println(res);
	}
}

