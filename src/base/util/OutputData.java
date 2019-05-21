package base.util;

public class OutputData {
    public static void printSuccess(String output) {
        printWithFormat(Color.SUCCESS, output);
    }

    public static void printError(String output) {
        printWithFormat(Color.ERROR, output);
    }

    public static void printBill(String bill){

        printWithFormat(Color.BILL,bill);
    }

    private static void printWithFormat(Color color, String output) {
        System.out.print(color);
        System.out.println(output);
        System.out.print(Color.DEFAULT);
    }

    public static void borrarPantalla() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
