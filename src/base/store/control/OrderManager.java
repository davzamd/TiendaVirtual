package base.store.control;

import base.employee.control.EmployeeManager;
import base.product.control.ProductController;
import base.product.control.ProductManager;
import base.product.domain.Product;
import base.product.view.ProductView;
import base.store.domain.Order;
import base.store.view.OrderView;
import base.util.InputData;

public class OrderManager {

    private static final OrderManager orderManager;

    private static final int MIN_OPTION = 1;
    private static final int MAX_OPTION = 4;
    private static ProductManager productManager;
    private static ProductController productController;
    private static Order order;

    static {
        orderManager = new OrderManager();
        productManager = ProductManager.getInstance();
        productController = new ProductController();
    }

    public static void makeAnOrder() {
        order = new Order(EmployeeManager.getEmployeeName());

        int maxOption = productManager.getProducts().size();

        OrderView.askForProductsQuantity();
        int quantity = InputData.getOption(1, maxOption);

        do {
            OrderView.printOrderMenu();
            int option = InputData.getOption(MIN_OPTION, MAX_OPTION);
            actionByOption(option);
        }while (order.getProducts().size()<quantity);
    }

    private static void actionByOption(int option) {
        switch (option) {
            case 1:
                System.out.println("Option 1 selected");
                OrderView.addProduct();
                break;
            case 2:
                System.out.println("Option 2 selected");
                System.out.println("Order current price: " + order.getTotalPrice());
                break;
            case 3:
                System.out.println("Option 3 selected");
                OrderView.printOrderBill(order);
                break;
            case 4:
                System.out.println("Option 4 selected");

                break;
        }
    }

    public static void addProduct(int code) {
        if (order.checkProductOnList(code)){
            System.out.println("Producto ya existe en la lista");
            return;
        }

        Product product = productController.getProductByCode(code);
        if (product != null) {
            order.addProduct(product);
            System.out.println("Producto anadido exitosamente");
        }else {
            System.out.println("Producto no existe");
        }
    }


}
