package base.persistance.def;

import base.dominio.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> readEmployees();

    Employee getEmployeeByCode(int code);

}
