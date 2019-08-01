package base.store.control;

import base.employee.control.EmployeeManager;
import base.employee.view.EmployeeView;
import base.order.control.OrderManager;
import base.product.control.ProductManager;
import base.store.view.StoreView;
import base.util.InputData;
import base.util.OutputData;

public class StoreManager {

    private static final int MAKE_ORDER = 1;
    private static final int MODIFY_PRODUCT = 2;
    private static final int MODIFY_PASSWORD = 3;
    private static final int LOGOUT = 4;


    private static final int MIN_OPTION = 1;
    private static final int MAX_OPTION = 4;

    public void start() {
        OutputData.borrarPantalla();
        StoreView.welcome();
        while (true) {
            EmployeeView.login();
            StoreView.printMainMenu();
            int option = InputData.getOption(MIN_OPTION, MAX_OPTION);
            OutputData.borrarPantalla();
            actionByOption(option);
        }
    }

    private void actionByOption(int option) {
        switch (option) {
            case MAKE_ORDER:
                OutputData.borrarPantalla();
                System.out.println("Opcion 1 seleccionada");
                OrderManager.getInstance().makeAnOrder();
                break;
            case MODIFY_PRODUCT:
                OutputData.borrarPantalla();
                System.out.println("Opcion 2 seleccionada");
                ProductManager.getInstance().modifyProducts();
                break;
            case MODIFY_PASSWORD:
                OutputData.borrarPantalla();
                System.out.println("Opcion 3 seleccionada");
                EmployeeView.changePassword();
                break;
            case LOGOUT:
                OutputData.borrarPantalla();
                System.out.println("Opcion 4 seleccionada");
                EmployeeManager.getInstance().logout();
                break;
        }
    }
}
