package base.persistance.imp;

import base.dominio.Employee;
import base.dominio.Product;
import base.persistance.def.EmployeeDAO;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class EmployeeDAOImp implements EmployeeDAO {

    private List<Employee> employees;
    private static final String fileName;

    public EmployeeDAOImp() {
        this.employees = new ArrayList<>();

    }

    static {
        fileName = "employees.txt";
    }

    @Override
    public List<Employee> readEmployees() {
        try (var reader = Files.newBufferedReader(Paths.get(fileName))) {
            saveEmployeesOnList(reader);
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error loading file " + fileName);
        }
        return employees;
    }

    private void saveEmployeesOnList(BufferedReader reader) throws IOException, InputMismatchException {
        while (reader.readLine() != null) {
            reader.readLine();
            int code = Integer.parseInt(reader.readLine().trim());
            reader.readLine();
            String firstName = reader.readLine();
            reader.readLine();
            String lastName = reader.readLine();
            reader.readLine();
            String password = reader.readLine();
            employees.add(new Employee(code, firstName, lastName, password));
        }
    }

    @Override
    public Employee getEmployeeByCode(int code) {
        readEmployees();
        for (Employee employee : employees) {
            if (employee.getCode() == code) {
                return employee;
            }
        }
        return null;
    }


}
