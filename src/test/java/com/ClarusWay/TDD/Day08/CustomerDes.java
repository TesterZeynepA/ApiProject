package com.ClarusWay.TDD.Day08;

import com.ClarusWay.TDD.POJO.Customer;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.*;
public class CustomerDes {

    @Test
    public void  getCustomers(){
        baseURI="http://restapi.adequateshop.com";

        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .when()
                .get("/api/Customer")
                .then()
                .extract().response();

      List<Customer> customers=  response.jsonPath().getList("", Customer.class);

        System.out.println("customers.get(0).getEmail() = " + customers.get(0).getEmail());


        response.prettyPrint();


    }




}
