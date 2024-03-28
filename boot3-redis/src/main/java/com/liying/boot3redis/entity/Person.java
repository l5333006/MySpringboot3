package com.liying.boot3redis.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Person {
    private  Long id;
    private String name;
    private Integer age;
    private String gender;
    private String address;


}
