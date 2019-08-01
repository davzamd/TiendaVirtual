package Test.employee.persistance;

import base.employee.domain.Employee;
import base.employee.exception.EmployeeException;
import base.employee.persistance.EmployeeDAOImp;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class EmployeeDAOImpShould {

    private EmployeeDAOImp employeeDAOImp;

    @Before
    public void setUp() {
        this.employeeDAOImp = new EmployeeDAOImp();
    }

    @Test
    public void return_employee_when_employee_code_exists() {
        int code = 111;
        Employee employee = employeeDAOImp.getEmployeeByCode(code);
        assertNotNull(employee);
    }

    @Test(expected = EmployeeException.class)
    public void return_exception_when_employee_code_doesnt_exists(){
        int code = 99999;
        employeeDAOImp.getEmployeeByCode(code);
    }
}