package ru.academits.dubchak.singlylinkedlist;

import java.util.Objects;

public class SinglyLinkedList<T> {
    private ListItem<T> head;
    private int length;

    public SinglyLinkedList() {
    }

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
        ListItem<T> p = getListItem(index);
        T oldData = p.getData();
        p.setData(data);
        return oldData;
    }

    //	получение узла по индексу
    public ListItem<T> getListItem(int index) {
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
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
    public T deleteListItem(int index) {
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        T oldData = null;
        if (index == 0) {
            oldData = head.getData();
            deleteHead();
        } else {
            ListItem<T> previousItem = getListItem(index - 1);
            previousItem.setNext(previousItem.getNext().getNext());
            --length;
        }
        return oldData;
    }

    //	вставка элемента в начало
    public void insertFirstListItem(T data) {
        head = new ListItem<>(data, head);
        length++;
    }

    //	вставка элемента по индексу
    public void insertListItem(T data, int index) {
        if (index < 0 || index > length) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        if (index == 0) {
            insertFirstListItem(data);
        } else {
            ListItem<T> previousItem = getListItem(index - 1);
            previousItem.setNext(new ListItem<>(data, previousItem.getNext()));
            length++;
        }

    }

    // удаление узла по значению
    public boolean deleteByValue(T data) {
        if (Objects.equals(data, head.getData())) {
            deleteHead();
            return true;
        } else {
            ListItem<T> previousItem = head;
            for (ListItem<T> currentItem = head.getNext(); currentItem != null; currentItem = currentItem.getNext()) {
                if (Objects.equals(data, currentItem.getData())) {
                    previousItem.setNext(currentItem.getNext());
                    length--;
                    return true;
                }
                previousItem = currentItem;
            }
        }
        return false;
    }

    //	удаление первого элемента, пусть выдает значение элемента
    public T deleteHead() {
        if (length == 0) {
            throw new NullPointerException("List is empty. Head deleting is impossible");
        }
        T data = head.getData();
        head = head.getNext();
        --length;
        return data;
    }

    // вставка узла после указанного узла
    public void insertAfterListItem(ListItem<T> listItem, T data) {
        listItem.setNext(new ListItem<>(data, listItem.getNext()));
        ++length;
    }

    // удаление узла после указанного узла
    public void deleteAfterListItem(ListItem<T> listItem) {
        listItem.setNext(listItem.getNext().getNext());
        --length;
    }

    // разворот списка за линейное время
    public void reverseSinglyLinkedList() {
        if (head != null) {
            ListItem<T> previousItem = head;
            ListItem<T> nextItem = head.getNext();
            previousItem.setNext(null);
            while (nextItem != null) {
                ListItem<T> currentItem = nextItem;
                nextItem = currentItem.getNext();
                currentItem.setNext(previousItem);
                previousItem = currentItem;
            }
            head = previousItem;
        }
    }

    // копирование списка
    public SinglyLinkedList<T> copySinglyLinkedList() {
        SinglyLinkedList<T> singlyLinkedList = new SinglyLinkedList<>();
        if (length > 0) {
            singlyLinkedList.insertFirstListItem(head.getData());
            ListItem<T> currentItem = singlyLinkedList.head;
            for (ListItem<T> p = head.getNext(); p != null; p = p.getNext()) {
                singlyLinkedList.insertAfterListItem(currentItem, p.getData());
                currentItem = currentItem.getNext();
            }
        }
        return singlyLinkedList;
    }

    @Override
    public String toString() {
        return "SinglyLinkedList{" +
                "head=" + head +
                ", length=" + length +
                '}';
    }
}
