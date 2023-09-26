package com.ClarusWay.TDD.Homeworks;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class task03 {

    @Test
    public void test(){

        baseURI= "https://restful-booker.herokuapp.com";

        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .queryParams("checkin", "2018-01-01")
                .queryParams("checkout", "2019-01-01")
                .when()
                .get("booking")
                .then()
                .extract().response();

        response.prettyPeek();
    }

@Test
    public void test2(){
    baseURI= "https://restful-booker.herokuapp.com";

    Response response = given()
            .accept(ContentType.JSON)
            .contentType(ContentType.JSON)
            .queryParams("id", "17")
            .when()
            .get("booking")
            .then()
            .extract().response();

    response.prettyPeek();




}





}
