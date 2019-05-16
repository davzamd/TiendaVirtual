package base.util;

public class OutputData {
    public static void printSuccess(String output) {
        printWithFormat(Color.SUCCESS, output);
    }

    public static void printError(String output) {
        printWithFormat(Color.ERROR, output);
    }

    private static void printWithFormat(Color color, String output) {
        System.out.print(color);
        System.out.println(output);
        System.out.print(Color.DEFAULT);
    }
}
