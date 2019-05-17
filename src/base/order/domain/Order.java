package base.order.domain;

import base.product.domain.Product;
import base.util.Color;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private List<Product> products;
    private double totalPrice;
    private String employeeName;

    public Order(String employeeName) {
        this.employeeName = employeeName;
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
        totalPrice += product.getPrice();
    }

    public boolean checkProductOnList(int code) {
        for (Product product : products) {
            if (product.getCode() == code) {
                return true;
            }
        }
        return false;
    }

    public String generateBill() {
        StringBuilder bill = new StringBuilder();
        bill.append("\n\tFactura Simplificada: ");
        bill.append("\n------------------------------------------------------------------------------------\n");
        for (Product product : products) {
            bill.append(String.format("%s \t\t\t\t%d%n", "Codigo:", product.getCode()));
            bill.append(String.format("%s \t\t\t\t%s%n", "Nombre:", product.getName()));
            bill.append(String.format("%s\t\t\t%s%n", "Descripcion:", product.getDescription()));
            bill.append(String.format("%s \t\t\t\t%.2f%n%n", "Precio:", product.getPrice()));
        }
        bill.append("------------------------------------------------------------------------------------\n");
        bill.append(String.format("\t%s %s%s%n", "El precio TOTAL es:", getTotalPrice(),"\u20AC"));
        bill.append(String.format("\t%s %s%n", "Atendido por:", getEmployeeName()));
        return bill.toString();
    }

    public List<Product> getProducts() {
        return products;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }
}
