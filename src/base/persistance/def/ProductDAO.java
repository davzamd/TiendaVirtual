package base.persistance.def;

import base.dominio.Product;

import java.util.List;

public interface ProductDAO {

    List<Product> readProducts();
}
