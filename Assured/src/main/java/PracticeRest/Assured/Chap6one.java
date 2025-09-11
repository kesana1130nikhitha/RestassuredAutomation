package PracticeRest.Assured;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;

public class Chap6one {
	public static String objectid;
   
	
	//post method
	@Test
	public static void testexm1()
	{
		
			
		RestAssured.baseURI = "https://api.restful-api.dev";
		RestAssured.useRelaxedHTTPSValidation();
		
		  objectid = RestAssured.given().contentType("application/json").log().all()
		.
		body(TESTmethod.testinput()).
		when().log().all().post("/objects")
		.then().log().all().assertThat().statusCode(200).extract().path("id").toString();
	}
	
	//put
	
	@Test(dependsOnMethods = "testexm1")
	
	public void testexm2()
	{
			
		RestAssured.baseURI = "https://api.restful-api.dev";
		RestAssured.useRelaxedHTTPSValidation();
		
		 
		String response = RestAssured.given().contentType("application/json").log().all()
		.
		body("{\r\n"
				+ "   \"name\": \"Apple MacBook Pro 16\",\r\n"
				+ "   \"data\": {\r\n"
				+ "      \"year\": 2019,\r\n"
				+ "      \"price\": 3000.99,\r\n"
				+ "      \"CPU model\": \"Intel Core i9\",\r\n"
				+ "      \"Hard disk size\": \"1 TB\",\r\n"
				+ "      \"color\": \"silver\"\r\n"
				+ "   }\r\n"
				+ "}").
		when().log().all().put("/objects/" + objectid)
		.then().log().all().assertThat().statusCode(200).extract().body().asPrettyString();
		
		JSONObject json = new JSONObject(response);
		
		JSONObject data = json.getJSONObject("data");
		
		     double pp = data.getDouble("price");
		
		
		 System.out.println("updatedprice :" + pp);
		
	}
	
	//Patch 
	@Test(dependsOnMethods ="testexm1")
	public void testexm3() {
	{
		
		RestAssured.baseURI = "https://api.restful-api.dev";
		RestAssured.useRelaxedHTTPSValidation();
		
		 
		String response = RestAssured.given().contentType("application/json").log().all()
		.
		body("{\r\n"
				+ "   \"name\": \"Apple MacBook Pro 16 (Updated Name)\"\r\n"
				+ "}").
		when().log().all().patch("/objects/" + objectid)
		.then().log().all().assertThat().statusCode(200).extract().body().asPrettyString();
		
		JSONObject json = new JSONObject(response);
		
		String name = json.getString("name");
		
		
		 System.out.println("updatedname :" + name);
		
	}
	}
	
	
	
	
	@Test(dependsOnMethods ="testexm1")
	public void testexm4() {
	{
		
		RestAssured.baseURI = "https://api.restful-api.dev";
		RestAssured.useRelaxedHTTPSValidation();
		
		 
		   RestAssured.given().contentType("application/json").log().all()
		.
		
		when().log().all().delete("/objects/" + objectid + "77")
		.then().log().all().assertThat().statusCode(200);
		
		
		
	}
	}

}
