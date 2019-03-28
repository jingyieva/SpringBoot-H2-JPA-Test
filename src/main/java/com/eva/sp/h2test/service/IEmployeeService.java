package com.eva.sp.h2test.service;

import java.util.List;

import com.eva.sp.h2test.bean.AddEmployeeReq;
import com.eva.sp.h2test.bean.GetEmployeeCondition;
import com.eva.sp.h2test.entity.Employee;

/**
 * 
 * @Author Eva.Wu
 * @date Mar 18, 2019
 */
public interface IEmployeeService {

	/**
	 * 
	 * @Title addEmp 
	 * @Description 新增員工
	 * @Author Eva.Wu
	 * @Date Mar 18, 2019
	 * @param addEmployeeReq
	 * @return void
	 * @throws
	 */
	public void addEmp(AddEmployeeReq addEmployeeReq);

	/**
	 * 
	 * @Title getEmp 
	 * @Description 取得員工資料
	 * @Author Eva.Wu
	 * @Date Mar 19, 2019
	 * @param getEmployeeCondition 
	 * @return List<Employee>
	 * @throws
	 */
	public List<Employee> getEmps(GetEmployeeCondition getEmployeeCondition);

	/**
	 * 
	 * @Title deleteEmp 
	 * @Description 刪除員工
	 * @Author Eva.Wu
	 * @Date Mar 20, 2019
	 * @param empId void
	 * @throws
	 */
	public void deleteEmp(int empId);

	public Employee getEmpById(int id);

	public void updateEmp(AddEmployeeReq addEmployeeReq);
}
