package com.ClarusWay.TDD.Day07;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class Basic_Deserialization {
    @Test
    public void getCustomer(){
        baseURI="http://restapi.adequateshop.com";

        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .pathParam("id", 270684)
                .when()
                .get("/api/Customer/{id}")
                .then()
                .extract().response();

        Map<String,Object> exampleBody = new HashMap<>();
        exampleBody.put("id", 270684);
        exampleBody.put("name", "ss");
        exampleBody.put("email", "wdddeee");
        exampleBody.put("location", "grr");

      Map<String,Object> responseBody=  response.as(Map.class);

        System.out.println(responseBody.get("id"));

        System.out.println(responseBody.get("name"));
        System.out.println(responseBody.get("email"));
        System.out.println(responseBody.get("location"));

        Assert.assertEquals(responseBody.get("id"), 270684);

        System.out.println("responseBody.values() = " + responseBody.values());
        //responseBody.values() = [270684, ss, wdddeee, grr]


        response.prettyPrint();
    }

    @Test
    public void getCostumers(){
        baseURI ="http://restapi.adequateshop.com";

        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .when()
                .get("/api/Customer")
                .then()
                .extract().response();

        //1. yöntem: Deserialization list

        List<Map<String,Object>> bodyList = response.as(List.class);

      String name3= bodyList.get(2).get("name").toString();
        System.out.println("name3 = " + name3);

        //2. yöntem: Deserialization array

        Map <String,Object> bodyArray[] = response.as(Map[].class);

        System.out.println("bodyArray[2].get(\"name\") = " + bodyArray[2].get("name"));

        //3. yöntem: Deserialization jsonPath() method

        List<Map> listWithMap =response.jsonPath().getList("", Map.class);
        System.out.println("listWithMap.get(0).get(\"id\") = " + listWithMap.get(0).get("id"));


        response.prettyPrint();









    }
}
