package com.oracle;

import java.util.ArrayList;
import java.util.List;

@FunctionalInterface
interface Multiply{
    int mult(int a, int b);
}
public class LambdaExpressionDemo {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.forEach(n -> System.out.print((n*2)+" "));

        System.out.println();
        Multiply multiply = (a,b) -> (a*b);
        System.out.println(multiply.mult(4, 8)+" ");
    }
}
