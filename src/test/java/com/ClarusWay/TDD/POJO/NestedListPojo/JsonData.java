package com.ClarusWay.TDD.POJO.NestedListPojo;

import com.ClarusWay.TDD.POJO.Organisation;
import com.ClarusWay.TDD.POJO.People;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class JsonData {

    private String info;
    private String date;
    private List<People> people;
    private Organisation organisation;


}
