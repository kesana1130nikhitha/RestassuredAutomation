package PracticeRest.Assured;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class India {

	@Test(enabled = false)
	public static void Testing() throws IOException {
		// TODO Auto-generated method stub

		RestAssured.baseURI = "http://universities.hipolabs.com";
				
		 Response res = RestAssured.given().
		when().get("/search?country=india")
		.then().extract().response();
		 
	 String indiaunvi = res.getBody().asPrettyString();	
		
		JsonPath json = res.jsonPath();
			
		List<Map<String,Object>> responseroot = json.getList("$");
		
		   long countodunvinindia = responseroot.stream().filter(u-> "India".equalsIgnoreCase((String) u.get("country"))).count();
		   
		   System.out.println(countodunvinindia);
		   
		   FileWriter file = new FileWriter("indiaunvi.txt");
		   file.write(indiaunvi);				   
		   
	}


	@Test(enabled = false)
	public static void Francedetails () {
		
		RestAssured.baseURI = "http://universities.hipolabs.com";
		
		 Response res = RestAssured.given().
		when().get("/search?country=france")
		.then().extract().response();
		 
	 String franceunvi = res.getBody().asPrettyString();
	 
	 System.out.println(franceunvi);
		
		JsonPath json = res.jsonPath();
			
	List<Map<String,Object>> responseroot = json.getList("$");
//		
	 responseroot.stream().skip(1).findFirst().ifPresent(u-> System.out.println((String) u.get("name")));
	
		//System.out.println(secondunvi);
	}
	
	@Test(enabled = true)
	public static void unitedpop() {		
	//	RestAssured.baseURI = "https://datausa.io";
		
		  RestAssured.baseURI = "https://datausa.io";

	        Response response = RestAssured
	            .given()

	            .header("Accept", "application/json")
	               .header("User-Agent", "Mozilla/5.0")
	               .redirects().follow(true)
	               .when()
	               .get("/api/data?drilldowns=Nation&measures=Population")
	               .then()
	               .extract()
	               .response();

	           System.out.println("Status Code: " + response.getStatusCode());
	           System.out.println("Response: " + response.getBody().asPrettyString());
	       }
	
		// System.out.println(res.getBody().asPrettyString());		 
	}
	
