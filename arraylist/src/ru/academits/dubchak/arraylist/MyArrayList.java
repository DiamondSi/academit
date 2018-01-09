package ru.academits.dubchak.arraylist;

import java.util.*;
import java.util.function.Consumer;

public class MyArrayList<E> implements List<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private final E[] EMPTY_ITEMS = (E[]) new Object[0];
    private final E[] DEFAULT_CAPACITY_EMPTY_ITEMS = (E[]) new Object[0];
    transient E[] items;
    private int size;
    private int modCount;

    public MyArrayList() {
        this.items = DEFAULT_CAPACITY_EMPTY_ITEMS;
    }

    public MyArrayList(int capacity) {
        if (capacity > 0) {
            items = (E[]) new Object[capacity];
        } else if (capacity != 0) {
            throw new IllegalArgumentException("Illegal capacity: " + capacity);
        } else {
            this.items = EMPTY_ITEMS;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        return this.indexOf(o) >= 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new MyIterator();
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(this.items, this.size);
    }

    // копируем список в переданный аргументом массив-приемник,
    // если массив-приемник меньше - создаем новый массив нужной длины
    // если массив-приемник длинее списка, тозаполняем лишние элементы массива значением null TODO не понимаю как это работает, надо протестировать
    @Override
    public <E1> E1[] toArray(E1[] array) {
        if (array.length < this.size) {
            return (E1[]) Arrays.copyOf(items, size, array.getClass());
        } else {
            System.arraycopy(this.items, 0, array, 0, this.size);
            if (array.length > this.size) {
                array[this.size] = null;
            }
            return array;
        }
    }

    @Override
    public boolean add(E e) {
        if (size >= items.length) {
            increaseCapacity();
        }
        items[size] = e;
        ++size;
        ++modCount;
        return true;
    }

    private void increaseCapacity() {
        items = Arrays.copyOf(items, items.length * 2);
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(o, items[i])) {
                this.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object object : c) {
            if (!this.contains(c)) {
                return false;
            }
        }
        return true;
    }


    // TODO

    /**
     * Appends all of the elements in the specified collection to the end of
     * this list, in the order that they are returned by the specified
     * collection's iterator (optional operation).  The behavior of this
     * operation is undefined if the specified collection is modified while
     * the operation is in progress.  (Note that this will occur if the
     * specified collection is this list, and it's nonempty.)
     *
     * @param c collection containing elements to be added to this list
     * @return <tt>true</tt> if this list changed as a result of the call
     * @throws UnsupportedOperationException if the <tt>addAll</tt> operation
     *                                       is not supported by this list
     * @throws ClassCastException            if the class of an element of the specified
     *                                       collection prevents it from being added to this list
     * @throws NullPointerException          if the specified collection contains one
     *                                       or more null elements and this list does not permit null
     *                                       elements, or if the specified collection is null
     * @throws IllegalArgumentException      if some property of an element of the
     *                                       specified collection prevents it from being added to this list
     * @see #add(Object)
     */
    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }


    // TODO

    /**
     * Inserts all of the elements in the specified collection into this
     * list at the specified position (optional operation).  Shifts the
     * element currently at that position (if any) and any subsequent
     * elements to the right (increases their indices).  The new elements
     * will appear in this list in the order that they are returned by the
     * specified collection's iterator.  The behavior of this operation is
     * undefined if the specified collection is modified while the
     * operation is in progress.  (Note that this will occur if the specified
     * collection is this list, and it's nonempty.)
     *
     * @param index index at which to insert the first element from the
     *              specified collection
     * @param c     collection containing elements to be added to this list
     * @return <tt>true</tt> if this list changed as a result of the call
     * @throws UnsupportedOperationException if the <tt>addAll</tt> operation
     *                                       is not supported by this list
     * @throws ClassCastException            if the class of an element of the specified
     *                                       collection prevents it from being added to this list
     * @throws NullPointerException          if the specified collection contains one
     *                                       or more null elements and this list does not permit null
     *                                       elements, or if the specified collection is null
     * @throws IllegalArgumentException      if some property of an element of the
     *                                       specified collection prevents it from being added to this list
     * @throws IndexOutOfBoundsException     if the index is out of range
     *                                       (<tt>index &lt; 0 || index &gt; size()</tt>)
     */
    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }


    // TODO

    /**
     * Removes from this list all of its elements that are contained in the
     * specified collection (optional operation).
     *
     * @param c collection containing elements to be removed from this list
     * @return <tt>true</tt> if this list changed as a result of the call
     * @throws UnsupportedOperationException if the <tt>removeAll</tt> operation
     *                                       is not supported by this list
     * @throws ClassCastException            if the class of an element of this list
     *                                       is incompatible with the specified collection
     *                                       (<a href="Collection.html#optional-restrictions">optional</a>)
     * @throws NullPointerException          if this list contains a null element and the
     *                                       specified collection does not permit null elements
     *                                       (<a href="Collection.html#optional-restrictions">optional</a>),
     *                                       or if the specified collection is null
     * @see #remove(Object)
     * @see #contains(Object)
     */
    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }


    // TODO

    /**
     * Retains only the elements in this list that are contained in the
     * specified collection (optional operation).  In other words, removes
     * from this list all of its elements that are not contained in the
     * specified collection.
     *
     * @param c collection containing elements to be retained in this list
     * @return <tt>true</tt> if this list changed as a result of the call
     * @throws UnsupportedOperationException if the <tt>retainAll</tt> operation
     *                                       is not supported by this list
     * @throws ClassCastException            if the class of an element of this list
     *                                       is incompatible with the specified collection
     *                                       (<a href="Collection.html#optional-restrictions">optional</a>)
     * @throws NullPointerException          if this list contains a null element and the
     *                                       specified collection does not permit null elements
     *                                       (<a href="Collection.html#optional-restrictions">optional</a>),
     *                                       or if the specified collection is null
     * @see #remove(Object)
     * @see #contains(Object)
     */
    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        ++modCount;
        for (int i = 0; i < size; i++) {
            items[i] = null;
        }
        size = 0;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        return items[index];
    }

    @Override
    public E set(int index, E element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        E temp = items[index];
        items[index] = element;
        return temp;
    }

    @Override
    public void add(int index, E element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        ++size;
        if (size > items.length) {
            increaseCapacity();
        }
        System.arraycopy(items, index, items, index + 1, size - 1 - index);
        items[index] = element;
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        if (index < size - 1) {
            System.arraycopy(items, index + 1, items, index, size - index - 1);
        }
        E temp = items[index];
        items[size] = null;
        --size;
        ++modCount;
        return temp;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(items[i], o)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        for (int i = size - 1; i >= 0; i--) {
            if (Objects.equals(items[i], o)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public ListIterator<E> listIterator() {
        return new MyListIterator();
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        return new MyListIterator(index);
    }


    // TODO
    public void ensureCapacity() {
    }

    public void trimToSize() {
        ++modCount;
        if (size < items.length) {
            items = size == 0 ? EMPTY_ITEMS : Arrays.copyOf(items, size);
        }
    }

    // Метод sublist реализовывать не нужно
    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }

    private class MyIterator implements Iterator<E> {
        int currentIndex = -1;
        int initialModCount = modCount;

        @Override
        public boolean hasNext() {
            if (initialModCount != modCount) {
                throw new ConcurrentModificationException();
            }
            return currentIndex + 1 < size;
        }

        @Override
        public E next() {
            if (initialModCount != modCount) {
                throw new ConcurrentModificationException();
            }
            if (currentIndex + 1 > size) {
                throw new NoSuchElementException();
            }
            ++currentIndex;
            return items[currentIndex];
        }

        @Override
        public void remove() {
            if (initialModCount != modCount) {
                throw new ConcurrentModificationException();
            }
            MyArrayList.this.remove(currentIndex);
            initialModCount = modCount;
        }

        // не надо реализовывать
        @Override
        public void forEachRemaining(Consumer<? super E> consumer) {
            return;
        }
    }

    private class MyListIterator extends MyIterator implements ListIterator<E> {
        private int currentIndex = -1;
        private int initialModCount = modCount;

        public MyListIterator() {
        }

        public MyListIterator(int index) {
            this.currentIndex = index;
        }

        @Override
        public boolean hasPrevious() {
            if (initialModCount != modCount) {
                throw new ConcurrentModificationException();
            }
            return currentIndex - 1 >= 0;
        }

        @Override
        public E previous() {
            if (initialModCount != modCount) {
                throw new ConcurrentModificationException();
            }
            if (currentIndex - 1 < 0) {
                throw new NoSuchElementException();
            }
            --currentIndex;
            return items[currentIndex];
        }

        @Override
        public int nextIndex() {
            return currentIndex + 1;
        }

        @Override
        public int previousIndex() {
            return currentIndex - 1;
        }

        @Override
        public void set(E e) {
            items[currentIndex] = e;
        }

        @Override
        public void add(E e) {
            MyArrayList.this.add(currentIndex, e);
            initialModCount = modCount;
        }
    }
}
