package model;

public class Product {
	
	private int id;
    private String name;
    private String productno;
    private int price;
    private int amount;

    // Constructor, getters, and setters
    public Product(int id, String name, String productno, int price, int amount) {
        this.id = id;
        this.name = name;
        this.productno = productno;
        this.price = price;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProductno() {
        return productno;
    }

    public void setProductno(String productno) {
        this.productno = productno;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}


