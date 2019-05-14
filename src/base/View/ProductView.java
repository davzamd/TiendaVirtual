package base.View;

import base.controller.product.ProductController;
import base.model.product.domain.Product;

import java.util.Scanner;

public class ProductView {

    private static final int MIN_OPTION = 1;
    private static final int MAX_OPTION = 3;

    private static Scanner scanner;
    private static ProductController productController;
    private static Product productSelected;

    static {
        scanner = new Scanner(System.in);
        productController = new ProductController();
    }

    public static void modifyProducts() {
        printProducts();
        selectProduct();
        int option = getOption();
        actionByOption(option);
    }

    private static void printProducts() {
        productController.getProducts().forEach(System.out::println);
    }

    private static void selectProduct() {
        boolean selected;
        do {
            System.out.println("Witch product do you want to change? please enter the code");
            int code = scanner.nextInt();
            scanner.nextLine();

            productSelected = productController.getProductByCode(code);

            if (productSelected == null) {
                System.out.println("Product doesnt exist");
                selected = false;
            } else {
                selected = true;
            }
        } while (!selected);
    }

    private static int getOption() {
        int option;
        do {
            printModifyMenu();
            option = scanner.nextInt();
        } while (option < MIN_OPTION || option > MAX_OPTION);
        scanner.nextLine();
        return option;
    }

    private static void printModifyMenu() {
        System.out.println("\n1. Modificar nombre de producto");
        System.out.println("2. Modificar precio de producto");
        System.out.println("3. Modificar código de producto\n");
    }

    private static void actionByOption(int option) {
        switch (option) {
            case 1:
                System.out.println("Option 1 selected");
                modifyName();
                break;
            case 2:
                System.out.println("Option 2 selected");
                modifyPrice();
                break;
            case 3:
                System.out.println("Option 3 selected");
                modifyCode();
                break;
        }
        productController.updateProducts();
    }

    private static void modifyName() {
        boolean changed = false;
        System.out.println("Modifying " + productSelected.getName() + " name's");
        do {
            System.out.println("Please enter the name");
            String name = scanner.nextLine();
            if (!productController.checkExistingName(name)) {
                productSelected.setName(name);
                System.out.println("The name has been change to " + name);
                changed = true;
            } else {
                System.out.println("Name is already on list");
            }
        } while (!changed);
    }

    private static void modifyPrice(){
        boolean changed = false;
        System.out.println("Modifying " + productSelected.getName() + " price");
        do {
            System.out.println("Please enter the new price");
            double price = scanner.nextDouble();
            if (price>0) {
                productSelected.setPrice(price);
                System.out.println("The price has been change to " + price);
                changed = true;
            } else {
                System.out.println("price cant be negative");
            }
        } while (!changed);
    }

    private static void modifyCode() {
        boolean changed = false;
        System.out.println("Modifying " + productSelected.getName() + " code's");
        do {
            System.out.println("Please enter the code");
            int code = scanner.nextInt();
            if (!productController.checkExistingCode(code)) {
                productSelected.setCode(code);
                System.out.println("The code has been change to " + code);
                changed = true;
            } else {
                System.out.println("Code is already on list");
            }
        } while (!changed);
    }


}
