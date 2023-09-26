package com.ClarusWay.TDD.Day07;

import com.ClarusWay.TDD.POJO.NestedPojo;
import com.ClarusWay.TDD.POJO.People;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.codehaus.groovy.runtime.callsite.PerInstancePojoMetaClassSite;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class NestedResponse {

    @Test(testName = "only nested json object")
    public void nestedPojo() {

        RestAssured.baseURI = "https://run.mocky.io/v3/bb1026ef-3df0-49f4-bc7e-4fac312fbf34";

        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .when()
                .get()
                .then()
                .extract().response();

        NestedPojo myWholeJson = response.jsonPath().getObject("", NestedPojo.class);

        String date = myWholeJson.getDate();
        System.out.println("date = " + date);

        String info = myWholeJson.getInfo();
        System.out.println("info = " + info);

        People people = myWholeJson.getPeople();

        String peopleName = myWholeJson.getPeople().getName();
        System.out.println("peopleName = " + peopleName);

        String compName = myWholeJson.getOrganisation().getCompany();
        System.out.println("compName = " + compName);


        response.prettyPrint();

    }
}
