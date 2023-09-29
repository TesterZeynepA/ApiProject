package com.ClarusWay.TDD.Day11;

import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

public class Schema {

    @Test
    public void schemaValidation() {


        baseURI = "http://restapi.adequateshop.com";


        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .when()
                .get("/api/Customer")
                .then()
                .body(schema("Schema/customersResponseSchema.json"))
                .time(lessThan(1000l))
                .extract().response();

        response.prettyPrint();
    }

    public JsonSchemaValidator schema(String path) {
        JsonSchemaValidator schemaValidator = JsonSchemaValidator.matchesJsonSchemaInClasspath(path);
        return schemaValidator;
    }
}
