package com.zhangxuan.text1.dao;


import com.zhangxuan.text1.entities.Department;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * @author Administrator
 */
@Mapper
@Repository
public interface DepartmentDao {

	@Select("select * from department ")
	List<Department> findAll();

	@Select("select * from department where id=#{id}")
	Department findById(Integer id);
}
