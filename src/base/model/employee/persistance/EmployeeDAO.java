package base.model.employee.persistance;

import base.model.employee.domain.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> readEmployees();

    Employee getEmployeeByCode(int code);

    boolean updateEmployees();

    boolean updateEmployees(List<Employee> employees);

}
