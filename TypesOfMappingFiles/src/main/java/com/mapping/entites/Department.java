package com.mapping.entites;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Department {

	@Id
	private int deptId;
	
	private String deptName;
	
	@ManyToMany(mappedBy = "dept", cascade = CascadeType.ALL)
	private List<Student> student = new ArrayList<>();

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public List<Student> getStudent() {
		return student;
	}

	public void setStudent(List<Student> student) {
		this.student = student;
	}

	public Department(int deptId, String deptName, List<Student> student) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
		this.student = student;
	}

	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Department [deptId=" + deptId + ", deptName=" + deptName + ", student=" + student + "]";
	}
	
}
