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

    public static void modifyProducts() {
        ProductView.printProducts();
        ProductView.selectProduct();
        ProductView.printModifyMenu();
        int option = InputData.getOption(MIN_OPTION, MAX_OPTION);
        actionByOption(option);
    }

    private static void actionByOption(int option) {
        switch (option) {
            case 1:
                System.out.println("Option 1 selected");
                ProductView.modifyName();
                break;
            case 2:
                System.out.println("Option 2 selected");
                ProductView.modifyPrice();
                break;
            case 3:
                System.out.println("Option 3 selected");
                ProductView.modifyCode();
                break;
        }
        updateProducts();
    }

    public boolean changeProductName(String name) {
        if (!productController.checkExistingName(name)) {
            productSelected.setName(name);
            System.out.println("The name has been change to " + name);
            return true;
        }
        System.out.println("Name is already on list");
        return false;
    }

    public boolean changeProductPrice(double price) {
        if (price > 0) {
            productSelected.setPrice(price);
            System.out.println();
            System.out.println("The price has been change to " + price);
            return true;
        }
        System.out.println("Price cant be negative");
        return false;
    }

    public boolean changeProductCode(int code) {
        if (!productController.checkExistingCode(code)) {
            productSelected.setCode(code);
            System.out.println("The code has been change to " + code);
            return true;
        }
        System.out.println("Code is already on list");
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

    public static void updateProducts() {
        productController.updateProducts();
    }
}
