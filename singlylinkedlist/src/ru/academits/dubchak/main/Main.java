package ru.academits.dubchak.main;

import ru.academits.dubchak.singlylinkedlist.ListItem;
import ru.academits.dubchak.singlylinkedlist.SinglyLinkedList;

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>(new ListItem<>(0));
        System.out.println(list);
        list.deleteHead();
        System.out.println(list);
        list.insertFirstListItem(1);
        list.insertFirstListItem(2);
        list.insertFirstListItem(3);
        list.insertFirstListItem(null);
        System.out.println(list.getHead());
        System.out.println(list.getLength());
        System.out.println(list.getListItemData(0));
        System.out.println(list.setListItemData(1, 999));
        System.out.println(list.getListItem(0));
        System.out.println();
        System.out.println(list);
        System.out.println(list.deleteListItem(2));
        System.out.println(list);
        System.out.println();
        list.insertFirstListItem(100);
        list.insertFirstListItem(null);
        list.insertListItem(null, 4);
        list.insertListItem(222, 4);
        System.out.println(list.deleteByValue(null));
        System.out.println(list);
        list.insertAfterListItem(list.getHead().getNext().getNext().getNext(), 444);
        System.out.println(list);
        list.deleteAfterListItem(list.getHead().getNext().getNext());
        System.out.println(list);
        list.reverse();
        System.out.println("list:  " + list);
        SinglyLinkedList<Integer> list1 = list.copy();
        System.out.println("list1: " + list1);
        System.out.println();
        System.out.println(list);
        list.insertListItem(777, list.getLength());
        System.out.println("add to the end " + list);
        System.out.println();
        list.deleteHead();
        SinglyLinkedList<Integer> list3 = new SinglyLinkedList<>();
        System.out.println(list3);
        SinglyLinkedList<Integer> list4 = list3.copy();
        System.out.println(list4);
    }
}
