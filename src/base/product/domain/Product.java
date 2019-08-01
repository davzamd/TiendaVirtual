package base.product.domain;

public class Product {

    private int code;
    private String name;
    private String description;
    private double price;

    public Product(int code, String name, String description, double price) {
        this.code = code;
        this.name = name;
        this.description = description;
        this.price = price;
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("%d %s %s %.2f", code, name, description, price);
    }
}
