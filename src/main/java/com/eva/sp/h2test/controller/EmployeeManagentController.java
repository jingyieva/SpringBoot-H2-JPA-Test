package com.eva.sp.h2test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eva.sp.h2test.bean.AddEmployeeReq;
import com.eva.sp.h2test.bean.GetEmployeeCondition;
import com.eva.sp.h2test.bean.RestResult;
import com.eva.sp.h2test.entity.Employee;
import com.eva.sp.h2test.service.IEmployeeService;
/**
 * 
 * @ClassName EmployeeManagentController 
 * @Description 員工管理
 * @Author Eva.Wu
 * @date Mar 18, 2019
 */
@RestController
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@RequestMapping("/employeeManage")
public class EmployeeManagentController extends BaseController{

	@Autowired
	private IEmployeeService employeeService;
	
	/**
	 * 
	 * @Title addEmployee 
	 * @Description 新增員工
	 * @Author Eva.Wu
	 * @Date Mar 18, 2019
	 * @param @param addEmployeeReq
	 * @param @return
	 * @return RestResult
	 * @throws
	 */
	@PostMapping("/addEmployee")
	public RestResult addEmployee(@RequestBody AddEmployeeReq addEmployeeReq){
		RestResult result = null;
		try {
			employeeService.addEmp(addEmployeeReq);
			result = buildResult();
		} catch(Exception e) {
			throw e;
		}
		return result;
	}
	
	@PostMapping("updateEmployee")
	public RestResult updateEmployee(@RequestBody AddEmployeeReq addEmployeeReq){
		RestResult result = null;
		try {
			employeeService.updateEmp(addEmployeeReq);
			result = buildResult();
		} catch(Exception e) {
			throw e;
		}
		return result;
	}
	
	@PostMapping("/queryEmployees")
	public RestResult queryEmployees(@RequestBody GetEmployeeCondition getEmployeeCondition) throws Exception{
		RestResult result = null;
		try {
			List<Employee> empList = employeeService.getEmps(getEmployeeCondition);
			
			result = buildResult(empList);
		} catch(Exception e) {
			throw e;
		}
		return result;
	}
	
	@PostMapping("/queryEmployee/{id}")
	public RestResult queryEmployees(@PathVariable("id") int id) throws Exception{
		RestResult result = null;
		try {
			Employee emp = employeeService.getEmpById(id);
			
			result = buildResult(emp);
		} catch(Exception e) {
			throw e;
		}
		return result;
	}
	
	@DeleteMapping("/deleteEmployee/{id}")
	public RestResult deleteEmployee(@PathVariable("id") int id) throws Exception{
		RestResult result = null;
		try {
			employeeService.deleteEmp(id);
			
			result = buildResult();
		} catch(Exception e) {
			throw e;
		}
		return result;
	}
	
}
