package com.cooper;

import java.util.*;

public class Main {

    private static ArrayList<Listprod> prods = new ArrayList<>();

    public static void main(String[] args) {

        Listprod prod = new Listprod("Swamy",112);

        prod.addProduct(12,"Tomato",20000);
        prod.addProduct(13,"Onion",30000);
        prod.addProduct(14,"Potato",15000);
        prods.add(prod);

        prod = new Listprod("Murugan",321);

        prod.addProduct(32,"Apple",24000);
        prod.addProduct(33,"Orange",30000);
        prod.addProduct(34,"Banana",10000);
        prods.add(prod);


        LinkedList<Product> prodList_1 = new LinkedList<>();

        prods.get(0).addToProdList("Tomato",prodList_1);
        prods.get(0).addToProdList("Onion",prodList_1);
        prods.get(1).addToProdList("Apple",prodList_1);
        prods.get(1).addToProdList("Orange",prodList_1);

        start(prodList_1);

    }

    private static void start(LinkedList<Product> prodList){
        Scanner sc = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Product> listIterator = prodList.listIterator();

        if(prodList.size() == 0){
            System.out.println("This product list have no products");
        }else {
            System.out.println("Current product for bid" + listIterator.next().toString());
            printMenu();
        }

        while(!quit){
            int action = sc.nextInt();
            sc.nextLine();
            
            switch (action){

                case 0:
                    System.out.println("Product bid list complete");
                    quit = true;
                    break;

                case 1:
                    if(!forward){
                        if(listIterator.hasNext()){
                        	listIterator.next();
                        }
                        forward = true;
                    }
                    if(listIterator.hasNext()){
                        System.out.println("Bid of current product "+listIterator.next().toString());
                    }else {
                        System.out.println("no product availble, reached to the end of the list");
                        forward = false;
                    }
                    break;
                case 2:
                    if(forward){
                        if (listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if(listIterator.hasPrevious()){
                        System.out.println("Current Bid "+listIterator.previous().toString());
                    }else {
                        System.out.println("we are the first product");
                        forward = false;
                    }
                    break;

                case 3:
                    if(forward){
                        if(listIterator.hasPrevious()){
                            System.out.println("Current Bid "+listIterator.previous().toString());
                            forward = false;
                        }else {
                            System.out.println("we are at the start of the list");
                        }
                    }else {
                        if(listIterator.hasNext()){
                            System.out.println("Current Bid "+listIterator.next().toString());
                            forward = true;
                        }else {
                            System.out.println("we have reached to the end of list");
                        }
                    }
                    break;

                case 4:
                    printList(prodList);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    if (prodList.size() >0){
                        listIterator.remove();
                        if(listIterator.hasNext()){
                            System.out.println("Current Bid "+listIterator.next().toString());
                        }
                        else {
                            if(listIterator.hasPrevious())
                            System.out.println("Current Bid "+listIterator.previous().toString());
                        }
                    }

            }
        }
    }

    private static void printMenu(){
        System.out.println("Available options\n press");
        System.out.println("0 - to quit\n"+
                "1 - to start bid of current product\n"+
                "2 - to view bid of previous product\n"+
                "3 - to rebid curent product\n"+
                "4 - list of all products \n"+
                "5 - print all available options\n"+
                "6 - delete current product after bid");
    }

    private static void printList(LinkedList<Product> prodList){
        Iterator<Product> iterator = prodList.iterator();
        System.out.println("-----------------");

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println("-----------------");
    }

}