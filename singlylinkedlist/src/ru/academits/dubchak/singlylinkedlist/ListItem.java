package ru.academits.dubchak.singlylinkedlist;

public class ListItem {
    private int data;
    private ListItem next;

    public ListItem() {
    }

    public ListItem(int data) {
        this.data = data;
    }

    public ListItem(int data, ListItem next) {
        this.data = data;
        this.next = next;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public ListItem getNext() {
        return next;
    }

    public void setNext(ListItem next) {
        this.next = next;
    }
}
