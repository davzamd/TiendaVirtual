package Test.persistance.imp;

import base.dominio.Product;
import base.persistance.imp.ProductDAOImp;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.List;

import static org.junit.Assert.*;

public class ProductDAOImpShould {

    private ProductDAOImp productDAOImp;

    @Before
    public void start() {
        productDAOImp = new ProductDAOImp();
    }

    @Test
    public void return_false_when_list_is_not_empty() {
        List<Product> products = productDAOImp.readProducts();
        assertFalse(products.isEmpty());
    }

}