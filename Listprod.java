package com.cooper;

import java.util.ArrayList;
import java.util.LinkedList;

public class Listprod {
    private String f_name;
    private int f_id;
    private ArrayList<Product> products;

    public Listprod(String f_name, int f_id) {
        this.f_name = f_name;
        this.f_id = f_id;
        this.products = new ArrayList<Product>();
    }
    public Listprod(){

    }

    public Product findProd(String prod_name){

        for(Product checkedProd : products){
            if(checkedProd.getName().equals(prod_name)) return checkedProd;
        }
        return null;
    }

    public boolean addProduct(int prod_id, String prod_name,int prod_price){
        if(findProd(prod_name) == null){
            products.add(new Product(prod_id,prod_name,prod_price));
//            System.out.println(prod_name+ "successfully added to the list");
            return true;
        }
        else {
//            System.out.println("Product with name "+ prod_name+ " already exist in the list");
            return false;
        }
    }

    

    public boolean addToProdList(String prod_name, LinkedList<Product> ProdList){
        for(Product checkedProd : this.products){
            if (checkedProd.getName().equals(prod_name)){
                ProdList.add(checkedProd);
                return true;
            }
        }
//        System.out.println(prod_name + "there is no such product in list");
        return false;
    }
}