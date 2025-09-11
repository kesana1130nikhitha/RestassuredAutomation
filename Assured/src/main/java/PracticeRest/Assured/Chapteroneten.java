package PracticeRest.Assured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import static org.hamcrest.Matchers.*;
public class Chapteroneten {
	
	public static void main(String[] args) {
		
		RestAssured.baseURI= "https://restful-booker.herokuapp.com";
		
 RestAssured.given().contentType("application/json").
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
				+ "}").when().post("/booking").then() .log().all(
					).rootPath("booking").body("additionalneeds",equalTo("Breakfast"))
 .rootPath("booking.bookingdates").
 body("checkin",equalTo("2018-01-01") );
 
// body("booking.firstname", equalTo("Jim"))
// .body("booking.lastname", equalTo("Brown"))
//		 .body("booking.totalprice", equalTo(111))
//		 .body("booking.bookingdates.checkin",equalTo("2018-02-01") );
//		
		 
 
 //.log().all().assertThat().statusCode(200);
	 
	// System.out.println(res);
	 
		
		
		
	}

}
