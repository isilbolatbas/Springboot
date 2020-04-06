package com.example;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;


@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "Benim pet nesnem", description = "Beni Pet")
public class Pet {

    @ApiModelProperty(value = "pet nesnesinin unique id alani")
    private int id;
    @ApiModelProperty(value = "pet nesnesinin ad alani")
    private String adi;
    @ApiModelProperty(value = "pet nesnesinin tarih alani")
    private Date date;
}
