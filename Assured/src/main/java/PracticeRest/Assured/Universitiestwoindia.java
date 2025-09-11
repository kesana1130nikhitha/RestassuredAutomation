package PracticeRest.Assured;

import java.io.FileWriter;
import java.io.IOException;

import org.testng.annotations.Test;


import io.restassured.RestAssured;
import io.restassured.filter.log.*;
import io.restassured.response.Response;

public class Universitiestwoindia {

	@Test
	public static void Testing() throws IOException {
		// TODO Auto-generated method stub

		RestAssured.baseURI = "http://universities.hipolabs.com";
		
		
		 Response res = RestAssured.given().filter(new RequestLoggingFilter())
				 .filter(new ResponseLoggingFilter()).
		when().get("/search?country=india")
		.then().extract().response();
		 
		System.out.println(res.getBody().asPrettyString());
		
		String response = res.getBody().asPrettyString();
		
		FileWriter fs = new FileWriter("response.txt");
		
		fs.write(response);
		
		
		
}
}
