package PracticeRest.Assured;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class popul {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
			//	RestAssured.baseURI = "https://datausa.io";
				
				  RestAssured.baseURI = "https://datausa.io";

			        Response response = RestAssured
			            .given()

			            .header("Accept", "application/json")
			               .header("User-Agent", "Mozilla/5.0")
			               .redirects().follow(true)
			               .when()
			               .get("/api/data?drilldowns=Nation&measures=Population")
			               .then()
			               .extract()
			               .response();

			           System.out.println("Status Code: " + response.getStatusCode());
			           System.out.println("Response: " + response.getBody().asPrettyString());
			       }
			
				// System.out.println(res.getBody().asPrettyString());		 
			}
			

	}

}
