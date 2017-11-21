package ru.academits.dubchak.singlylinkedlist;

public class SinglyLinkedList<T> {
    private ListItem<T> head;
    private int length;

    public SinglyLinkedList(ListItem<T> head) {
        this.head = head;
        this.length = 1;
    }

    //	получение размера списка
    public int getLength() {
        return length;
    }

    //	получение первого узла
    public ListItem<T> getHead() {
        return head;
    }

    //	получение значения по указанному индексу.
    public T getListItemData(int index) {
        return getListItem(index).getData();
    }

    //	изменение значения по указанному индексу.
    // Изменение значения по индексу пусть выдает старое значение.
    public T setListItemData(int index, T data) {
        T oldData = getListItemData(index);
        getListItem(index).setData(data);
        return oldData;
    }

    //	получение узла по индексу
    public ListItem<T> getListItem(int index) {
        if (index < 0 || index >= length) {
            throw new IllegalArgumentException(Integer.toString(index));
        }
        int i = 0;
        for (ListItem<T> p = head; p != null; p = p.getNext()) {
            if (i == index) {
                return p;
            }
            ++i;
        }
        return null;
    }

    // удаление элемента по индексу, пусть выдает значение элемента
    public T delListItem(int index) {
        if (index < 0 || index >= length) {
            throw new IllegalArgumentException(Integer.toString(index));
        }
        T delItemData = getListItemData(index);
        if (index == 0) {
            delHead();
        } else if (index == length - 1) {
            getListItem(index).setNext(null);
        } else {
            getListItem(index - 1).setNext(getListItem(index + 1));
        }
        length--;
        return delItemData;
    }

    //	вставка элемента в начало
    public void insFirstListItem(T data) {
        ListItem<T> p = new ListItem<>(data, head);
        length++;
    }

    //	вставка элемента по индексу
    public void insListItem(T data, int index) {
        if (index < 0 || index >= length) {
            throw new IllegalArgumentException(Integer.toString(index));
        } else {
            ListItem<T> p = new ListItem<>(data, getListItem(index));
            getListItem(index - 1).setNext(p);
            length++;
        }
    }

    //TODO удаление узла по значению
    public void delByValue(T data) {
        for (ListItem<T> p = head; p != null; p = p.getNext()) {
            if (p.getData() == data) {
//                p.setNext(p.getNext());
                length--;
            }
        }
    }

    //	удаление первого элемента, пусть выдает значение элемента
    public T delHead() {
        T data = head.getData();
        head = head.getNext();
        return data;
    }

    //TODO вставка и удаление узла после указанного узла
    //TODO разворот списка за линейное время
    //TODO копирование списка
}
