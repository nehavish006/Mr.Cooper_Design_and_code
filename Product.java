package com.cooper;

public class Product {
    private int prod_id;
    private String prod_name;
    private int prod_price;

    public Product(int prod_id, String prod_name,int prod_price) {
        this.prod_id = prod_id;
        this.prod_name = prod_name;
        this.prod_price=prod_price;
    }
    public Product(){

    }

    public int getID() {
        return prod_id;
    }

    public String getName() {
        return prod_name;
    }

    @Override
    public String toString() {
        return "Product{" +
                "Product ID='" + prod_id + '\'' +
                ", Product Name=" + prod_name +", Product Price=" +prod_price +
                '}';
    }
}