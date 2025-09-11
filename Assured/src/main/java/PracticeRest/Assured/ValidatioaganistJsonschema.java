package PracticeRest.Assured;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;


public class ValidatioaganistJsonschema {

	
	@Test
	public static void validationjsonschema()
	{
		
		
		RestAssured.useRelaxedHTTPSValidation();
		
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
		
		 Response res = RestAssured.given().
		
		when().
		
		get("/posts/2").
		then().log().all().body(matchesJsonSchemaInClasspath("")).extract().response();
		 
		 
		 
		 Assert.assertEquals(res.getStatusCode(),200,"Expected status code 200");
	//	 Assert.assertEquals(res.getBody().asString().contains("ok"), "Response");

		 
		 
		// JsonPath json =  res.jsonPath();
		 
		 
	//	json.matchesJsonSchemaInClasspath("validationjsonchemaone.json");	 
		
	}

}
