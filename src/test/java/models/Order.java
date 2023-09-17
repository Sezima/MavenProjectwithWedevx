package models;

public class Order {
    private int orderID;
    private String product;
    private int quantity;

    public Order(int orderID, String product, int quantity) {
        this.orderID = orderID;
        this.product = product;
        this.quantity = quantity;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
