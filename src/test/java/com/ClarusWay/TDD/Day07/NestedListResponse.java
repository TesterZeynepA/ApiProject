package com.ClarusWay.TDD.Day07;

import com.ClarusWay.TDD.POJO.NestedListPojo.JsonData;
import com.ClarusWay.TDD.POJO.People;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class NestedListResponse {


    @Test(testName = "list nested json object")

    public void testName() {
        RestAssured.baseURI = "https://run.mocky.io/v3/a33f7da9-81b8-4269-bc79-b70040c36613";

        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .when()
                .get()
                .then()
                .extract().response();


       JsonData myResponse = response.jsonPath().getObject("", JsonData.class);
      String people1Name=  myResponse.getPeople().get(0).getName();
        System.out.println("people1Name = " + people1Name);

       People secondPeople = response.jsonPath().getObject("people[1]", People.class);
      String secondNamePeople = secondPeople.getName();
        System.out.println("secondNamePeople = " + secondNamePeople);

      String peopleLocation= myResponse.getPeople().get(2).getCity();
        System.out.println("peopleLocation = " + peopleLocation);

        String industry1= myResponse.getOrganisation().getIndustry();
        System.out.println("industry1 = " + industry1);

        int myAge = secondPeople.getAge();
        System.out.println("myAge = " + myAge);

        People myPeople= response.jsonPath().getObject("people[3]", People.class);
        int age2 = myPeople.getAge();
        System.out.println("age2 = " + age2);

        String nameLast = myPeople.getName();
        System.out.println("nameLast = " + nameLast);

        response.prettyPrint();
    }
}
