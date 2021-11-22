package com.mastek;
import static io.restassured.RestAssured.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import io.restassured.http.ContentType;


@SpringBootTest
public class ProductTests {

	@Test
	void Product_Get() {
		baseURI = "http://localhost:8080/";
		given().

		get("products").then().statusCode(200).
		log().all();
	}
	
	@Test
	void Product_Post() throws JSONException {
		baseURI = "http://localhost:8080/";
		JSONObject request=new JSONObject();
		request.put("name", "apple");
		request.put("price","120000");
		request.put("description", "phone");
		request.put("url", "https://www.apple.in");

		given().
		contentType(ContentType.JSON).accept(ContentType.JSON).
		header("Content-Type","application/json").
		body(request.toString()).
		when().post("product").
		then().statusCode(200).log().all();
	}
	
	@Test
	void Product_Put() throws JSONException{
		baseURI = "http://localhost:8080/";
		JSONObject request=new JSONObject();
		request.put("name", "samsung");
		request.put("price","1200");
		request.put("description", "phone");
		request.put("url", "https://www.samsung.com/in/");

		given().
		contentType(ContentType.JSON).accept(ContentType.JSON).
		header("Content-Type","application/json").
		body(request.toString()).
		when().put("product").
		then().statusCode(200).log().all();
	}
	
	@Test
	void Product_Delete() {
		baseURI = "http://localhost:8080/";
		given().
		delete("product/1").then().statusCode(200);
	}
	
}
