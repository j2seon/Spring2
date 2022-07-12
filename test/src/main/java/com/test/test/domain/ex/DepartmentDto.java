package com.test.test.domain.ex;



public class DepartmentDto {

	private Integer deptno     ;
	private String dname   ;
	private String loc     ;
	
	public DepartmentDto() {}

	public int getdeptno() {
		return deptno;
	}

	public void setdeptno(int deptno) {
		this.deptno = deptno;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	@Override
	public String toString() {
		return "DepartmentVO [deptno=" + deptno + ", dname=" + dname + ", loc=" + loc + "]";
	}
	
	
	
	
 
}
