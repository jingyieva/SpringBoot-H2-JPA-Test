package com.eva.sp.h2test.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;
import lombok.Data;

@Entity
@Table(name = "employee")
@Data
@DynamicUpdate(value=true)
public class Employee {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
//	@Column(name="department_id",nullable=false)
//	private int departmentId;
	
	@Column(name="gender_code",nullable=false)
	private String genderCode;
	
	private String mobile;
	
	private String address;
	
	private int age;
	
	@Column(name="create_date",nullable=false)
	private Date createDate;
	
	@Column(name="update_date",nullable=false)
	private Date updateDate;
	
	/**
	 * CascadeType.PERSIST	在儲存時一併儲存 被參考的物件。
	 * CascadeType.MERGE	在合併修改時一併 合併修改被參考的物件。
	 * CascadeType.REMOVE	在移除時一併移除 被參考的物件。
	 * CascadeType.REFRESH	在更新時一併更新 被參考的物件。
	 * CascadeType.ALL	    無論儲存、合併、 更新或移除，一併對被參考物件作出對應動作。
	 */
	@OneToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="department_id", columnDefinition="id")
	private Department department;
	
	public Employee() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

//	public int getDepartmentId() {
//		return departmentId;
//	}
//
//	public void setDepartmentId(int departmentId) {
//		this.departmentId = departmentId;
//	}

	public String getGenderCode() {
		return genderCode;
	}

	public void setGenderCode(String genderCode) {
		this.genderCode = genderCode;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	
}
