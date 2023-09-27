package com.ClarusWay.TDD.Day09.POJO_Pet;

import com.fasterxml.jackson.annotation.*;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.testng.annotations.Test;

import java.util.List;

@Getter
@Setter
@ToString
@JsonPropertyOrder(
        {
                "id",
                "name",
                "category"        }
)
@JsonIgnoreProperties(ignoreUnknown = true)

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Pet {

    /* @JsonProperty("id") bu annotation field isimlerini json file daki gibi yapmanızı sağlıyor.
    bazen json fieldlar javanın kabul etmediği bir formatta olduğu için kullanmamız gerekiyor.*/


    /*
    * @JsonPropertyOrder bu annotation gönderdiğimiz fieldların sırasını yapmamızı sağlıyor.
    * */

    /*
    * @JsonIgnoreProperties(ignoreUnknown = true) gelen sabit olmayan fieldların deserialization
    *  yapmamızı sağlıyor.
    * */
    //@JsonIgnore sonra açıklanacak.

    /*@JsonInclude(JsonInclude.Include.NON_NULL) bu kısımda ise sadece set ettiğimiz değerlerin body içerisinde
    request yapılmasını sağlıyor set etmediğimiz değerler null bile olsa     */



    @JsonProperty("id")
    private int id;
    @JsonProperty("category")
    private Category category;

    @JsonProperty("name")
    @JsonIgnore
    private String name;
    @JsonProperty("photoUrls")
    private List<String> photoUrls;
    @JsonProperty("tags")
    private List<Tags> tags;
    @JsonProperty("status")
    private String status;



}
