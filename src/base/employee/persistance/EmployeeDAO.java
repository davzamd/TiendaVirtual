package base.employee.persistance;

import base.employee.domain.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> readEmployees();

    Employee getEmployeeByCode(int code);

    boolean updateEmployeePassword(int code , String newPassword);


}
