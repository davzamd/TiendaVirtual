package base.product.persistance;

import base.product.domain.Product;

import java.util.List;

public interface ProductDAO {

    List<Product> readProducts();

    Product getProductByCode(int code);

    boolean updateProductName(int code, String newName);

    boolean updateProductCode(int code, int newCode);

    boolean updateProductPrice(int code, double price);

}
