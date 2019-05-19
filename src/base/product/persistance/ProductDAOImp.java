package base.product.persistance;

import base.product.domain.Product;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImp implements ProductDAO {

    private static final String fileName;

    private List<Product> products;


    public ProductDAOImp() {
        this.products = new ArrayList<>();
        readProducts();
    }

    static {
        fileName = "products.txt";
    }

    @Override
    public List<Product> readProducts() {
        this.products = new ArrayList<>();
        try (var reader = Files.newBufferedReader(Paths.get(fileName))) {
            saveProductsOnList(reader);
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error loading file " + fileName);
        }
        return products;
    }

    private void saveProductsOnList(BufferedReader reader) throws IOException {
        while (reader.readLine() != null) {
            reader.readLine();
            int code = Integer.parseInt(reader.readLine().trim());
            reader.readLine();
            String name = reader.readLine().trim();
            reader.readLine();
            String description = reader.readLine().trim();
            reader.readLine();
            double price = Double.parseDouble(reader.readLine().trim());
            products.add(new Product(code, name, description, price));
        }
    }

    @Override
    public Product getProductByCode(int code) {
        for (Product product : products) {
            if (product.getCode() == code) {
                return product;
            }
        }
        return null;
    }

    private boolean updateProducts() {
        try (var writer = Files.newBufferedWriter(Paths.get(fileName))) {
            saveProductsOnFile(writer);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    private void saveProductsOnFile(BufferedWriter writer) throws IOException {
        for (Product product : products) {
            writer.write(String.format("%s%n%s%n%d%n%s%n%s%n%s%n%s%n%s%n%.2f%n",
                    "[empleado]",
                    "[code]",
                    product.getCode(),
                    "[nombre]",
                    product.getName(),
                    "[descripcion]",
                    product.getDescription(),
                    "[precio]",
                    product.getPrice()));
        }
    }


    @Override
    public boolean updateProductName(int code, String newName) {
        Product product = getProductByCode(code);
        product.setName(newName);
        return updateProducts();
    }

    @Override
    public boolean updateProductCode(int code, int newCode) {
        Product product = getProductByCode(code);
        product.setCode(newCode);
        return updateProducts();
    }

    @Override
    public boolean updateProductPrice(int code, double newPrice) {
        Product product = getProductByCode(code);
        product.setPrice(newPrice);
        return updateProducts();
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
