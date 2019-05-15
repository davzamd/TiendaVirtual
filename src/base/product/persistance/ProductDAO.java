package base.product.persistance;

import base.product.domain.Product;

import java.util.List;

public interface ProductDAO {

    List<Product> readProducts();

    Product getProductByCode(int code);

    boolean updateProducts();

    boolean updateProducts(List<Product> products);
}
