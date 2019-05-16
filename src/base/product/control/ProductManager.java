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
        selectProduct();
        ProductView.printModifyMenu();
        int option = InputData.getOption(MIN_OPTION, MAX_OPTION);
        actionByOption(option);
    }

    private void selectProduct() {
        System.out.println("\n");
        boolean selected = false;
        do {
            try {
                ProductView.selectProduct();
                selected = true;
            } catch (IllegalArgumentException e) {
                System.out.println("El producto no existe");
            }
        } while (!selected);
    }

    public void selectProduct(int code) {
        productSelected = productController.getProductByCode(code);
        if (productSelected == null) {
            throw new IllegalArgumentException();
        }
    }

    private void actionByOption(int option) {
        switch (option) {
            case 1:
                System.out.println("Opcion 1 seleccionada");
                changeProductName();
                break;
            case 2:
                System.out.println("Opcion 2 seleccionada");
                changeProductPrice();
                break;
            case 3:
                System.out.println("Opcion 3 seleccionada");
                changeProductCode();
                break;
        }
        updateProducts();
    }

    private void changeProductName() {
        System.out.println("\n");
        boolean selected;
        do {
            try {
                ProductView.modifyName();
                selected = true;
            } catch (IllegalArgumentException e) {
                System.out.println("Ya existe un producto el nombre indicado");
                selected = false;
            }
        } while (!selected);
    }

    public void changeProductName(String name) {
        if (!productController.checkExistingName(name)) {
            productSelected.setName(name);
            System.out.println("El nombre a cambiado a " + name);
        }
        throw new IllegalArgumentException();
    }

    private void changeProductPrice() {
        boolean changed;
        do {
            try {
                ProductView.modifyPrice();
                changed = true;
            } catch (IllegalArgumentException e) {
                changed = false;
            }
        } while (!changed);
    }

    public void changeProductPrice(double price) {
        if (price > 0) {
            productSelected.setPrice(price);
            System.out.println();
            System.out.println("El precio ha cambiado a " + price);
            return;
        }
        System.out.println("El precio no puede ser negativo");
        throw new IllegalArgumentException();
    }

    private void changeProductCode() {
        boolean changed;
        do {
            try {
                ProductView.modifyCode();
                changed = true;
            } catch (IllegalArgumentException e) {
                changed = false;
            }
        } while (!changed);
    }

    public void changeProductCode(int code) {
        if (!productController.checkExistingCode(code)) {
            productSelected.setCode(code);
            System.out.println("El codigo ha cambiado a " + code);
            return;
        }
        System.out.println("Ya existe un producto con es codigo " + code);
        throw new IllegalArgumentException();
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
