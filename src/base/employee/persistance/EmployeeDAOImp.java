package base.employee.persistance;

import base.connection.ConnectionDB;
import base.employee.domain.Employee;
import base.employee.exception.EmployeeException;
import base.employee.exception.ErrorCode;

import java.sql.*;

public class EmployeeDAOImp implements EmployeeDAO {

    private static final String TABLE_NAME = "empleados";
    private static final String COLUMN_CODE = "e_codigo";
    private static final String COLUMN_FIRST_NAME = "e_nombre";
    private static final String COLUMN_LAST_NAME = "e_apellidos";
    private static final String COLUMN_PASSWORD = "e_password";


    @Override
    public Employee getEmployeeByCode(int code) {
        String query = "SELECT * FROM " + TABLE_NAME + " where " + COLUMN_CODE + " = ?";
        try (Connection connection = ConnectionDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, code);
            ResultSet result = preparedStatement.executeQuery();
            result.next();
            int newCode = result.getInt(COLUMN_CODE);
            String firstName = result.getString(COLUMN_FIRST_NAME);
            String lastName = result.getString(COLUMN_LAST_NAME);
            String password = result.getString(COLUMN_PASSWORD);

            result.close();
            return new Employee(newCode, firstName, lastName, password);
        } catch (SQLException e) {
            throw new EmployeeException("Error - code not found", ErrorCode.ERROR_INVALID_CODE);
        }
    }

    @Override
    public boolean updateEmployeePassword(int code, String newPassword) {
        String query = "UPDATE " + TABLE_NAME + " SET " + COLUMN_PASSWORD + " = ? WHERE " + COLUMN_CODE + " = ?";
        try (Connection connection = ConnectionDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, newPassword);
            preparedStatement.setInt(2, code);
            return preparedStatement.executeUpdate() == 1;
        } catch (SQLException e) {
            return false;
        }
    }


}
