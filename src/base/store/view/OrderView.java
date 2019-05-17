package base.store.view;

import base.product.domain.Product;
import base.product.view.ProductView;
import base.store.control.OrderManager;
import base.store.domain.Order;
import base.util.Color;
import base.util.InputData;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class OrderView {

    public static void askForProductsQuantity() {
        System.out.println("Cuantos productos desea comprar");
    }

    public static void printOrderMenu() {
        System.out.println(Color.MENU);
        System.out.println("\n1. Añadir producto a la cesta");
        System.out.println("2. Visualizar precio total de la cesta");
        System.out.println("3. Imprimir factura");
        System.out.println("4. Terminar pedido");
        System.out.println(Color.DEFAULT);
    }

    public static void printOrderBill(Order order) {
        List<Product> products = order.getProducts();
        System.out.println(Color.BILL);
        System.out.println("\n\tFactura Simplificada: ");
        System.out.println("------------------------------------------------------------------------------------");
        for (Product product : products) {
            System.out.printf("%s \t\t\t\t%d%n", "Codigo:", product.getCode());
            System.out.printf("%s \t\t\t\t%s%n", "Nombre:", product.getName());
            System.out.printf("%s\t\t\t%s%n", "Descripcion:", product.getDescription());
            System.out.printf("%s \t\t\t\t%.2f%n%n", "Precio:", product.getPrice());
        }
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("\tEl precio total a pagar es " + order.getTotalPrice());
        System.out.println("\tAtendido por: " + order.getEmployeeName());
        System.out.println(Color.DEFAULT);
    }

    public static void addProduct() {
        ProductView.printProducts();

        System.out.println("\nPor favor ingrese el codigo del producto");
        int code = InputData.inputInt();
        OrderManager.getInstance().addProduct(code);
    }
}
