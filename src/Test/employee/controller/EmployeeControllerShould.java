package Test.employee.controller;

import base.employee.control.EmployeeController;
import base.employee.domain.Employee;
import base.employee.exception.EmployeeException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmployeeControllerShould {
    private EmployeeController employeeController;

    @Before
    public void setUp() {
        this.employeeController = new EmployeeController();
    }

    @Test
    public void return_employee_when_code_exists() {
        int code = 111;
        Employee employee = employeeController.getEmployeeByCode(code);
        assertNotNull(employee);
    }

    @Test()
    public void return_employee_when_code_and_password_matches() {
        int code = 111;
        String password = "1234";
        Employee employee = employeeController.authenticateEmployee(code,password);
        assertNotNull(employee);
    }

    @Test(expected = EmployeeException.class)
    public void return_exception_when_code_dont_exist(){
        int code = 9999;
        String password = "1234";
        employeeController.authenticateEmployee(code,password);
    }

    @Test(expected = EmployeeException.class)
    public void return_exception_when_password_dont_match(){
        int code = 111;
        String password = "123456789";
        employeeController.authenticateEmployee(code,password);
    }
}