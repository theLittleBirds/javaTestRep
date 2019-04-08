package com.zd.rabbitmq_direct1;

import lombok.Data;

import java.io.Serializable;

/*
 *  Creat by zhoudi on 2019/3/19.
 */

@Data
public class User implements Serializable {

    private String userName;

    private String passWord;

    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                '}';
    }
}
