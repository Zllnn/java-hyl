package com.hyl.hyl.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String userName;
    private String loginName;
    private String password;
    private String email;
    private String  code;
    private String studentId;
    private int id;
}
