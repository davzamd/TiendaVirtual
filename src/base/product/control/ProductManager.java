package base.product.control;

import base.product.domain.Product;
import base.product.view.ProductView;
import base.util.InputData;
import base.util.OutputData;

import java.util.List;

public class ProductManager {

    private static final int MIN_OPTION = 1;
    private static final int MAX_OPTION = 3;
    private static final int MODIFY_NAME = 1;
    private static final int MODIFY_PRICE = 2;
    private static final int MODIFY_CODE = 3;

    private static final ProductManager instance;

    private static int productSelectedCode;
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
            case MODIFY_NAME:
                System.out.println("Opcion 1 seleccionada");
                ProductView.modifyName();
                break;
            case MODIFY_PRICE:
                System.out.println("Opcion 2 seleccionada");
                ProductView.modifyPrice();
                break;
            case MODIFY_CODE:
                System.out.println("Opcion 3 seleccionada");
                ProductView.modifyCode();
                break;
        }
        updateProducts();
    }

    public boolean changeProductName(String name) {
        if (!productController.checkExistingName(name)) {
            productController.updateProductName(productSelectedCode, name);
            System.out.println("El nombre a cambiado a " + name);
            return true;
        }
        OutputData.printError("Ya existe un producto con el nombre " + name);
        return false;
    }

    public boolean changeProductPrice(double price) {
        if (price > 0) {
            productController.updateProductPrice(productSelectedCode, price);
            System.out.println("\nEl precio ha cambiado a " + price);
            return true;
        }
        OutputData.printError("El precio no puede ser negativo");
        return false;
    }

    public boolean changeProductCode(int code) {
        if (!productController.checkExistingCode(code)) {
            productController.updateProductCode(productSelectedCode, code);
            System.out.println("El codigo ha cambiado a " + code);
            return true;
        }
        OutputData.printError("Ya existe un producto con es codigo " + code);
        return false;
    }

    public boolean selectProduct(int code) {
        if (productController.checkExistingCode(code)) {
            productSelectedCode = code;
            return true;
        }
        return false;
    }


    public List<Product> getProducts() {
        return productController.getProducts();
    }

    public void updateProducts() {
        productController.updateProducts();
    }
}
