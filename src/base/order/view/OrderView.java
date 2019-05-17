package base.order.view;

import base.product.domain.Product;
import base.product.view.ProductView;
import base.order.control.OrderManager;
import base.order.domain.Order;
import base.util.Color;
import base.util.InputData;
import base.util.OutputData;

import java.util.List;

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
        String bill = order.generateBill();
        OutputData.printBill(bill);
    }


    public static void addProduct() {
        ProductView.printProducts();

        System.out.println("\nPor favor ingrese el codigo del producto");
        int code = InputData.inputInt();
        OrderManager.getInstance().addProduct(code);
    }
}
