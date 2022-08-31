package com.roy.spring_boot_mall.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;


public class UserRegisterRequest {
    @NotBlank(message = "信箱不得為空")
    private String email;
    @NotBlank(message = "密碼不得為空")
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
