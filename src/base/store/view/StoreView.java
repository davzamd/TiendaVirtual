package base.store.view;


import base.util.Color;

public class StoreView {

    public static void welcome(){
        System.out.println(Color.WELCOME+"**********************************************************************************");
        System.out.println("Bienvenido por favor ingrese su codigo y contraseña para ingresar al sistema");
        System.out.println("**********************************************************************************"+Color.DEFAULT);
    }

    public static void printMainMenu() {
        System.out.println(Color.MENU);
        System.out.println("\n1. Hacer pedido");
        System.out.println("2. Modificar un producto");
        System.out.println("3. Cambiar contraseña empleado");
        System.out.println("4. Cerrar sesión");
        System.out.println(Color.DEFAULT);
    }


}
