package Week2;

import java.util.*;

public class Deque<Item> implements Iterable<Item> {

    private Node first;
    private Node last;
    private int size = 0;

    public class Node
    {
        public Item item;
        public Node next;
        Node previous;

        Node(Item item) {
            this.item = item;
        }
    }

    // construct an empty deque
    public Deque() {
        first = null;
        last = null;
    }

    // is the deque empty?
    public boolean isEmpty() {
        return first == null;
    }

    // return the number of items on the deque
    public int size() {
        return size;
    }

    // add the item to the front
    public void addFirst(Item item) {
        assertNonNull(item);

//        Node oldfirst = first;
//        first = new Node(item);
//        first.next = oldfirst;
//        size = size + 1;
//        if (size == 1) {
//            last = first;
//        } else {
//            oldfirst.previous = first;
//        }

        Node newFirst = new Node(item);
        concat(newFirst, first);
        first = newFirst;
        size++;
        if (size == 1) {
            last = first;
        }
    }

    // add the item to the end
    public void addLast(Item item) {
        assertNonNull(item);

//        Node newlast = new Node(item);
//        if (size != 0) {
//            last.next = newlast;
//            newlast.previous = last;
//        }
//        last = newlast;
//        size = size + 1;
//        if (size == 1) {
//            first = last;
//        }
        Node newLast = new Node(item);
        concat(last, newLast);
        last = newLast;
        size++;
        if (size == 1) {
            first = last;
        }
    }

    private void concat(Node left, Node right) {
        if (left == null || right == null) {
            return;
        }

        left.next = right;
        right.previous = left;
    }

    // remove and return the item from the front
    public Item removeFirst() {
        if (isEmpty()) {
            return null;
        }

        Item item = first.item;
        first = first.next;
        if (first != null) {
            first.previous = null;
        }
        size = size - 1;
        if (size == 0) {
            last = null;
        }
        return item;
    }

    // remove and return the item from the end
    public Item removeLast() {
        if (isEmpty()) {
            return null;
        }

        Item item = last.item;
        last = last.previous;
        if (last != null) {
            last.next = null;
        }
        size = size - 1;
        if (size == 0) {
            first = null;
        }
        return item;
    }

    // return an iterator over items in order from front to end
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item>
    {
        private Node current = first;
        public boolean hasNext() { return current != null; }
        public void remove() { /* not supported */ }
        public Item next()
        {
            if (current == null) {
                throw new NoSuchElementException();
            }
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    public static void main(String[] args) {

    }

    private void assertNonNull(Item item) {
        if (item == null) {
            throw new java.lang.NullPointerException();
        }
    }
}
