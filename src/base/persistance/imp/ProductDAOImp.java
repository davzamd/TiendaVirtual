package base.persistance.imp;

import base.dominio.Product;
import base.persistance.def.ProductDAO;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImp implements ProductDAO {

    private static final String fileName;

    private ArrayList<Product> products;


    public ProductDAOImp() {
        this.products = new ArrayList<>();
    }

    static {
        fileName = "products.txt";
    }

    @Override
    public List<Product> readProducts() {
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
}
