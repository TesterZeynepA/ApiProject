package com.ClarusWay.TDD.Homeworks.AsanaHomework;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonPropertyOrder(
        {
                "gid",
                "resource_type",
                "created_at",
                "modified_at"
        }
)
public class AsanaPojo {

    @JsonProperty
    private String gid;
    @JsonProperty
    private String resource_type;
    @JsonProperty
    private String created_at;
    @JsonProperty
    private String modified_at;
    @JsonProperty
    private Members members;
    @JsonProperty
    private Owner owner;
    @JsonProperty
    private String name;
    @JsonProperty
    private String notes;
    @JsonProperty
    private Workspace workspace;
    @JsonProperty
    private Team team;
    @JsonProperty
    private String permalink_url;
    @JsonProperty
    private String default_view;
    @JsonProperty
    private String default_access_level;
    @JsonProperty
    private String minimum_access_level_for_customization;
    @JsonProperty
    private String minimum_access_level_for_sharing;
    @JsonProperty
    private String color;
    @JsonProperty
    private Followers followers;
    @JsonProperty
    private String icon;


}
