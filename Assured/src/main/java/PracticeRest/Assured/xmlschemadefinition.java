package PracticeRest.Assured;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class xmlschemadefinition {

	 @Test
   public void test1() {
        // Define the inline XSD schema
        String xsdString = """
        <?xml version="1.0" encoding="UTF-8"?>
        <xs:schema xmlns:xs="http://www.w3.org/2001/XMLSchema">
            <xs:element name="booking">
                <xs:complexType>
                    <xs:sequence>
                        <xs:element name="firstname" type="xs:string"/>
                        <xs:element name="lastname" type="xs:string"/>
                        <xs:element name="totalprice" type="xs:int"/>
                        <xs:element name="depositpaid" type="xs:boolean"/>
                        <="xs:string"/>
                                </xs:sequence>
                            </xs:complexType>
                        </xs:element>
                        <xs:element name="additionalneeds" type="xs:string" minOccurs="0"/>
                    </xs:sequence>
                </xs:complexType>
            </xs:element>
        </xs:schema>
        """;

        // Set base URI
        RestAssured.baseURI = "https://restful-booker.herokuapp.com";

        // Send GET request and validate response
        Response response = given()
            .contentType("application/xml")
            .accept("application/xml")
        .when()
            .get("/booking/119")
        .then()
            .assertThat()
            .statusCode(200)
            .body(matchesXsd(xsdString))
            .extract()
            .response();

        // Print the response body
        System.out.println("Response Body:");
        System.out.println(response.asString());
    }
}
