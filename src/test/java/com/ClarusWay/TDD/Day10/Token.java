package com.ClarusWay.TDD.Day10;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class Token {

    String token;

    @BeforeClass
    public void setUp(){

        baseURI= "https://bookstore.toolsqa.com";

        token= "Bearer " + getToken();

    }

    public String getToken(){

        Map<String,Object> payload = new HashMap<>();
        payload.put("userName", "clarusWayAuth");
        payload.put("password", "Test!.123852753");

        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(payload)
                .when()
                .post("/Account/v1/GenerateToken")
                .then()
                .extract().response();

       token= response.path("token");

        return token;
    }

    @Test
    public void test2(){

        System.out.println("Test class working");

           Response response= given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("authorization", token)
                .when()
                .get("/BookStore/v1/Books")
                .then()
                .extract().response();

           response.prettyPeek();

    }



}
