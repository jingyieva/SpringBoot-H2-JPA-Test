package com.eva.sp.h2test.service.implement;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eva.sp.h2test.bean.AddEmployeeReq;
import com.eva.sp.h2test.bean.GetEmployeeCondition;
import com.eva.sp.h2test.dao.IEmployeeDao;
import com.eva.sp.h2test.dao.IEmployeePlusDao;
import com.eva.sp.h2test.entity.Department;
import com.eva.sp.h2test.entity.Employee;
import com.eva.sp.h2test.service.IEmployeeService;

@Service
public class EmployeeService implements IEmployeeService{

	@Autowired
	private IEmployeeDao employeeDao;
	
	@Autowired
	private IEmployeePlusDao employeePlusDao;
	
	@Override
	public void addEmp(AddEmployeeReq addEmployeeReq) {
		Date now = new Date();
//		if(addEmployeeReq != null) {
			Employee employee = new Employee();
			employee.setName("Albert");
			employee.setDepartment(new Department(1, "IT"));
			employee.setAge(40);
			employee.setGenderCode("GENDER_MALE");
			employee.setAddress("台北市南港區忠孝東路6段21號6樓");
			employee.setCreateDate(now);
			employee.setUpdateDate(now);
			employeeDao.save(employee);
//		}
		
	}

	@Override
	public List<Employee> getEmps(GetEmployeeCondition getEmployeeCondition) {
		//一頁幾筆資料正常應做config （config在資料庫或properties檔）
		
		
		
		List<Employee> emps = (List<Employee>) employeePlusDao.findEmps(getEmployeeCondition);
		//List<Employee> emps = (List<Employee>) employeeDao.findAll();
		
		return emps;
	}
	
	@Override
	public Employee getEmpById(int id) {
		Optional<Employee> employees = employeeDao.findById(id);
		Employee emp = null;
		
		if(employees != null && employees.isPresent()) {	
			emp = employees.get();
		}
		
		return emp;
	}

	@Override
	public void deleteEmp(int empId) {
		
		employeeDao.deleteById(empId);
		
	}

	@Override
	public void updateEmp(AddEmployeeReq addEmployeeReq) {
		Date now = new Date();
		Optional<Employee> employees = employeeDao.findById(1);
		Employee emp = null;
		
		if(employees != null && employees.isPresent()) {	
			emp = employees.get();
			emp.setName("Albert");
			emp.setAge(40);
		}
		
		
//		if(addEmployeeReq != null) {
//			Employee employee = new Employee();
//			employee.setId(1);
//			employee.setName("Albert");
//			employee.setAge(40);
//			employee.setAddress("台北市南港區忠孝東路6段21號6樓");
//			employee.setCreateDate(now);
//			employee.setUpdateDate(now);
			employeeDao.save(emp);
//		}
		
	}

}
