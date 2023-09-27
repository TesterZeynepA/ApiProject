package com.ClarusWay.TDD.Day09.POJO_Pet;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Category {

    @JsonProperty("id")
    private  int id;
    @JsonProperty("name")
    private String name;

}
