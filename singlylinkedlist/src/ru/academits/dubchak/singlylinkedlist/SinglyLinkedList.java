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

    public ListItem<T> getListItem(int index) {
        if (index < 0 || index >= length) {
            throw new IllegalArgumentException(Integer.toString(index));
        } else {
            int i = index;
            for (ListItem<T> p = head; p != null; p = p.getNext()) {
                i--;
                if (i == 0) {
                    return p;
                }
            }
        }
        return null;
    }


    public T setListItemData(int index, T data) {
        T oldData = getListItem(index);
        getListItem(index).setData(data);
        return oldData;
    }

    public int delListItem(int index) {
        if (index < 0 || index >= length) {
            throw new IllegalArgumentException(Integer.toString(index));
        } else {
            int delItemData = getListItem(index).getData();
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
    }

    public void insFirstListItem(ListItem listItem) {
        listItem.setNext(getHead().getNext());
        getHead().setNext(listItem);
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
