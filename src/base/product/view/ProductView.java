package base.product.view;

import base.product.control.ProductManager;
import base.util.Color;
import base.util.InputData;
import base.util.OutputData;

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
        boolean selected;
        do {
            System.out.println("\nQue producto desea cambiar? por favor ingrese el codigo");
            int code = InputData.inputInt();
            selected = productManager.selectProduct(code);
            if (!selected) {
                OutputData.printError("El producto no existe");
            }
        } while (!selected);
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
        boolean changed;
        System.out.println("\nModificando el nombre del producto ");
        do {
            System.out.println("Por favor ingrese el nuevo nombre");
            String name = scanner.nextLine();

            changed = productManager.changeProductName(name);
        } while (!changed);
    }

    public static void modifyPrice() {
        boolean changed;
        System.out.println("\nModificando el precio del producto: ");
        do {
            System.out.println("Por favor ingrese el nuevo precio");
            double price = InputData.inputDouble();

            changed = productManager.changeProductPrice(price);
        } while (!changed);
    }

    public static void modifyCode() {
        boolean changed;
        System.out.println("\nModificando el codigo del producto ");
        do {
            System.out.println("Por favor ingrese el nuevo codigo");
            int code = InputData.inputInt();

            changed = productManager.changeProductCode(code);
        } while (!changed);
    }


}
