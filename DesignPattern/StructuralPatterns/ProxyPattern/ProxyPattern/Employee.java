package DesignPattern.StructuralPatterns.ProxyPattern.ProxyPattern;

public class Employee {
    private long empId;
    private String name;

    public Employee(long empId, String name) {
        this.empId = empId;
        this.name = name;
    }

    public long getEmpId() {
        return empId;
    }

    public void setEmpId(long empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee [empId=" + empId + ", name=" + name + "]";
    }
}
