package PracticeRest.Assured;

import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class meeladage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RestAssured.baseURI = "https://api.agify.io";
		
		RestAssured.useRelaxedHTTPSValidation();
		
		    Response res = RestAssured.given().when()
		.get("?name=meelad").then().extract()
		.response();
		    
		     String strres = res.getBody().asPrettyString();
		    
		  System.out.println(strres)  ;
		     
		   JsonPath json = res.jsonPath();
		   
		   
		       
		  
		  Assert.assertEquals( json.getInt("age"), 34);
		  
		  
		    
		
		

	}

}