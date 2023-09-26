package com.ClarusWay.TDD.Homeworks;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class task01 {

    @Test
    public void test1(){
        baseURI="https://restful-booker.herokuapp.com";

        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .queryParams("firstname", "Jim")
                .queryParams("lastname", "Brown")
                .when()
                .get("/booking")
                .then()
                .extract().response();

        response.prettyPeek();

    }







}
