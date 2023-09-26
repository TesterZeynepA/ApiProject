package com.ClarusWay.TDD.Day04;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;

public class ComplexBody {

    @Test
    public void test(){
        baseURI ="http://restapi.adequateshop.com";
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .queryParams("page", 55)
                .when()
                .get("/api/Tourist")
                .then()
                .extract().response();

        int sayfa=response.path("page");
        Assert.assertEquals(sayfa,55);
        System.out.println("sayfa = " + sayfa);

        String firstDataName = response.path("data.tourist_name[0]");
        System.out.println("firstDataName = " + firstDataName);

        response.prettyPrint();

    }






}
