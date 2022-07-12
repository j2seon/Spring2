package com.test.test.domain.ex;


public class JoinDto {
	
	private EmployeeDto emp;
	private DepartmentDto dept;
	
	public JoinDto() {}
	
	public JoinDto(EmployeeDto emp, DepartmentDto dept) {
		this.emp = emp;
		this.dept = dept;
	}

	public EmployeeDto getemp() {
		return emp;
	}

	public void setemp(EmployeeDto emp) {
		this.emp = emp;
	}

	public DepartmentDto getdept() {
		return dept;
	}

	public void setdept(DepartmentDto dept) {
		this.dept = dept;
	}



	@Override
	public String toString() {
		return "JoinVO [emp=" + emp + ", dept=" + dept + "]";
	}
	
	
	
}
