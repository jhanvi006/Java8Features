package com.oracle;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OptionalDemo {
    public static void main(String[] args) {
        String[] str = new String[10];
        str[5] = "Java Optional class example!";  // Setting value for 5th index
        Optional<String> checkNull = Optional.ofNullable(str[5]);
        if (checkNull.isPresent()){
            System.out.print(checkNull.get());
        }else System.out.println("It is null");
    }
}
