package base.product.persistance;

import base.connection.ConnectionDB;
import base.employee.domain.Employee;
import base.employee.exception.EmployeeException;
import base.employee.exception.ErrorCode;
import base.product.domain.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImp implements ProductDAO {


    private static final String TABLE_NAME = "productos";
    private static final String COLUMN_CODE = "p_codigo";
    private static final String COLUMN_NAME = "p_nombre";
    private static final String COLUMN_DESCRIPTION = "p_descripcion";
    private static final String COLUMN_PRICE = "p_precio";
    private List<Product> products;


    public ProductDAOImp() {
        this.products = new ArrayList<>();
        readProducts();
    }

    @Override
    public List<Product> readProducts() {
        this.products = new ArrayList<>();
        String query = "SELECT * FROM " + TABLE_NAME;
        try (Connection connection = ConnectionDB.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet result = statement.executeQuery(query);
            while (result.next()) {
                int code = result.getInt(COLUMN_CODE);
                String name = result.getString(COLUMN_NAME);
                String description = result.getString(COLUMN_DESCRIPTION);
                double price = result.getDouble(COLUMN_PRICE);
                this.products.add(new Product(code, name, description, price));
            }
            result.close();
        } catch (SQLException e) {
            System.out.println("Error al leer productos");
        }
        return this.products;
    }

    @Override
    public Product getProductByCode(int code) {
        String query = "SELECT * FROM " + TABLE_NAME + " where " + COLUMN_CODE + " = ?";
        try (Connection connection = ConnectionDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, code);
            ResultSet result = preparedStatement.executeQuery();
            result.next();
            int newCode = result.getInt(COLUMN_CODE);
            String name = result.getString(COLUMN_NAME);
            String description = result.getString(COLUMN_DESCRIPTION);
            double price = result.getDouble(COLUMN_PRICE);

            result.close();
            return new Product(newCode, name, description, price);
        } catch (SQLException e) {
            throw new IllegalArgumentException("El producto no existe");
        }
    }

    @Override
    public boolean updateProductName(int code, String newName) {
        return false;
    }

    @Override
    public boolean updateProductCode(int code, int newCode) {
        return false;
    }

    @Override
    public boolean updateProductPrice(int code, double newPrice) {
        return false;
    }

    public boolean checkExistingName(String name) {
        for (Product product : products) {
            if (product.getName().toUpperCase().trim().equals(name.toUpperCase().trim())) {
                return true;
            }
        }
        return false;
    }

    public boolean checkExistingCode(int code) {
        for (Product product : products) {
            if (product.getCode() == code) {
                return true;
            }
        }
        return false;
    }
}