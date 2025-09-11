package PracticeRest.Assured;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;

public class Chap5eight{

    public static void main(String[] args) {

        // Set base URI
        RestAssured.baseURI = "https://reqres.in";
       RestAssured.useRelaxedHTTPSValidation();

        // Send GET request
        Response response = RestAssured.given()
            .queryParam("page", "2")
            .when()
            .get("/api/users");

        // Convert response to string
        String responseBody = response.getBody().asString();

        // Parse response string into JSON
        JSONObject json = new JSONObject(responseBody);

        // Print top-level keys
        System.out.println("Top-level JSON:");
        
      for (String key: json.keySet()) {
    	  System.out.println(key + ": " + json.get(key));
    	  
    	 //print user data 
    	  System.out.println("\n User data");
    	  JSONArray users = json.getJSONArray("data");
    	  
    	  for (int i = 0; i< users.length(); i++)
    	  {
    		  JSONObject user = users.getJSONObject(i);
    		  
    		  System.out.println("ID: " + user.getInt("id"));
    		  System.out.println("Name:" + user.getString("first_name") + user.getString("last_name"));
    		  System.out.println("Avatar:" + user.getString("avatar")); 
    		  System.out.println("Email:" + user.getString("email"));
    		  
    	  }
      }
        
    }
}