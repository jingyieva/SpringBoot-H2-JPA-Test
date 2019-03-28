package com.eva.sp.h2test.dao;

import java.util.List;

import com.eva.sp.h2test.bean.GetEmployeeCondition;
import com.eva.sp.h2test.entity.Employee;

public abstract interface IEmployeePlusDao {

	List<Employee> findEmps(GetEmployeeCondition condition);

}
