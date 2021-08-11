package deque;

import java.sql.Array;

public class ArrayDeque<T> implements Deque<T>{

    private T[] array_list;
    private int size;

    public ArrayDeque() {
        this.array_list = (T[]) new Object[8];
        this.size = 0;
    }

    @Override
    public void addFirst(T item) {
        T[] a;
        if (size < 8) {
            a = (T[]) new Object[8];
        } else {
            a = (T[]) new Object[size + 1];
        }
        System.arraycopy(array_list,0, a, 1, size);
        a[0] = item;
        array_list = a;
        size++;
    }

    @Override
    public void addLast(T item) {
        T[] a;
        if (size < 8) {
            a = (T[]) new Object[8];
        } else {
            a = (T[]) new Object[size + 1];
        }
        System.arraycopy(array_list,0, a, 0, size);
        a[size] = item;
        array_list = a;
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        for (int i = 0; i < size; i++) {
            if (i == size - 1){
                System.out.print(array_list[i]);
            } else {
                System.out.print(array_list[i] + " ");
            }
        }
        System.out.print("\n");
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        T first = array_list[0];
        T[] a;
        if (size <= 8) {
            a = (T[]) new Object[8];
        } else {
            a = (T[]) new Object[size - 1];
        }
        System.arraycopy(array_list,1, a, 0, size - 1);
        array_list = a;
        size--;
        return first;
    }

    @Override
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        T last = array_list[size - 1];
        T[] a;
        if (size <= 8) {
            a = (T[]) new Object[8];
        } else {
            a = (T[]) new Object[size - 1];
        }
        System.arraycopy(array_list,0, a, 0, size - 1);
        array_list = a;
        size--;
        return last;
    }

    @Override
    public T get(int index) {
        if (isEmpty() || index >= size || index < 0) {
            return null;
        }
        return array_list[index];
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null) return false;
        if (getClass() != o.getClass() && !(o instanceof Deque)) return false;

        Deque<T> array = (Deque <T>) o;
        if (size != array.size()) return false;

        int index1 = 0;
        int index2 = 0;

        while(this.array_list[index1] == null && index1 < array_list.length - 1) {
            index1++;
        }

        while(array.get(index2) == null && index2 < array.size() - 1) {
            index2++;
        }

        int temp = index1;
        while (index1 < size + temp) {
            if (this.get(index1).equals(array.get(index2)) == false)  {
                return false;
            }
            index1++;
            index2++;
        }
        return true;
    }


}
