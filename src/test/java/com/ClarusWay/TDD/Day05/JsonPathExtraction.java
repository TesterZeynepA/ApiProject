package com.ClarusWay.TDD.Day05;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
public class JsonPathExtraction {


    @Test
    public void task1() {


        baseURI = "http://restapi.adequateshop.com";


        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .when()
                .get("/api/Customer")
                .then()
                .extract().response();

        int id1 = response.path("id[0]");
        System.out.println("id1 = " + id1);


        int id1JsonPath = response.jsonPath().getInt("id[0]");
        System.out.println("id1JsonPath = " + id1JsonPath);

        String name1JsonPath = response.jsonPath().getString("name[0]");
        System.out.println("name1JsonPath = " + name1JsonPath);





        response.prettyPrint();

    }



}
