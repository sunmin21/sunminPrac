package com.example.sunminprac.model;

import lombok.*;

import javax.validation.constraints.NotNull;

//@Component
@Setter
@Getter
@ToString
public class userModel {
//public class userInfo implements Serializable {

    @NotNull
    private String userId;
    private String userName;
}
