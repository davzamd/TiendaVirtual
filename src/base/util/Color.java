package base.util;

public enum Color{
    WELCOME("\u001B[33m"),
    ERROR("\u001B[31m"),
    SUCCESS("\u001B[32m"),
    DEFAULT("\u001B[0m"),
    MENU("\u001B[33m"),
    BILL("\u001B[36m");

    private String colorCode;

    Color(String colorCode) {
        this.colorCode = colorCode;
    }

    @Override
    public String toString() {
        return colorCode;
    }
}
