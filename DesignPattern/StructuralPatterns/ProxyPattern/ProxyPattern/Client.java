package DesignPattern.StructuralPatterns.ProxyPattern.ProxyPattern;

public class Client {
    public static void main(String[] args) {
        EmployeeProxyDao empDao = new EmployeeProxyDao();
        Employee employee = new Employee(123, "Abc");

        // empDao.createEmployee("USER", employee);
        empDao.createEmployee("ADMIN", employee);
        // empDao.deleteEmployee("USER", 123);
        empDao.deleteEmployee("ADMIN", 123);
        System.out.println(empDao.getEmployee("ADMIN", 123));
        System.out.println(empDao.getEmployee("USER", 123));
    }
}
