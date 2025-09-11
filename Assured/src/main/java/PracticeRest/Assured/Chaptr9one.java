package PracticeRest.Assured;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import static org.hamcrest.Matchers.equalTo;





public class Chaptr9one {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// status code
		
		RestAssured.baseURI = "https://restful-booker.herokuapp.com";
		
		    String res = RestAssured.given().contentType(ContentType.JSON).log().all()
		
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
				+ "}").
		when().post("/booking").
		then().extract().response().asString();
		    
			System.out.println("--------------------");    
		System.out.println(res);

		   
		
		//headers("Content-Type", equalTo("application/json; charset=utf-8") , "Server" , equalTo("eroku"));
		//extract().response();
//		System.out.println( res.statusCode());
//		System.out.println( res.statusLine());
//		System.out.println( res.header("Content-Type"));
//		System.out.println( res.headers());
	//	System.out.println( res.header("Content-Type", equalTo("Application/json; charset=utf-8")));
		
		
		
		
	
		

	}

}
