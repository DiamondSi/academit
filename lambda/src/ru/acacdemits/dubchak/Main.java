package ru.acacdemits.dubchak;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        ArrayList<Person> persons = new ArrayList<>();
        persons.add(new Person("Dima",44));
        persons.add(new Person("Katya",41));
        persons.add(new Person("Anna",38));
        persons.add(new Person("Anna",14));
        persons.stream()
                .map(person-> person.getName())
                .distinct()
                .collect(Collectors.toList());

    }
}
