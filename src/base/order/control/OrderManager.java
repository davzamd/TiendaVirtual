package base.order.control;

import base.employee.control.EmployeeManager;
import base.order.persistance.OrderDAOImp;
import base.product.control.ProductController;
import base.product.control.ProductManager;
import base.product.domain.Product;
import base.order.domain.Order;
import base.order.view.OrderView;
import base.util.InputData;
import base.util.OutputData;

public class OrderManager {

    private static final OrderManager orderManager;

    private static final int MIN_OPTION = 1;
    private static final int MAX_OPTION = 4;
    private static final int ADD_PRODUCT = 1;
    private static final int SHOW_CURRENT_ORDER_PRICE = 2;
    private static final int SHOW_BILL = 3;
    private static final int FINISH_ORDER = 4;

    private Order order;
    private OrderDAOImp orderDAOImp;

    private boolean orderFinished;
    private int quantity;

    private OrderManager() {
        orderDAOImp = new OrderDAOImp();
    }

    static {
        orderManager = new OrderManager();
    }

    public static OrderManager getInstance() {
        return orderManager;
    }

    public void makeAnOrder() {
        orderFinished = false;
        order = new Order(EmployeeManager.getInstance().getEmployeeName());
        int maxOption = ProductManager.getInstance().getProducts().size();

        OrderView.askForProductsQuantity();
        quantity = InputData.getOption(1, maxOption);
        OutputData.borrarPantalla();
        do {
            OrderView.printOrderMenu();
            int option = InputData.getOption(MIN_OPTION, MAX_OPTION);
            OutputData.borrarPantalla();
            actionByOption(option);
        } while (!orderFinished);
    }

    private void actionByOption(int option) {
        switch (option) {
            case ADD_PRODUCT:
                OutputData.borrarPantalla();
                if (canAddProducts()) {
                    System.out.println("Opcion 1 seleccionada");
                    OrderView.addProduct();
                } else {
                    OutputData.printError("No puede añadir mas productos");
                }
                break;
            case SHOW_CURRENT_ORDER_PRICE:
                System.out.println("Opcion 2 seleccionada");
                System.out.println("\nPrecio actual del pedido: " + order.getTotalPrice() + "\u20AC");
                break;
            case SHOW_BILL:
                OutputData.borrarPantalla();
                if (!order.getProducts().isEmpty()) {
                    System.out.println("Opcion 3 seleccionada");
                    OrderView.printOrderBill(order);
                    orderDAOImp.UpdateOrder(order);
                }else {
                    OutputData.printError("No ha agregado productos al pedido");
                }
                break;
            case FINISH_ORDER:
                OutputData.borrarPantalla();
                System.out.println("Opcion 4 seleccionada");
                orderFinished = true;
                break;
        }
    }

    private boolean canAddProducts() {
        int currentOrderSize = order.getProducts().size();
        return currentOrderSize < quantity;
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
            OutputData.borrarPantalla();
            OutputData.printSuccess("\nProducto anadido exitosamente");
        } else {
            OutputData.printError("Producto no existe");
        }
    }


}
