package ru.academits.dubchak.myarraylist;

public class MyArrayList<E> {
    private E[] items;
    private int length;

    public E get(int index) {
        //TODO бросить исключение если выход за length
        return items[index];
    }

    public void set(int index, E element) {
        //TODO бросить исключение если выход за length
        items[index] = element;
    }

    public void setItems(E[] items) {
        this.items = items;
    }

    public int size() {
        return length;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public void add(E element) {
        if (length >= items.length) {
            increaseCapacity();
        }
        items[length] = element;
        ++length;
    }

    private void increaseCapacity() {
        E[] old = items;
        items = new <E>[old.length * 2];
        System.arraycopy(old, 0, items, 0, old.length);
    }

    public void add(int index, E element) {
    }

    public void addAll(MyArrayList<E> MyArrayList) {
    }

    public boolean remove(E element) {
        return false;
    }

    public boolean remove(int index) {
        return false;
    }

    public void clear(int index) {
    }

    public boolean removeAll(MyArrayList<E> MyArrayList) {
        return false;
    }

    public boolean removeRange(MyArrayList<E> MyArrayList) {
        return false;
    }

    public boolean retainAll(MyArrayList<E> MyArrayList) {
        return false;
    }
}
