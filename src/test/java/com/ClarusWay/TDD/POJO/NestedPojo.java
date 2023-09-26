package com.ClarusWay.TDD.POJO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class NestedPojo {
    private String info;
    private String date;
    private People people;
    private Organisation organisation;


}
