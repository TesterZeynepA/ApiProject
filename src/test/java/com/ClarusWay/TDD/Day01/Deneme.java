package com.ClarusWay.TDD.Day01;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class Deneme {
    public static void main(String[] args) {

        System.out.println();
        System.out.println();


    }
    @Test
    public void test1(){
       Response response= RestAssured.given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .when()
                .get("http://restapi.adequateshop.com/api/Customer")
                .then()
                .extract().response();
        response.prettyPeek();

    }
}
