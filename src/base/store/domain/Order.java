package base.store.domain;

import base.product.domain.Product;

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
