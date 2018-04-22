package ru.acacdemits.dubchak;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Main {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Dima", 44));
        personList.add(new Person("Olya", 42));
        personList.add(new Person("Olya", 23));
        personList.add(new Person("Misha", 8));
        personList.add(new Person("Dan", 4));
        Stream<Person> stream = personList.stream();
        System.out.println("Names: " + stream.map(x -> x.getName()).distinct().collect(Collectors.joining(",")));
        System.out.println("Average age less than 18: " + stream.filter(age -> age.getAge() < 18).mapToInt(x -> x.getAge()).average());
    }
}
