package PracticeRest.Assured;

import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class universities {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//
		RestAssured.baseURI  ="http://universities.hipolabs.com";
		RestAssured.proxy("your.proxy.address", 8080);

		  Response res = 
		RestAssured.given().log().all().
		when().get("http://universities.hipolabs.com/search?country=United+States")
				.then().extract().response();	  
		  
	  System.out.println("response" + res.getBody().asPrettyString());
//		  
//		    		
//		//  JsonObject jsono =  JsonObject(res);;
		  
		  //Print number of universities in Canada


		 JsonPath json = res.jsonPath();
		 
		           List<Map<String ,Object>> universities = json.getList("$");
		         // long count = universities.stream().filter(u-> "canada".equalsIgnoreCase( (String) u.get("country"))).count();
    		//System.out.println(count);
    		//Print the university names in United States
		        long count = universities.stream().filter(u-> "United States".equalsIgnoreCase( (String) u.get("country"))).count();
		    		System.out.println(count);


	          
//		 //  System.out.println( "size :" + json.getString("name"));
//		   
//		
//
//         List<String> names = json.getList("name");
//                 System.out.println(names.size());

		   
	//	Map<String,String> newmm = new HashMap<>
		
	          // String[] collegenames = json.getString("name").split(",");
	            		
		  // System.out.println(collegenames.length) ;
		    		
		 //   System.out.println(res.getBody().asPrettyString());
		    		
		    		//Print number of universities in India
		    		
		  // IntStream.range(0, res.).
		    		
		    
		
		
	}

}
