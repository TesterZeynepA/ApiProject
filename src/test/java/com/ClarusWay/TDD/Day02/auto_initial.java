package com.ClarusWay.TDD.Day02;

import io.restassured.http.ContentType;
import io.restassured.internal.RestAssuredResponseImpl;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.*;

public class auto_initial {
    private RestAssuredResponseImpl response;

    @Test

    public void test1(){
       Response response= given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .when()
                .get("http://restapi.adequateshop.com/api/Customer")
                .then()
                .extract().response();

       response.prettyPrint();
       response.prettyPeek();

       Assert.assertEquals(response.statusCode(), 200);

       Assert.assertEquals(response.contentType(), "application/json; charset=utf-8");

       String responseBody = response.asString();

      boolean bodyIdCheck = responseBody.contains("269512");


        Assert.assertTrue(bodyIdCheck);

        boolean dateAssert = response.headers().hasHeaderWithName("Date");
        Assert.assertTrue(dateAssert);

    }

    @Test
    public void test2(){
        Assert.fail();
    }

    @Test
    public void test3(){

/** TASKKK
 * Given accept type is Json
 * And Id parameter value is 3
 * When user sends GET request to /api/users
 * Then response status code should be 200
 * And response content-type: application/json
 * And "emma.wong@reqres.in" should be in response payload
 */

        baseURI = "https://reqres.in";

        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .pathParam("id", 3)
                .when()
                .get("/api/users/{id}")
                .then()
                .extract().response();

        Assert.assertEquals(response.statusCode(),200);
        Assert.assertEquals(response.contentType(),"application/json; charset=utf-8");

        response.prettyPeek();
    }
}
