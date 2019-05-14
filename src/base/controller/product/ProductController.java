package base.controller.product;

import base.model.product.domain.Product;
import base.model.product.persistance.ProductDAOImp;

import java.util.List;

public class ProductController {
    private ProductDAOImp productDAOImp;

    public ProductController() {
        this.productDAOImp = new ProductDAOImp();
    }

    public List<Product> getProducts() {
        return productDAOImp.readProducts();
    }

    public Product getProductByCode(int code) {
        return productDAOImp.getProductByCode(code);
    }

    public boolean updateProducts() {
        return productDAOImp.updateProducts();
    }

    public boolean checkExistingName(String name) {
        return productDAOImp.checkExistingName(name);
    }

    public boolean checkExistingCode(int code) {
        return productDAOImp.checkExistingCode(code);
    }
}
