package DesignPattern.StructuralPatterns.ProxyPattern.ProxyPattern;

public class EmployeeDaoImpl implements EmployeeDao {

    EmployeeDaoImpl() {
    }

    @Override
    public boolean createEmployee(String client, Employee emp) {
        System.out.println("Client " + client + "succesfully created the employee record for " + emp.getName());
        return true;
    }

    @Override
    public boolean deleteEmployee(String client, long empId) {
        System.out.println("Client " + client + "succesfully deleated the employee record for " + empId);
        return true;
    }

    @Override
    public Employee getEmployee(String client, long empId) {
        return new Employee(empId, "emp");
    }

}
