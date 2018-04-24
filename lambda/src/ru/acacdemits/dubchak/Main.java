package ru.acacdemits.dubchak;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;


public class Main {
    public static void main(String[] args) {
//        создать список из нескольких людей
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Dima", 44));
        persons.add(new Person("Olya", 42));
        persons.add(new Person("Olya", 23));
        persons.add(new Person("Misha", 8));
        persons.add(new Person("Dan", 4));
        persons.add(new Person("Dan", 14));
        persons.add(new Person("Anna", 30));
        persons.add(new Person("Anna", 20));
        persons.add(new Person("Anna", 13));

//        А) получить список уникальных имен
        List<String> uniqueNames = persons.stream().map(Person::getName).distinct().collect(Collectors.toList());

//        Б) вывести список уникальных имен в формате:
//        Имена: Иван, Сергей, Петр.
        System.out.println("Unique names: " + uniqueNames.stream().collect(Collectors.joining(", ")));

//        В) получить список людей младше 18, посчитать для них средний возраст
        System.out.println("Average age less than 18: " + persons.stream().filter(age -> age.getAge() < 18).mapToInt(Person::getAge).average());

//        Г) при помощи группировки получить Map, в котором ключи – имена, а значения – средний возраст
        Map<String, Double> namesByAverageAge = persons.stream()
                .collect(Collectors.groupingBy(Person::getName, Collectors.averagingDouble(Person::getAge)));
        namesByAverageAge.forEach((name, ages) -> System.out.printf("Name %s: %s%n", name, ages));

        //        Д) получить людей, возраст которых от 20 до 45, вывести в консоль их имена в порядке убывания возраста
        List<String> personsBetweenTwentyAndFortyFive = persons.stream()
                .filter(age -> age.getAge() >= 20 && age.getAge() <= 45)
                .sorted(Comparator.comparingInt(Person::getAge))
                .map(Person::getName).collect(Collectors.toList());
        System.out.println(personsBetweenTwentyAndFortyFive);

//        Создать бесконечный поток корней чисел. С консоли прочитать число – сколько элементов нужно вычислить, затем – распечатать эти элементы
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input stream length:");
        int streamLength = scanner.nextInt();
        DoubleStream.iterate(0, x -> x + 1).map(Math::sqrt).limit(streamLength).forEach(System.out::println);

//        Попробовать реализовать бесконечный поток чисел Фиббоначчи
        List<Long> fibonacci = Stream.iterate(new long[]{0, 1}, pair -> new long[]{pair[1], pair[0] + pair[1]})
                .limit(streamLength)
                .map(p -> p[0])
                .collect(Collectors.toList());
        System.out.println(fibonacci);
    }
}
