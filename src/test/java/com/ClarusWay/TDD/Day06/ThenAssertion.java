package com.ClarusWay.TDD.Day06;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static java.util.function.Predicate.not;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.is;

public class ThenAssertion {

        @Test
        public void thenAssertion() {

            baseURI = "http://restapi.adequateshop.com";

            Response response = given()
                    .accept(ContentType.JSON)
                    .contentType(ContentType.JSON)
                    .when()
                    .get("/api/Tourist")
                    .then()
                    .statusCode(200)
                    .header("Pragma", "no-cache")
                    .header("Date", is(Matchers.not(nullValue())))
                    .body("page",is(1))
                    .body("data[0].tourist_name",equalTo("gaurav"))


                    .extract().response();

            response.path("page");


            response.prettyPrint();
        }

}
