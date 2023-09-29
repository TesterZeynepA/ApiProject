package com.ClarusWay.TDD.Homeworks.AsanaHomework;


import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class asanaCrud {

    String token;

    @BeforeClass

    public void setUp(){
        baseURI="https://app.asana.com";

        token ="Bearer 1/1205562737331609:9df15efdaea4a665760d54a881dfbae2";
    }

    @Test
    public void createAsanaPost(){

        Members members= new Members();
        members.setGid("1205562737331609");
        members.setResource_type("user zeynep");
        members.setName("Zeynep A");

        List<Members> membersList = new ArrayList<>();
        membersList.add(members);

        Owner owner= new Owner();
        owner.setGid("1205562737331609");
        owner.setResource_type("user Esra");
        owner.setName("Esra A");

        Workspace workspace= new Workspace();
        workspace.setGid("1205541665331966");
        workspace.setResource_type("workspace");
        workspace.setName("cdeter.com");

        Team team= new Team();
        team.setGid("1205601799046677");
        team.setResource_type("team");
        team.setName(",dlsdasdas.'s First Team");

        Followers followers = new Followers();
        followers.setGid("1205562737331609");
        followers.setResource_type("user");
        followers.setName("Testerzzz");

        AsanaPojo asanaPojo= new AsanaPojo();
        asanaPojo.setGid("1205615191012531");
        asanaPojo.setResource_type("project2");
        asanaPojo.setCreated_at("2023-09-29T12;30,669Z");
        asanaPojo.setModified_at("2023-09-29T12;31,660Z");
        asanaPojo.setMembers(members);
        asanaPojo.setOwner(owner);
        asanaPojo.setName("azes");
        asanaPojo.setNotes("");
        asanaPojo.setWorkspace(workspace);
        asanaPojo.setTeam(team);
        asanaPojo.setPermalink_url("https://app.asana.com/0/1205615191012531/1205615191012531");
        asanaPojo.setDefault_view("list");
        asanaPojo.setDefault_access_level("editor");
        asanaPojo.setMinimum_access_level_for_customization("editor");
        asanaPojo.setMinimum_access_level_for_sharing("editor");
        asanaPojo.setColor("dark-green");
        asanaPojo.setFollowers(followers);
        asanaPojo.setIcon("list");

        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("authorization", token)
                .body(asanaPojo)
                .when()
                .post("/api/1.0/projects")
                .then()
                .extract().response();


        response.prettyPrint();

    }





}
