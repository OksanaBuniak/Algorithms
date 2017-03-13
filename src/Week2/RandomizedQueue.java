package Week2;
import java.util.*;

public class RandomizedQueue<Item> implements Iterable<Item> {

    public Item[] s;
    private int N = 0;
    Random ran = new Random();

    public RandomizedQueue() { // construct an empty randomized queue
        s = (Item[]) new Object[1];
    }

    public boolean isEmpty() { // is the queue empty?
        return N == 0;
    }

    public int size() { // return the number of items on the queue
        return N;
    }

    public void enqueue(Item item) { // add the item
        if (N == s.length) {
            resize(2 * s.length);
        }
        s[N] = item;
        N++;
    }

    public Item dequeue() { // remove and return a random item
        if (N <= 0) {
            throw new NoSuchElementException();
        }
        int x = ran.nextInt(N);
        Item item = s[x];
        s[x] = s[N - 1];
        s[N-1] = null;
        N--;
        if (N > 0 && N == s.length/4) {
            resize(s.length/2);
        }
        return item;
    }

    public Item sample() { // return (but do not remove) a random item
        if (N <= 0) {
            throw new NoSuchElementException();
        }
        int x = ran.nextInt(N);
        return s[x];
    }

    private void resize(int capacity)
    {
        Item[] copy = (Item[]) new Object[capacity];
        for (int i = 0; i < N; i++) {
            copy[i] = s[i];
        }
        s = copy;
    }

    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<Item>
    {
        private int i = N;
        public boolean hasNext() { return i > 0; }
        public void remove() { /* not supported */ }
        public Item next() { return s[--i]; }
    }

    public static void main(String[] args) { // unit testing (optional)

    }

}

