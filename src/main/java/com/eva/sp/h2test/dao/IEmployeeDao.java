package com.eva.sp.h2test.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.eva.sp.h2test.entity.Employee;

@Repository
public interface IEmployeeDao extends PagingAndSortingRepository<Employee, Integer> {
	
}
