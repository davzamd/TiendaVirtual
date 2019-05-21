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
        OutputData.borrarPantalla();
        ProductView.printProducts();
        ProductView.selectProduct();
        OutputData.borrarPantalla();
        ProductView.printModifyMenu();
        int option = InputData.getOption(MIN_OPTION, MAX_OPTION);
        actionByOption(option);
    }

    private void actionByOption(int option) {
        switch (option) {
            case MODIFY_NAME:
                OutputData.borrarPantalla();
                System.out.println("Opcion 1 seleccionada");
                ProductView.modifyName();
                break;
            case MODIFY_PRICE:
                OutputData.borrarPantalla();
                System.out.println("Opcion 2 seleccionada");
                ProductView.modifyPrice();
                break;
            case MODIFY_CODE:
                OutputData.borrarPantalla();
                System.out.println("Opcion 3 seleccionada");
                ProductView.modifyCode();
                break;
        }
    }

    public boolean changeProductName(String name) {
        if (!productController.checkExistingName(name)) {
            boolean changed = productController.updateProductName(productSelectedCode, name);
            if (changed) {
                OutputData.borrarPantalla();
                OutputData.printSuccess("El nombre a cambiado a " + name);
            }
            return changed;
        }
        OutputData.printError("Ya existe un producto con el nombre " + name);
        return false;
    }

    public boolean changeProductPrice(double price) {
        if (price > 0) {
            boolean changed = productController.updateProductPrice(productSelectedCode, price);
            if (changed) {
                OutputData.borrarPantalla();
                OutputData.printSuccess("\nEl precio ha cambiado a " + price);
            }
            return changed;
        }
        OutputData.printError("El precio no puede ser negativo");
        return false;
    }

    public boolean changeProductCode(int code) {
        if (!productController.checkExistingCode(code)) {
            boolean changed = productController.updateProductCode(productSelectedCode, code);
            if (changed) {
                OutputData.borrarPantalla();
                OutputData.printSuccess("El codigo ha cambiado a " + code);
            }
            return changed;
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

}
