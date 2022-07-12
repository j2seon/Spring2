package com.test.test.domain.ex;


public class JoinDto2 {

    private Integer deptno     ;
    private String dname   ;
    private String loc     ;
    private Integer empno ;
    private String ename ;
    private Integer sal ;

    public JoinDto2() {}

    @Override
    public String toString() {
        return "JoinDto2{" +
                "deptno=" + deptno +
                ", dname='" + dname + '\'' +
                ", loc='" + loc + '\'' +
                ", empno=" + empno +
                ", ename='" + ename + '\'' +
                ", sal=" + sal +
                '}';
    }

    public Integer getDeptno() {
        return deptno;
    }

    public void setDeptno(Integer deptno) {
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

    public Integer getEmpno() {
        return empno;
    }

    public void setEmpno(Integer empno) {
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
}
