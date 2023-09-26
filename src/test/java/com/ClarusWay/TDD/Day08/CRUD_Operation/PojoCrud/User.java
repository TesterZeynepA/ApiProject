package com.ClarusWay.TDD.Day08.CRUD_Operation.PojoCrud;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class User {
    @JsonProperty("id")
    private int id;

    private String name;
    private String email;
    private String location;

}
