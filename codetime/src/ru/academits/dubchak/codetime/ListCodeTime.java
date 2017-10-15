package ru.academits.dubchak.codetime;

import java.util.ArrayList;
import java.util.Arrays;

public class ListCodeTime {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 1, 1, 2, 2, 3, 4, 4, 4, 5, 6, 1, 1, 1));
        System.out.println(list);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 2 == 0) {
                list.remove(i);
                i--;
            }
        }
        System.out.println(list);
        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2, 1, 1, 2, 2, 3, 4, 4, 4, 5, 6, 1, 1, 1));
        System.out.println(list1);
        ArrayList<Integer> list2 = new ArrayList<>();
        for (Integer element : list1) {

        }
    }
}
