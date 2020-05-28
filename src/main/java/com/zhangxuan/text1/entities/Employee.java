package com.zhangxuan.text1.entities;

import lombok.Data;

/**
 * @author Administrator
 */
@Data
public class Employee {

	private Integer id;
    private String lastName;
    private String email;
    //1 male, 0 female
    private Integer gender;
    private Integer d_id;
    private Department department;

}
