package ru.academits.dubchak.arraylist;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> integerArrayList=new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            integerArrayList.add(i);
        }
        System.out.println(integerArrayList);
    }
}
