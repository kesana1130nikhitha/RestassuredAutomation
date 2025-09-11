package PracticeRest.Assured;

import java.util.Arrays;
import java.util.stream.IntStream;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class converttheresponseintojsondoc {
	
	//Validate the response which contains a list of values, convert the response into a Json document and then validate.

	@Test
	public static void convertion() {
		
		
		RestAssured.baseURI  ="https://restful-booker.herokuapp.com/booking";
		
		   Response res = RestAssured.given().contentType("application/json")
		.body("{\r\n"
				+ "    \"firstname\": \"Jim\",\r\n"
				+ "    \"lastname\": \"Brown\",\r\n"
				+ "    \"totalprice\": 111,\r\n"
				+ "    \"depositpaid\": true,\r\n"
				+ "    \"bookingdates\": {\r\n"
				+ "        \"checkin\": \"2018-01-01\",\r\n"
				+ "        \"checkout\": \"2019-01-01\"\r\n"
				+ "    },\r\n"
				+ "    \"additionalneeds\": \"Breakfast\"\r\n"
				+ "}")
		.when()
		.post("/booking")
		.then()
		.extract().response();
		   
		   
		    JsonPath json = res.jsonPath();
		    
		      
		String[] ExpectedValues = {"Jim" ,"Brown" ,"Breakfast"};
		
		String[] actualvalues = 
				
				{ "res.jsonPath().getMap(booking.firstname)"
						,
						"res.jsonPath().getMap(booking.lastname)"	
						
						,"json.getInt(booking.totalprice)"
				};
		       
		
		   boolean bb = IntStream.range(0, ExpectedValues.length).allMatch(i->actualvalues[i].equals(ExpectedValues[i]));
		
		}
		       

}
