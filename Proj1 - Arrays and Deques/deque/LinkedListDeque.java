package deque;

import edu.princeton.cs.algs4.In;

public class LinkedListDeque<T> implements Deque<T>{

    private class IntNode {
        public T item;
        public IntNode next;
        public IntNode prev;

        public IntNode(T i, IntNode next, IntNode prev) {
            item = i;
            this.next = next;
            this.prev = prev;
        }

        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            IntNode that = (IntNode) o;
            return item == that.item;
        }
    }

    private IntNode sentinel;
    private int size;

    public LinkedListDeque() {
        sentinel = new IntNode(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    public void addFirst(T item) {
        sentinel.next = new IntNode(item, sentinel.next, sentinel);
        if (size == 0) {
            sentinel.prev = sentinel.next;
            size++;
        } else {
            sentinel.next.next.prev = sentinel.next;
            size++;
        }
    }

    public void addLast(T item) {
        sentinel.prev = new IntNode(item, sentinel, sentinel.prev);
        if (size==0) {
            sentinel.next = sentinel.prev;
            size++;
        } else {
            sentinel.prev.prev.next = sentinel.prev;
            size++;
        }
    }

    @Override
    public int size() { return this.size; }

    public void printDeque() {
        IntNode printvalue = sentinel;
        for (int i = 0; i < size; i++) {
            printvalue = printvalue.next;
            if (i == size - 1){
                System.out.print(printvalue.item);
            } else {
                System.out.print(printvalue.item + " ");
            }
        }
        System.out.print("\n");
    }

    public T removeFirst() {
        if (isEmpty()) return null;
        T holder = sentinel.next.item;
        sentinel.next.next.prev = sentinel.next.prev;
        sentinel.next = sentinel.next.next;
        size -= 1;
        return holder;

    }

    public T removeLast() {
        if (isEmpty()) return null;
        T holder = sentinel.prev.item;
        sentinel.prev.prev.next = sentinel.prev.next;
        sentinel.prev = sentinel.prev.prev;
        size -= 1;
        return holder;
    }

    public T get(int index) {
        IntNode getvalue = sentinel;
        if (index < 0 || isEmpty() || index >= size) return null;
        while (index >= 0) {
            getvalue = getvalue.next;
            index -= 1;
        }
        return getvalue.item;
    }

    public T getRecursive(int index) {
        IntNode getvalue = sentinel;
        if (index < 0 || isEmpty() || index >= size) return null;
        return getRecursivehelper(index, sentinel);
    }

    private T getRecursivehelper(int index, IntNode getvalue) {
        if (index == 0) {
            getvalue = getvalue.next;
            return getvalue.item;
        } else {
            index--;
            getvalue = getvalue.next;
            return getRecursivehelper(index, getvalue);
        }
    }

    public boolean equals(Object o){
        if (this == o) return true;
        //if (o == null || getClass() != o.getClass()) return false;
        if (o == null) return false;
        if (getClass() != o.getClass() && !(o instanceof Deque)) return false;

        Deque<T> list = (Deque<T>) o;
        if (size != list.size()) return false;

        int index1 = 0;
        int index2 = 0;

        while(this.get(index1) == null && index1 < this.size() - 1) {
            index1++;
        }

        while(list.get(index2) == null && index2 < list.size() - 1) {
            index2++;
        }

        int temp = index1;
        while (index1 < size + temp) {
            if (this.get(index1).equals(list.get(index2)) == false)  {
                return false;
            }
            index1++;
            index2++;
        }
        return true;
    }

}
