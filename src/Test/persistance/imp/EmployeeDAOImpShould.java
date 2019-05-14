package Test.persistance.imp;

import base.dominio.Employee;
import base.persistance.def.EmployeeDAO;
import base.persistance.imp.EmployeeDAOImp;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class EmployeeDAOImpShould {

    private EmployeeDAOImp employeeDAOImp;

    @Before
    public void start() {
        this.employeeDAOImp = new EmployeeDAOImp();
    }

    @Test
    public void return_false_when_list_is_not_empty() {
        List<Employee> employees = employeeDAOImp.readEmployees();
        assertFalse(employees.isEmpty());
    }

    @Test
    public void return_employee_when_employee_code_exists() {
        int code = 111;
        Employee employee = employeeDAOImp.getEmployeeByCode(code);
        assertNotNull(employee);
    }
}