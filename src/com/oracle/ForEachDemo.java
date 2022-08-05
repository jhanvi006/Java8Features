package com.oracle;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ForEachDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Mango");
        list.add("Banana");
        list.add("Grapes");

        /*  Using iterator */
        System.out.println("Using ITERATOR: ");
        Iterator itr = list.iterator();
        while (itr.hasNext()){
            System.out.print(itr.next()+" ");
        }
        /*  Using forEach Loop*/
        System.out.println("\nUsing forEach(): ");
        list.forEach(item -> System.out.print(item+" "));
    }
}
