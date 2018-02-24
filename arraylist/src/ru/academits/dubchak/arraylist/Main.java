package ru.academits.dubchak.arraylist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

        MyArrayList<Integer> list2 = new MyArrayList<>();
        list2.addAll(Arrays.asList(1, 2, 3, 4, 5));

        ListIterator<Integer> iterator1 = list1.listIterator(1);
        while (iterator1.hasNext()) {
            System.out.println(iterator1.next());
        }
        System.out.println();
        ListIterator<Integer> iterator2 = list2.listIterator(1);
        while (iterator2.hasNext()) {
            System.out.println(iterator2.next());
        }

        System.out.println(list2);
        list2.remove(1);
        System.out.println(list2);
    }
}
