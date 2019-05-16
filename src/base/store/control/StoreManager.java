package base.store.control;

import base.employee.control.EmployeeManager;
import base.employee.view.EmployeeView;
import base.product.control.ProductManager;
import base.store.view.StoreView;
import base.util.InputData;

public class StoreManager {


    public static final int MIN_OPTION = 1;
    public static final int MAX_OPTION = 4;

    public void start() {
        StoreView.welcome();
        while (true) {
            EmployeeManager.getInstance().login();
            StoreView.printMainMenu();
            int option = InputData.getOption(MIN_OPTION, MAX_OPTION);
            actionByOption(option);
        }
    }

    private void actionByOption(int option) {
        switch (option) {
            case 1:
                System.out.println("Opcion 1 seleccionada");
                OrderManager.getInstance().makeAnOrder();
                break;
            case 2:
                System.out.println("Opcion 2 seleccionada");
                ProductManager.getInstance().modifyProducts();
                break;
            case 3:
                System.out.println("Opcion 3 seleccionada");
                EmployeeView.changePassword();
                break;
            case 4:
                System.out.println("Opcion 4 seleccionada");
                EmployeeManager.getInstance().logout();
                break;
        }
    }

}
