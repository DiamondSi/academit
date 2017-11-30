package ru.academits.dubchak.main;

import ru.academits.dubchak.singlylinkedlist.ListItem;
import ru.academits.dubchak.singlylinkedlist.SinglyLinkedList;

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList(new ListItem(0));
        list.insFirstListItem(1);
        list.insFirstListItem(2);
        list.insFirstListItem(3);
        list.insFirstListItem(4);
                list.reverseSinglyLinkedList();
//        System.out.println(list.getLength());
        System.out.println(list.getHead());
//        System.out.println(list.getListItemData(0));
//        System.out.println(list.getListItemData(4));
//        System.out.println(list.setListItemData(1, 999));
//        System.out.println(list.getHead());
        System.out.println(list.getListItem(3));
//        System.out.printf("list: %s%n", list);
//        SinglyLinkedList<Integer> list1 = list.copySinglyLinkedList();
//        System.out.println(list1.getHead());
//        list.reverseSinglyLinkedList();
//        System.out.println(list.getHead());
//        System.out.println(list.getListItemData(0));
//        System.out.println(list.getListItemData(4));
//        System.out.printf("list: %s%n", list);
//        System.out.printf("list1: %s%n", list1);
    }
}
