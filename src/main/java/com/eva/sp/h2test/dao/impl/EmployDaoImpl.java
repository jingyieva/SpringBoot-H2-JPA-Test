package com.eva.sp.h2test.dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.eva.sp.h2test.bean.GetEmployeeCondition;
import com.eva.sp.h2test.dao.IEmployeePlusDao;
import com.eva.sp.h2test.entity.Employee;

@Repository
public class EmployDaoImpl implements IEmployeePlusDao {

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> findEmps(GetEmployeeCondition condition) {
		StringBuffer jsqlBuffer = null;
		List<Employee> employees = null;
		
		if(condition != null) {
			jsqlBuffer = new StringBuffer("select e.* from employee e where 1 = 1 ");
			
			if(condition.getEmpId() != null) {
				jsqlBuffer.append("AND e.ID = :empId ");
			}
			if(condition.getName() != null) {
				jsqlBuffer.append("AND e.name like :empName ");
			}
			if(condition.getAge() != null) {
				jsqlBuffer.append("AND e.age = :empAge ");
			}
			if(condition.getDepartment() != null) {
				jsqlBuffer.append("AND e.department_id = :empDeptId ");
			}
			
			Query query = this.entityManager.createNativeQuery(jsqlBuffer.toString(), Employee.class);
			
			if(condition.getEmpId() != null) {
				query.setParameter("empId", condition.getEmpId());
			}
			if(condition.getName() != null) {
				query.setParameter("empName", "%" + condition.getName() + "%");
			}
			if(condition.getAge() != null) {
				query.setParameter("empAge", condition.getAge());
			}
			if(condition.getDepartment() != null) {
				query.setParameter("empDeptId", condition.getDepartment().getId());	
			}
			
			query.setFirstResult(condition.getPageNum() * condition.getPageSize());
			query.setMaxResults(condition.getPageSize());
			
			employees = query.getResultList();
		}
		
		return employees;
	}


	 
}
