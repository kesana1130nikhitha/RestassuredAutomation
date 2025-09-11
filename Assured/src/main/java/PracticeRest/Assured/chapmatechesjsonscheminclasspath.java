package PracticeRest.Assured;

import io.restassured.RestAssured;

import io.restassured.response.Response;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class chapmatechesjsonscheminclasspath {
	
	@Test	
	public static void test() {
		
	
	RestAssured.baseURI= "https://restful-booker.herokuapp.com";
	
	Response reS = RestAssured.given().contentType("application/json").
			body("{\r\n"
			+ "    \"firstname\": \"Jim\",\r\n"
			+ "    \"lastname\": \"Brown\",\r\n"
			+ "    \"totalprice\": 111,\r\n"
			+ "    \"depositpaid\": true,\r\n"
			+ "    \"bookingdates\": {\r\n"
			+ "        \"checkin\": \"2018-01-01\",\r\n"
			+ "        \"checkout\": \"2019-01-01\"\r\n"
			+ "    },\r\n"
			+ "    \"additionalneeds\": \"Breakfast\"\r\n"
			+ "}").
	when().post("/booking").
	
	then().log().all().
	assertThat()
            .statusCode(200)
            .body(matchesJsonSchemaInClasspath("booking-schema.json"))
            .extract().response();
	
	
	System.out.println(reS);
	
	
	


	}

}
