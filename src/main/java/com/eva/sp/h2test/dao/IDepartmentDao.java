package com.eva.sp.h2test.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.eva.sp.h2test.entity.Department;

@Repository
public interface IDepartmentDao extends CrudRepository<Department, Integer>{

}
