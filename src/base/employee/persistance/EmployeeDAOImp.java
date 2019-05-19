package base.employee.persistance;

import base.employee.domain.Employee;
import base.employee.exception.EmployeeException;
import base.employee.exception.ErrorCode;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImp implements EmployeeDAO {

    private List<Employee> employees;

    public EmployeeDAOImp() {
        this.employees = new ArrayList<>();
        readEmployees();
    }


    @Override
    public List<Employee> readEmployees() {
        return null;
    }

    @Override
    public Employee getEmployeeByCode(int code) {
        throw new EmployeeException("Error - code not found", ErrorCode.ERROR_INVALID_CODE);
    }

    @Override
    public boolean updateEmployeePassword(int code, String newPassword) {
        return false;
    }


}
