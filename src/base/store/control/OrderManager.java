package base.store.control;

import base.employee.control.EmployeeManager;
import base.product.control.ProductController;
import base.product.control.ProductManager;
import base.product.domain.Product;
import base.product.view.ProductView;
import base.store.domain.Order;
import base.store.view.OrderView;
import base.util.Color;
import base.util.InputData;
import base.util.OutputData;

public class OrderManager {

    private static final OrderManager orderManager;

    private static final int MIN_OPTION = 1;
    private static final int MAX_OPTION = 4;

    private int quantity;

    private static Order order;
    private boolean orderFinished;

    private OrderManager() {
        orderFinished = false;
    }

    static {
        orderManager = new OrderManager();
    }

    public static OrderManager getInstance() {
        return orderManager;
    }

    public void makeAnOrder() {
        order = new Order(EmployeeManager.getInstance().getEmployeeName());
        int maxOption = ProductManager.getInstance().getProducts().size();

        OrderView.askForProductsQuantity();
        quantity = InputData.getOption(1, maxOption);

        do {
            OrderView.printOrderMenu();
            int option = InputData.getOption(MIN_OPTION, MAX_OPTION);
            actionByOption(option);
        } while (!orderFinished);
    }

    private void actionByOption(int option) {
        switch (option) {
            case 1:
                addProduct();
                break;
            case 2:
                System.out.println("Opcion 2 seleccionada");
                System.out.println("\nPrecio actual del pedido: " + order.getTotalPrice());
                break;
            case 3:
                System.out.println("Opcion 3 seleccionada");
                OrderView.printOrderBill(order);
                break;
            case 4:
                System.out.println("Opcion 4 seleccionada");
                orderFinished = true;
                break;
        }
    }

    private void addProduct() {
        int currentOrderSize = order.getProducts().size();

        if (currentOrderSize < quantity) {
            System.out.println("Opcion 1 seleccionada");
            ProductView.printProducts();
            OrderView.addProduct();
        } else {
            OutputData.printError("No puede añadir mas productos");
        }
    }

    public void addProduct(int code) {
        if (order.checkProductOnList(code)) {
            OutputData.printError("Producto ya existe en la lista");
            return;
        }
        ProductController productController = new ProductController();

        Product product = productController.getProductByCode(code);
        if (product != null) {
            order.addProduct(product);
            OutputData.printSuccess("Producto anadido exitosamente");
        } else {
            OutputData.printError("Producto no existe");
        }
    }


}
