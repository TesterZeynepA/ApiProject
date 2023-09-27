package com.ClarusWay.TDD.Day09;

import com.ClarusWay.TDD.Day09.POJO_Pet.Category;
import com.ClarusWay.TDD.Day09.POJO_Pet.Pet;
import com.ClarusWay.TDD.Day09.POJO_Pet.Tags;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import io.restassured.RestAssured.*;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class Crud {
    @BeforeClass
    public void setUp(){

        baseURI= "https://petstore.swagger.io/v2";
    }

    public int myId;
    @Test

    public void createPet(){

        Category category= new Category();
        category.setId(12);
        category.setName("cat clarus");

        Tags tags= new Tags();
        tags.setId(1);
        tags.setName("tags clarus name");

        List<Tags> tagsList= new ArrayList<>();
        tagsList.add(tags);


       // List<String> list = new ArrayList<>();
       // list.add("dog");
       // list.add("elephant");

        Pet pet = new Pet();
        pet.setId(243);
        pet.setCategory(category);
        pet.setName("my pet is cat");
        pet.setPhotoUrls(Arrays.asList("myUrl.com"));
        pet.setTags(tagsList);
        pet.setStatus("free");

        Response response= given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(pet)
               // .log().all() when den önce olduğundan dolayı gönderdiğimiz bilgilerin çıktılarını görüyoruz
                .when()
                .post("/pet")
                .then()
                .body("id", is(243))
                .extract().response();

        myId=  response.path("id");
        System.out.println(myId);

        response.prettyPrint();
    }

    @Test
    public void getPetByID(){
        Response response= given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                //.pathParam("petId", myId)
                .pathParam("petId", 243)
                .when()
                .get("/pet/{petId}")
                .then()
                .extract().response();


        response.prettyPrint();

    }

    @Test
    public void updatePet(){

        Category category= new Category();
        category.setId(121);
        category.setName("updated cat clarus");

        Tags tags= new Tags();
        tags.setId(1);
        tags.setName("updated tags clarus name");

        List<Tags> tagsList= new ArrayList<>();
        tagsList.add(tags);


        // List<String> list = new ArrayList<>();
        // list.add("dog");
        // list.add("elephant");

        Pet pet = new Pet();
        pet.setId(243);
        pet.setCategory(category);
        pet.setName("updated my pet is cat");
        pet.setPhotoUrls(Arrays.asList("myUrl.com"));
        pet.setTags(tagsList);
        pet.setStatus("free");


        Response response= given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(pet)
                .when()
                .put("/pet")
                .then()
                .extract().response();

        response.prettyPrint();

    }

    @Test
    public void deletePet(){
        Response response= given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .pathParam("petId", 243)
                .when()
                .delete("/pet/{petId}")
                .then()
                .extract().response();

        response.prettyPrint();

    }

}
