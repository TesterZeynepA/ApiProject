package com.ClarusWay.TDD.Day07;

import com.ClarusWay.TDD.POJO.Customer;
import com.ClarusWay.TDD.POJO.PurchasePJ;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;


public class pojo_Giris {

    @Test
    public void getCustomerBasic(){

        baseURI="https://petstore.swagger.io/v2";

        Response response =given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .pathParam("orderId",7)
                .when()
                .get("/store/order/{orderId}")
                .then()
                .extract().response();


        PurchasePJ purchase = response.as(PurchasePJ.class);

       int myID=  purchase.getId();
        System.out.println("myID = " + myID);

        int myPetID= purchase.getPetId();
        System.out.println("myPetID = " + myPetID);

        boolean myComplete= purchase.isComplete();
        System.out.println("myComplete = " + myComplete);


        response.prettyPrint();

    }
    @Test
    public void getCustomer() {


        baseURI = "http://restapi.adequateshop.com";


        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .pathParam("id", 270684)
                .when()
                .get("/api/Customer/{id}")
                .then()
                .extract().response();

        Customer customer1= response.as(Customer.class);

        int myId= customer1.getId();
        System.out.println("myId = " + myId);

        System.out.println("customer1.getEmail() = " + customer1.getEmail());

        Customer customer2= response.jsonPath().getObject("",Customer.class);
        System.out.println("customer2 = " + customer2);


        response.prettyPrint();

    }


}
