package base.product.view;

import base.product.control.ProductManager;
import base.util.Color;
import base.util.InputData;

import java.util.InputMismatchException;
import java.util.Scanner;


public class ProductView {

    private static ProductManager productManager;

    static {
        productManager = ProductManager.getInstance();
    }


    public static void printProducts() {
        productManager.getProducts().forEach(System.out::println);
    }

    public static void selectProduct() {
        System.out.print("");
        System.out.println("\nQue producto desea cambiar? por favor ingrese el codigo");
        int code = InputData.inputInt();
        productManager.selectProduct(code);
    }

    public static void printModifyMenu() {
        System.out.println(Color.MENU);
        System.out.println("\n1. Modificar nombre de producto");
        System.out.println("2. Modificar precio de producto");
        System.out.println("3. Modificar código de producto");
        System.out.println(Color.DEFAULT);

    }

    public static void modifyName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Modificando el nombre del producto " + productManager.getProductName());
        System.out.println("Por varo ingrese el nuevo nombre");

        String name = scanner.nextLine();

        productManager.changeProductName(name);
    }

    public static void modifyPrice() {
        System.out.println("\nModificando el precio del producto: " + productManager.getProductName());
        System.out.println("Por favor ingrese el nuevo precio");

        double price = InputData.inputDouble();

        productManager.changeProductPrice(price);
    }

    public static void modifyCode() {
        System.out.println("\nModificando el codigo del producto " + productManager.getProductName());
        System.out.println("Por favor ingrese el nuevo codigo");

        int code = InputData.inputInt();

        productManager.changeProductCode(code);
    }


}
