package com.my.project.domain;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import java.util.Date;

@Data
public class UserDto {

    private String id;
    private String pwd;
    private String name;
    @Email
    private String email;
    private String phone;
    private String address;
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private Date reg_date;

}
