package apiTests;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

/**
 * @author Vethiga
 *
 * 
 */
public class UnirestHttpRequestExample {


	public static void GETRequest() throws UnirestException {

		HttpResponse<JsonNode> JSONResponse=Unirest.get("https://jsonplaceholder.typicode.com/posts").asJson();
		System.out.println("Status Code for GET Request : "+JSONResponse.getStatus());
		System.out.println("Status Message for GET Request : "+JSONResponse.getStatusText());
		System.out.println("Response Body for GET Request : "+JSONResponse.getBody());

	}

	public static void POSTRequest() throws UnirestException {

		HttpResponse<JsonNode> JSONResponse=Unirest.post("https://jsonplaceholder.typicode.com/posts").header("Content-Type", "application/json")
				.body("{ \"id\":\"87985\", \"title\":\"apiTest\", \"body\":\"AP86III\",\"userId\":\"86002\"}").asJson();
		
		System.out.println("Status Code for POST Request : "+JSONResponse.getStatus());
		System.out.println("Status Message for POST Request : "+JSONResponse.getStatusText());
		System.out.println("Response Body for POST Request : "+JSONResponse.getBody());

	}
	
	
	public static void PUTRequest() throws UnirestException {

		HttpResponse<JsonNode> JSONResponse=Unirest.put("https://jsonplaceholder.typicode.com/posts/1").header("Content-Type", "application/json")
				.body("{ \"id\":\"87985\", \"title\":\"ChangingTitleValue\", \"body\":\"AP86III\",\"userId\":\"86002\"}").asJson();
		
		System.out.println("Status Code for PUT Request : "+JSONResponse.getStatus());
		System.out.println("Status Message for PUT Request : "+JSONResponse.getStatusText());
		System.out.println("Response Body for PUT Request : "+JSONResponse.getBody());

	}
	
	public static void DELETERequest() throws UnirestException {

		HttpResponse<JsonNode> JSONResponse=Unirest.delete("https://jsonplaceholder.typicode.com/posts/1").asJson();
		
		System.out.println("Status Code for DELETE Request : "+JSONResponse.getStatus());
		System.out.println("Status Message for DELETE Request : "+JSONResponse.getStatusText());
		System.out.println("Response Body for DELETE Request : "+JSONResponse.getBody());

	}
	

	public static void main(String[] args) throws UnirestException {
		GETRequest();
		POSTRequest();
		PUTRequest();
		DELETERequest();
		
	}

}
