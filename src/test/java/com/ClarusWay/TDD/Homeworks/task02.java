package com.ClarusWay.TDD.Homeworks;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class task02 {
    /*
        Given
            http://api.zippopotam.us/ES/01001
       When
            Kullanıcı GET Methodu ile Request Gönder
        Then
             Status Code un "200" olduğunu Assert et
        And
            Response body nin  "country": "Spain" içerdiğini doğrula


     */

    @Test
    public void test2(){

        baseURI= "http://api.zippopotam.us";

        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .queryParams("country","Spain")
                .when()
                .get("/ES/01001")
                .then()
                .extract().response();

        Assert.assertEquals(200, response.statusCode());

        response.prettyPeek();
    }
}
