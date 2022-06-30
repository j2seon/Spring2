package com.test.test.domain;



public class EmployeeDto {
	
	private Integer empno ;
	private String ename ;
	private Integer sal ;
    private Integer deptno;

	public EmployeeDto() {}

	@Override
	public String toString() {
		return "EmployeeDto{" +
				"empno=" + empno +
				", ename='" + ename + '\'' +
				", sal=" + sal +
				", deptno=" + deptno +
				'}';
	}

	public Integer getempno() {
		return empno;
	}

	public void setempno(Integer empno) {
		this.empno = empno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public Integer getSal() {
		return sal;
	}

	public void setSal(Integer sal) {
		this.sal = sal;
	}

	public Integer getDeptno() {
		return deptno;
	}

	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}
}
