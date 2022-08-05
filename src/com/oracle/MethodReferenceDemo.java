package com.oracle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

@FunctionalInterface
interface MyFunctionalInterface {
    Person getPerson(String name, int age);
}
interface Greeting{
    void greet();
}
public class MethodReferenceDemo {
    public static int compareByAge(Person a, Person b) {
        return a.getAge().compareTo(b.getAge());
    }
    public void greet(){
        System.out.println("Hello!");
    }
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Madhuri", 24));
        personList.add(new Person("Mayank", 25));
        personList.add(new Person("Manali", 19));
        /*  Reference to static method */
        System.out.println("METHOD REFERENCE TO STATIC METHOD OF MAIN CLASS");
        System.out.println("SORT BY AGE: ");
        Collections.sort(personList, MethodReferenceDemo::compareByAge);
        personList.stream()
                .map(x -> x.getName())
                .forEach(System.out::println);
        Function<String, String> displayName = Person::displayName;
        System.out.println("METHOD REFERENCE TO STATIC METHOD OF PERSON CLASS");
        System.out.println(displayName.apply("Jhanvi"));
        /*  Reference to instance method */
        System.out.println("METHOD REFERENCE TO INSTANCE METHOD");
        MethodReferenceDemo methodReferenceDemo = new MethodReferenceDemo();
        Greeting greeting = methodReferenceDemo::greet;
        greeting.greet();
        /*  Reference to constructor */
        System.out.println("METHOD REFERENCE TO CONSTRUCTOR");
        MyFunctionalInterface mfi = Person::new;
        BiFunction<String, Integer, Person> f1 = Person::new;
        BiFunction<String, Integer, Person> f2 = (name, age) -> new Person(name, age);

        System.out.println(mfi.getPerson("Aditya", 30));
        System.out.println(f1.apply("Pooja", 18));
        System.out.println(f2.apply("Parag", 23));
    }
}
