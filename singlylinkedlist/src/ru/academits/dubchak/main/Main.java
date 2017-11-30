package ru.academits.dubchak.main;

import ru.academits.dubchak.singlylinkedlist.ListItem;
import ru.academits.dubchak.singlylinkedlist.SinglyLinkedList;

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList(new ListItem(0));
//        System.out.println(list);
        list.insFirstListItem(1);
        list.insFirstListItem(2);
        list.insFirstListItem(3);
        list.insFirstListItem(4);
        System.out.println(list);
        SinglyLinkedList<Integer> list1 = list.copySinglyLinkedList();
        list.reverseSinglyLinkedList();

//        list.insListItem(1,0);

        System.out.println(list);
        System.out.println(list1);
    }
}
