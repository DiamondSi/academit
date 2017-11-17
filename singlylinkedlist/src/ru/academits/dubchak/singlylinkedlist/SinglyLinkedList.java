package ru.academits.dubchak.singlylinkedlist;

public class SinglyLinkedList {
    private ListItem head;
    private int length;

    public SinglyLinkedList() {
        length = 0;
    }

    public int getLength() {
        return length;
    }

    public ListItem getHead() {
        return head;
    }

    public void insertItem(ListItem item) {
        item.setNext(head);
        head.setNext(item);
    }

    public ListItem getByIndex(int index) {
        if (index >= length) {
            return null;
        } else {
            ListItem currentItem = head;
            for (int i = 0; i <= index; i++) {
                currentItem = currentItem.getNext();
            }
            return currentItem;
        }
    }
}
