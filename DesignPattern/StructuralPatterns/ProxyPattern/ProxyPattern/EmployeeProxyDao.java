package DesignPattern.StructuralPatterns.ProxyPattern.ProxyPattern;

public class EmployeeProxyDao implements EmployeeDao {

    private EmployeeDao empDao;

    public EmployeeProxyDao() {
        empDao = new EmployeeDaoImpl();
    }

    @Override
    public boolean createEmployee(String client, Employee emp) {
        if (client.equals("ADMIN")) {
            empDao.createEmployee(client, emp);
            return true;
        }
        throw new RuntimeException("Client doesn't have permission to create new employee.");
    }

    @Override
    public boolean deleteEmployee(String client, long empId) {
        if (client.equals("ADMIN")) {
            empDao.deleteEmployee(client, empId);
            return true;
        }
        throw new RuntimeException("Client doesn't have permission to delete employee.");
    }

    @Override
    public Employee getEmployee(String client, long empId) {
        if (client.equals("ADMIN") || client.equals("USER")) {
            return empDao.getEmployee(client, empId);
        }
        throw new RuntimeException("Client doesn't have permission to fetch employee record.");
    }

}
