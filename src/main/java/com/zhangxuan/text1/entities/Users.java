package com.zhangxuan.text1.entities;

import lombok.Data;
import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * @author Administrator
 */
@Data
public class Users {

    private Integer id;

    private String username;

    private String password;
}
