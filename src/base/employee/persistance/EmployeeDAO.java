package base.employee.persistance;

import base.employee.domain.Employee;

import java.util.List;

public interface EmployeeDAO {

    Employee getEmployeeByCode(int code);

    boolean updateEmployeePassword(int code,String newPassword);

}
