
package PracticeRest.Assured;

import static io.restassured.RestAssured.given;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class SizeOfList{

    @Test
    public void testBookingSize() {

        // Set base URI
        RestAssured.baseURI = "https://restful-booker.herokuapp.com";

        // Send POST request
        Response response = given()
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
                + " booking object: " + bookingMap.size());

        // Print full response
        System.out.println("Response Body:");
        System.out.println(response.asPrettyString());
    }
}
