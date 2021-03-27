package apiTests;
/**
 * @author Vethiga
 *
 * 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class HttpURLConnectionExample {

	public static void GETMethod() throws IOException {
		URL url=new URL("https://jsonplaceholder.typicode.com/posts/1");
		HttpsURLConnection connection =(HttpsURLConnection) url.openConnection();
		connection.setRequestMethod("GET");
		connection.connect();

		int StatusCode=connection.getResponseCode();
		String StatusMessage=connection.getResponseMessage();
		System.out.println("Status Code for GET method : "+StatusCode);
		System.out.println("Status Message for GET method : "+StatusMessage);

		InputStream inputStream=connection.getInputStream();
		InputStreamReader inputStreamReader=new InputStreamReader(inputStream);

		BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
		String Line;
		StringBuffer buffer=new StringBuffer(); // here we're using buffer, because buffer is mutable. so it get changed, when loop is running

		while((Line=bufferedReader.readLine())!=null) {
			buffer.append(Line);
		}
		System.out.println(buffer);

	}


	public static void POSTMethod() throws IOException {

		URL url = new URL("https://jsonplaceholder.typicode.com/posts");
		HttpsURLConnection connection=(HttpsURLConnection) url.openConnection(); // due to typecast (HttpsURLConnection) this is used.
		//  Urlconnection vs httpsurlconnection

		connection.setRequestMethod("POST");
		connection.setRequestProperty("Content-Type", "application/json");

		connection.setDoOutput(true);  // for get Method it's false by default, for POST method(Creating resources) it's true.
		String JSONBody="{ \"id\":\"875\", \"title\":\"Test\", \"body\":\"APIII\",\"userId\":\"1990\"}";

		byte[] inputJSON=JSONBody.getBytes();
		
		OutputStream outputStream=connection.getOutputStream();
		outputStream.write(inputJSON);

		
		System.out.println("Response Code for POST method :"+connection.getResponseCode());
		System.out.println("Response Message for POST method : "+connection.getResponseMessage());
		
		InputStream inputStream=connection.getInputStream();
		InputStreamReader inputStreamReader=new InputStreamReader(inputStream);
		
		BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
		String Line;
		StringBuffer buffer=new StringBuffer();
		
		while((Line=bufferedReader.readLine())!=null) {
			buffer.append(Line);
		}
		
		System.out.println(buffer);
	}

	
	public static void PUTMethod() throws IOException {
		
		URL url = new URL("https://jsonplaceholder.typicode.com/posts/1");
		HttpsURLConnection connection=(HttpsURLConnection) url.openConnection(); // due to typecast (HttpsURLConnection) this is used.
		//  Urlconnection vs httpsurlconnection

		connection.setRequestMethod("PUT");
		connection.setRequestProperty("Content-Type", "application/json");

		connection.setDoOutput(true);  // for get Method it's false by default, for POST method(Creating resources) it's true.
		String JSONBody="{ \"id\":\"875\", \"title\":\"Test\", \"body\":\"APIII\",\"userId\":\"2002\"}";

		byte[] inputJSON=JSONBody.getBytes();
		
		OutputStream outputStream=connection.getOutputStream();
		outputStream.write(inputJSON);

		
		System.out.println("Response Code for PUT method :"+connection.getResponseCode());
		System.out.println("Response Message for PUT method : "+connection.getResponseMessage());
		
		InputStream inputStream=connection.getInputStream();
		InputStreamReader inputStreamReader=new InputStreamReader(inputStream);
		
		BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
		String Line;
		StringBuffer buffer=new StringBuffer();
		
		while((Line=bufferedReader.readLine())!=null) {
			buffer.append(Line);
		}
		
		System.out.println(buffer);
		
	}
	
	
	public static void DELETEMethod() throws IOException {
		
		URL url = new URL("https://jsonplaceholder.typicode.com/posts/1");
		HttpsURLConnection connection=(HttpsURLConnection) url.openConnection(); // due to typecast (HttpsURLConnection) this is used.
		//  Urlconnection vs httpsurlconnection

		connection.setRequestMethod("DELETE");
		connection.setRequestProperty("Content-Type", "application/json");

		connection.setDoOutput(true);  // for get Method it's false by default, for POST method(Creating resources) it's true.
		
		System.out.println("Response Code for DELETE method :"+connection.getResponseCode());
		System.out.println("Response Message for DELETE method : "+connection.getResponseMessage());
		
		InputStream inputStream=connection.getInputStream();
		InputStreamReader inputStreamReader=new InputStreamReader(inputStream);
		
		BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
		String Line;
		StringBuffer buffer=new StringBuffer();
		
		while((Line=bufferedReader.readLine())!=null) {
			buffer.append(Line);
		}
		
		System.out.println(buffer);
		
	}
	
	
	public static void main(String[] args) throws IOException {
		GETMethod();
		POSTMethod();
		PUTMethod();
		DELETEMethod();
	}

}
