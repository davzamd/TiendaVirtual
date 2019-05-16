package base.store.view;

import base.product.domain.Product;
import base.store.control.OrderManager;
import base.store.domain.Order;
import base.util.InputData;
import java.util.List;


public class OrderView {

    public static void askForProductsQuantity() {
        System.out.println("Cuantos productos desea comprar");
    }

    public static void printOrderMenu() {
        System.out.println("\n1. Añadir producto a la cesta");
        System.out.println("2. Visualizar precio total de la cesta");
        System.out.println("3. Imprimir factura");
        System.out.println("4. Terminar pedido");
    }

    public static void printOrderBill(Order order) {
        List<Product> products = order.getProducts();
        System.out.println("\n\tFactura Simplificada: ");
        System.out.println("------------------------------------------------------------------------------------");
        for (Product product : products) {
            System.out.printf("%s \t\t\t\t%d%n", "Codigo:", product.getCode());
            System.out.printf("%s \t\t\t\t%s%n", "Nombre:", product.getName());
            System.out.printf("%s\t\t\t%s%n", "Descripcion:", product.getDescription());
            System.out.printf("%s \t\t\t\t%.2f%n%n", "Precio:", product.getPrice());
        }
        System.out.println("------------------------------------------------------------------------------------");
        System.out.printf("\t%s %.2f%n","El precio total a pagar es",order.getTotalPrice());
        System.out.printf("\t%s %s%n%n","Atendido por:",order.getEmployeeName());
    }

    public static void addProduct() {
        System.out.println("Por favor ingrese el codigo del producto");
        int code = InputData.inputInt();
        OrderManager.getInstance().addProduct(code);
    }
}
