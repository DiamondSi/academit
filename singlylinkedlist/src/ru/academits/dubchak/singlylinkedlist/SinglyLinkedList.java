package ru.academits.dubchak.singlylinkedlist;

public class SinglyLinkedList<T> {
    private ListItem<T> head;
    private int length;

    public SinglyLinkedList(ListItem<T> head) {
        this.head = head;
        this.length = 1;
    }

    public ListItem<T> getHead() {
        return head;
    }

    public int getLength() {
        return length;
    }

    public T getListItemData(int index) {
        return getListItem(index).getData();
    }

    public T setListItemData(int index, T data) {
        T oldData = getListItemData(index);
        getListItem(index).setData(data);
        return oldData;
    }

    public ListItem<T> getListItem(int index) {
        if (index < 0 || index >= length) {
            throw new IllegalArgumentException(Integer.toString(index));
        }
        ListItem<T> p = head;
        for (int i = 1; i <= index; i++) {
            p = p.getNext();
        }
        return p;
    }

    public T delListItem(int index) {
        if (index < 0 || index >= length) {
            throw new IllegalArgumentException(Integer.toString(index));
        }
        T delItemData = getListItemData(index);
        if (index == 0) {
            head.setNext(getListItem(1));
        } else if (index == length - 1) {
            getListItem(index).setNext(null);
        } else {
            getListItem(index - 1).setNext(getListItem(index + 1));
        }
        length--;
        return delItemData;
    }

    public void insFirstListItem(T data) {
//        listItem.setNext(getHead().getNext());
//        getHead().setNext(listItem);
        ListItem<T> p = new ListItem<T>(data, head);
        length++;
    }

    public void insListItem(ListItem listItem, int index) {
        if (index < 0 || index >= length) {
            throw new IllegalArgumentException(Integer.toString(index));
        } else {
            listItem.setNext(getListItem(index));
            getListItem(index - 1).setNext(listItem);
            length++;
        }

    }

    public void delByValue(int data) {
        for (int i = 0; i < length; i++) {
            if (getListItem(i).getData() == data) {
                int deletedItemIndex = delListItem(i);
                i--;
                length--;
            }
        }
    }

}
