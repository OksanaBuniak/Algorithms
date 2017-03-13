package Assignment2;

import java.util.*;

public class Deque<Item> implements Iterable<Item> {

    private ArrayList<Item> myArray;

    public Deque() {                           // construct an empty deque
        myArray = new ArrayList<>();
    }

    public boolean isEmpty() {                 // is the deque empty?
        return myArray.isEmpty();
    }

    public int size() {                        // return the number of items on the deque
        return myArray.size();
    }

    public void addFirst(Item item) {          // add the item to the front
        myArray.add(0, item);
    }

    public void addLast(Item item) {          // add the item to the end
        myArray.add(item);
    }

    public Item removeFirst() {               // remove and return the item from the front
        return myArray.remove(0);
    }

    public Item removeLast() {               // remove and return the item from the end
        return myArray.remove(size() - 1);
    }

    public Iterator<Item> iterator() {        // return an iterator over items in order from front to end
        return new ListIterator();
    }


    class ListIterator implements Iterator {
        private final Iterator<Item> itr = myArray.iterator();

        @Override
        public boolean hasNext() {
            return (itr.hasNext());
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return itr.next();
        }

    }

}