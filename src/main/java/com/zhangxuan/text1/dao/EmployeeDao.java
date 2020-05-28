package com.zhangxuan.text1.dao;


import com.zhangxuan.text1.entities.Employee;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Administrator
 */
@Mapper
@Repository
public interface EmployeeDao {

	/**
	 * 查找employee表的所有用户信息
	 * @return
	 */
    @Select("select id,lastName,email,gender,d_id from employee")
    @Results(id = "empMap",
            value = {
                    @Result(column = "d_id", property = "department", one = @One(select = "com.zhangxuan.text1.dao.DepartmentDao.findById"))
            }
    )
    List<Employee> findAll();

	/**
	 * 根据id查询employee表的用户
	 * @param id
	 * @return
	 */
    @Select("select * from employee where id=#{id}")
    @ResultMap("empMap")
    Employee findById(Integer id);

	/**
	 * 添加用户
	 * @param employee
	 */
    @Insert("insert into employee(lastName,email,gender,d_id)" +
            "values(#{lastName},#{email},#{gender},#{d_id})")
    void insertEmp(Employee employee);

	/**
	 * 更新employee表的用户
	 * @param employee
	 */
    @Update("update employee set lastName=#{lastName},email=#{email},gender=#{gender},d_id=#{d_id} where id=#{id}")
    void updateEmp(Employee employee);

	/**
	 * 删除employee表的用户
	 * @param id
	 */
    @Delete("delete from employee where id=#{id}")
    void deleteEmp(Integer id);

}
