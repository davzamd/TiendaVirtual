package base.store.view;

import base.product.domain.Product;
import base.product.view.ProductView;
import base.store.control.OrderManager;
import base.store.domain.Order;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class OrderView {

    public static void askForProductsQuantity() {
        System.out.println("Cuantos productos desea comprar");
    }

    public static void printOrderMenu() {
        System.out.println("\n");
        System.out.println("1. Añadir producto a la cesta");
        System.out.println("2. Visualizar precio total de la cesta");
        System.out.println("3. Imprimir factura");
        System.out.println("4. Terminar pedido");
    }

    public static void printOrderBill(Order order) {
        List<Product> products = order.getProducts();
        System.out.println("\n");
        System.out.println("\tFactura Simplificada: ");
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
    }

    public static void addProduct() {
        System.out.println("\n");
        ProductView.printProducts();
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Por favor ingrese el codigo del producto");
            int code = scanner.nextInt();
            OrderManager.getInstance().addProduct(code);
        }catch (InputMismatchException e){
            System.out.println("Producto incorrecto");
        }catch (IllegalArgumentException e){
            System.out.println("Producto ya en lista");
        }
    }
}
