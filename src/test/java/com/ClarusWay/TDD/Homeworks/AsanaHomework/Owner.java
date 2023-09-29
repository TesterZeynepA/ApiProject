package com.ClarusWay.TDD.Homeworks.AsanaHomework;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonPropertyOrder({
        "gid",
        "resource_type",
        "name"
})
public class Owner {

    @JsonProperty
    private String gid;
    @JsonProperty
    private String resource_type;
    @JsonProperty
    private String name;
}
