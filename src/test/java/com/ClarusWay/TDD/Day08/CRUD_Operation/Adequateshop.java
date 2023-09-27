package com.ClarusWay.TDD.Day08.CRUD_Operation;

import com.ClarusWay.TDD.Day08.CRUD_Operation.PojoCrud.User;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class Adequateshop {

    @BeforeClass
    public void testName() {

        baseURI = "http://restapi.adequateshop.com";
    }

    @Test
    public void createUserString() {

        String myPayload = "{\n" +
                "  \"id\": 12427,\n" +
                "  \"name\": \"zeynep\",\n" +
                "  \"email\": \"testerzeynep@gmail.com\",\n" +
                "  \"location\": \"Istanbul\"\n" +
                "}";

        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(myPayload)
                .when()
                .post("/api/Customer")
                .then()
                .extract().response();


        response.prettyPeek();
    }

    @Test
    public void createUserMap() {

        Map<String, Object> payload= new HashMap<>();

        payload.put("id", 571);
        payload.put("name", "mapName");
        payload.put("email", "map7@gmail.com");
        payload.put("location", "ankara");

        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(payload)// bu kısım çok önemli unutma!!! Post içindeki body bu kısımdan gidiyor
                .when()
                .post("/api/Customer")
                .then()
                .extract().response();


        response.prettyPeek();
    }

    @Test
    public void createUserPOJO() {

        User user = new User();
        user.setId(343);
        user.setName("pojoPost");
        user.setEmail("5711245@gmail.com");
        user.setLocation("Istanbul");

        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(user)
                .when()
                .post("/api/Customer")
                .then()
                .extract().response();


        response.prettyPeek();
    }
    @Test
    public void createUserFile() {

        String path = "src/test/java/com/ClarusWay/TDD/Day08/CRUD_Operation/PojoCrud/MyUser.json";

        String myPayload = jsonFileStringify(path);

        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(myPayload)
                .when()
                .post("/api/Customer")
                .then()
                .extract().response();


        response.prettyPeek();
    }

    public String jsonFileStringify(String path){
        String payload;
        try {
            payload=  new String(Files.readAllBytes(Paths.get(path)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return payload;

    }

    @Test
    public void jsonFileUpdate(){

        updateJsonFile("id", 1,
                "src/test/java/com/ClarusWay/TDD/Day8/Crud_Op/PojoCrud/MyUser.json");
        updateJsonFile("interests[0]",
                "dataClarus", "src/test/java/com/ClarusWay/TDD/Day8/Crud_Op/PojoCrud/ComplexJson.json");
        updateJsonFile("objectList[0].item",
                "clarusway working",
                "src/test/java/com/ClarusWay/TDD/Day8/Crud_Op/PojoCrud/ComplexJson.json");


    }

    public static  <T> void updateJsonFile(String key, T value, String filePath){
        String jsonString = null;
        try {
            jsonString = Files.readString(Paths.get(filePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        DocumentContext context = JsonPath.parse(jsonString.toString());
        context.set("$." + key, value);
        try {
            Files.write(Paths.get(filePath), context.jsonString().getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);

    }

    }

}
