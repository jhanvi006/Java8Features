package com.oracle;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Product{
    int id;
    String name;
    double price;
    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
public class StreamDemo {
    public static void main(String[] args) {
        List<Product> productsList = new ArrayList<Product>();
        //Adding Products
        productsList.add(new Product(1,"HP Laptop",25000));
        productsList.add(new Product(2,"Dell Laptop",30000));
        productsList.add(new Product(3,"Lenevo Laptop",28000));
        productsList.add(new Product(4,"Sony Laptop",31000));
        productsList.add(new Product(5,"Apple Laptop",35000));
        List<Double> productPriceList = new ArrayList<>();
        /*  without stream */
        System.out.println("FILTER WITHOUT STREAM: ");
        for(Product product: productsList){
            if(product.price<30000){
                productPriceList.add(product.price);
            }
        }
        System.out.println(productPriceList);
        /*  with stream */
        System.out.println("FILTER WITH STREAM: ");
        productsList.stream()
                .filter(item -> item.price<30000)
                .map(item -> item.price)
                .forEach(System.out::println);
        System.out.println("COUNT ITEMS WITH STREAM: ");
        long count = productsList.stream()
                .filter(product->product.price<30000)
                .count();
        System.out.println(count);
        System.out.println("LIST TO MAP WITH STREAM: ");
        Map<Integer,String> productPriceMap = productsList.stream()
                        .collect(Collectors.toMap(p->p.id, p->p.name));
        System.out.println(productPriceMap);
        System.out.println("CALCULATE TOTAL PRICE WITH STREAM: ");
        Double totalPrice = productsList.stream()
                .map(product->product.price)
                .reduce(0.0,(sum, price)->sum+price);
        System.out.println("Total Price: "+totalPrice);
        System.out.println("FIND ITEM WITH STREAM: ");
        Product product = productsList.stream().parallel()
                .filter(item -> item.price>30000)
                .findFirst().orElse(null);
        System.out.println(product.name+" -> "+product.price);
        System.out.println("FIND ANY METHOD");
        Product product1 = productsList.stream().parallel()
                .filter(item -> item.price>30000)
                .findAny().orElse(null);
        System.out.println(product1.name+" -> "+product1.price);
    }
}
