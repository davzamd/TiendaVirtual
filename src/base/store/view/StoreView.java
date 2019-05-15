package base.store.view;


public class StoreView {

    public static void bienvenido(){
        System.out.println("**********************************************************************************");
        System.out.println("Bienvenido por favor ingrese su codigo y contraseña para ingresar al sistema");
        System.out.println("**********************************************************************************");
    }

    public static void printMainMenu() {
        System.out.println("\n");
        System.out.println("1. Hacer pedido");
        System.out.println("2. Modificar un producto");
        System.out.println("3. Cambiar contraseña empleado");
        System.out.println("4. Cerrar sesión");
    }


}
