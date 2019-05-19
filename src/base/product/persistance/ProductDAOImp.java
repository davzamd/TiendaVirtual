package base.product.persistance;

import base.product.domain.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductDAOImp implements ProductDAO{


    private List<Product> products;


    public ProductDAOImp() {
        this.products = new ArrayList<>();
        readProducts();
    }

    @Override
    public List<Product> readProducts() {
        return null;
    }

    @Override
    public Product getProductByCode(int code) {
        return null;
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