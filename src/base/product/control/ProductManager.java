package base.product.control;

import base.product.domain.Product;
import base.product.view.ProductView;
import base.util.InputData;

import java.util.List;

public class ProductManager {

    private static final int MIN_OPTION = 1;
    private static final int MAX_OPTION = 3;


    private static final ProductManager instance;

    private static Product productSelected;
    private static ProductController productController;

    private ProductManager() {
    }

    static {
        instance = new ProductManager();
        productController = new ProductController();
    }

    public static ProductManager getInstance() {
        return instance;
    }

    public void modifyProducts() {
        ProductView.printProducts();
        ProductView.selectProduct();
        ProductView.printModifyMenu();
        int option = InputData.getOption(MIN_OPTION, MAX_OPTION);
        actionByOption(option);
    }

    private void actionByOption(int option) {
        switch (option) {
            case 1:
                System.out.println("Opcion 1 seleccionada");
                ProductView.modifyName();
                break;
            case 2:
                System.out.println("Opcion 2 seleccionada");
                ProductView.modifyPrice();
                break;
            case 3:
                System.out.println("Opcion 3 seleccionada");
                ProductView.modifyCode();
                break;
        }
        updateProducts();
    }

    public boolean changeProductName(String name) {
        if (!productController.checkExistingName(name)) {
            productSelected.setName(name);
            System.out.println("El nombre a cambiado a " + name);
            return true;
        }
        System.out.println("Ya existe un producto con el nombre " + name);
        return false;
    }

    public boolean changeProductPrice(double price) {
        if (price > 0) {
            productSelected.setPrice(price);
            System.out.println();
            System.out.println("El precio ha cambiado a " + price);
            return true;
        }
        System.out.println("El precio no puede ser negativo");
        return false;
    }

    public boolean changeProductCode(int code) {
        if (!productController.checkExistingCode(code)) {
            productSelected.setCode(code);
            System.out.println("El codigo ha cambiado a " + code);
            return true;
        }
        System.out.println("Ya existe un producto con es codigo " + code);
        return false;
    }

    public boolean selectProduct(int code) {
        productSelected = productController.getProductByCode(code);
        return productSelected != null;
    }

    public String getProductName() {
        return productSelected.getName();
    }

    public List<Product> getProducts() {
        return productController.getProducts();
    }

    public void updateProducts() {
        productController.updateProducts();
    }
}
