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

    // удаление узла по значению
    public boolean delByValue(T data) {
        if (head.getData() == data) {
            delHead();
            return true;
        } else {
            ListItem<T> previousItem = head;
            for (ListItem<T> currentItem = head.getNext(); currentItem != null; currentItem = currentItem.getNext()) {
                if (currentItem.getData() == data) {
                    previousItem.setNext(currentItem.getNext());
                    length--;
                    return true;
                } else {
                    previousItem = currentItem;
                }
            }
        }
        return false;
    }

    //	удаление первого элемента, пусть выдает значение элемента
    public T delHead() {
        T data = head.getData();
        head = head.getNext();
        return data;
    }

    // вставка узла после указанного узла
    public void insAfterListItem(ListItem<T> listItem, T data) {
        listItem.setNext(new ListItem<>(data, listItem.getNext()));
    }

    // удаление узла после указанного узла
    public void delAfterListItem(ListItem<T> listItem) {
        listItem.setNext(listItem.getNext().getNext());
    }
    //TODO разворот списка за линейное время
    //TODO копирование списка
}
