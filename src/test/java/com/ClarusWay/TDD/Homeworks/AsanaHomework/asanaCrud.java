package com.ClarusWay.TDD.Homeworks.AsanaHomework;


import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class asanaCrud {
    @BeforeClass

    public void setUp(){
        baseURI="https://app.asana.com";

    }

    @Test
    public void createAsana(){

        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
               // .body()
                .when()
                .post("/api/1.0/projects")
                .then()
                .extract().response();






    }





}
