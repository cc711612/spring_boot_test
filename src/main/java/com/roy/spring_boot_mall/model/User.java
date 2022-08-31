package com.roy.spring_boot_mall.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.Date;

@Data
public class User {

    private Integer userId;
    private String email;
    @JsonIgnore
    private String password;
    private Date createdDate;
    private Date lastModifiedDate;
}
