package com.ClarusWay.TDD.Day03;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class PathWithList {
    @Test
    public void pathWithList() {

        baseURI = "http://restapi.adequateshop.com";

        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .when()
                .get("/api/Customer")
                .then()
                .extract().response();

       int id1 = response.path("id[0]");
        System.out.println("id1 = " + id1);
//Response u list olan payload lardan ata çekip alabilmemiz için index kullanıyoruz.[index]

        Assert.assertEquals(id1,270230);

       List <Integer>idList= response.path("id");
        System.out.println("idList = " + idList);

        String lastName = response.path("name[-1]");
        System.out.println("lastName = " + lastName);

       List<Integer> databaseUserIds=  Arrays.asList(270230, 270229, 270227, 270226, 270224, 270223, 270221, 270219, 269615, 269611, 269609, 269605, 269604, 269596, 269595, 269594, 269593, 269592, 269591, 269590);
       Assert.assertEquals(idList,databaseUserIds);


        String name1 = response.path("name[1]");
        System.out.println("name1 = " + name1);

        String email1 = response.path("email[1]");
        System.out.println("email1 = " + email1);

        System.out.println("\n");
        System.out.println("--------------------------------");


        response.prettyPrint();
    }


}
