package DesignPattern.StructuralPatterns.ProxyPattern.ProxyPattern;

public interface EmployeeDao {

    public boolean createEmployee(String client, Employee emp);

    public boolean deleteEmployee(String client, long empId);

    public Employee getEmployee(String client, long empId);
}
