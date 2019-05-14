package Test.product.persistance;

import base.model.product.domain.Product;
import base.model.product.persistance.ProductDAOImp;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ProductDAOImpShould {

    private ProductDAOImp productDAOImp;

    @Before
    public void setUp() {
        productDAOImp = new ProductDAOImp();
    }

    @Test
    public void return_false_when_list_is_not_empty() {
        List<Product> products = productDAOImp.readProducts();
        assertFalse(products.isEmpty());
    }

    @Test
    public void return_employee_when_product_code_exists() {
        int code = 222;
        Product product = productDAOImp.getProductByCode(code);
        assertNotNull(product);
    }

    @Test
    public void return_true_when_product_name_exists() {
        String name = "Lenovo Ideapad 530S";
        boolean exist = productDAOImp.checkExistingName(name);
        assertTrue(exist);
    }

    @Test
    public void return_false_when_product_name_exists() {
        String name = "ipad";
        boolean exist = productDAOImp.checkExistingName(name);
        assertFalse(exist);
    }

    @Test
    public void return_true_when_product_code_exists() {
        int code = 224;
        boolean exist = productDAOImp.checkExistingCode(code);
        assertTrue(exist);
    }

    @Test
    public void return_false_when_product_code_exists() {
        int code = 2244234;
        boolean exist = productDAOImp.checkExistingCode(code);
        assertFalse(exist);
    }

}