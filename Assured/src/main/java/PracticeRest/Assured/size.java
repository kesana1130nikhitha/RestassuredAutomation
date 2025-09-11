package PracticeRest.Assured;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.*;

public class size {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
	        // Set base URI
	        RestAssured.baseURI = "https://restful-booker.herokuapp.com";
	    //register Parser 
	        
	        RestAssured.registerParser("text/plain", Parser.JSON);


	        // Send POST request
//	    Response response = 
	    		given()
	            .contentType("application/json")
	            .accept("application/json")
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
	           . when().post("/booking").then().log().all().assertThat().statusCode(200).statusLine("HTTP/1.1 200 OK").
	           body("booking.firstname",equalTo("Jim"))
	           
	           //logical operators 
	           .body("booking.bookingdates", allOf(hasKey("checkin"),hasKey("checkout") ))
	           .body("booking.firstname", anyOf(equalTo("Jim"), equalTo("John")))
	           .body("booking.lastname", not(equalTo("John")));
	    		
	           
	           
	           
	           
	           
	           //.body("booking", hasKey("firstname"));

	        // Print full response
//	        System.out.println("Response Body:");
//	        System.out.println(response.asPrettyString());
//	        System.out.println(response.jsonPath().getMap("booking").size());
	       // System.out.println(response.toString().length());
	    		
	    		
	    		//Validate the response which contains a list of values, convert the response into a Json document and then validate.

	        

	        
	    }
	}


