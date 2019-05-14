package Test.product.controller;

import base.controller.product.ProductController;
import base.model.product.domain.Product;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ProductControllerShould {

    private ProductController productController;
    @Before
    public void setUp(){
        productController = new ProductController();
    }

    @Test
    public void return_list_of_products() {
        List<Product> products = productController.getProducts();
        int size = products.size();
        assertNotEquals(0,size);
    }

    @Test
    public void return_product_when_code_exists() {
        int code = 222;
        Product product = productController.getProductByCode(code);
        assertNotNull(product);
    }

    @Test
    public void return_null_when_code_doesnt_exists() {
        int code = 22243134;
        Product product = productController.getProductByCode(code);
        assertNull(product);
    }
}