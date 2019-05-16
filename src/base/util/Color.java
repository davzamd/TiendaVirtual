package base.util;

public enum Color {
    ERROR("\u001B[31m"),
    SUCCESS("\u001B[32m"),
    DEFAULT("\u001B[37m");

    private String colorCode;

    Color(String colorCode) {
        this.colorCode = colorCode;
    }

    @Override
    public String toString() {
        return colorCode;
    }
}
