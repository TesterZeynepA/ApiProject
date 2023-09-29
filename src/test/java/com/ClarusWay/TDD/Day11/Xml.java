package com.ClarusWay.TDD.Day11;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class Xml {
    @BeforeClass
    public void setUp(){

        baseURI="http://restapi.adequateshop.com";
    }

    @Test
    public void testName(){

        Response response = given()
                .accept(ContentType.XML)
                .contentType(ContentType.XML)
                .when()
                .get("/api/Traveler")
                .then()
                .extract().response();


       int page= response.xmlPath().getInt("TravelerinformationResponse.page");
        System.out.println("page = " + page);

        int per_page= response.xmlPath().getInt("TravelerinformationResponse.per_page");
        System.out.println("per_page = " + per_page);

         int firstID=response.xmlPath().getInt("TravelerinformationResponse.travelers.Travelerinformation[0].id");
        System.out.println("firstID = " + firstID);

        List<Integer> allId= response.xmlPath().getList("TravelerinformationResponse.travelers.Travelerinformation.id");
        System.out.println("allId = " + allId);




        response.prettyPrint();



    }





}
