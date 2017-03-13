package Week2;

import com.sun.tools.javac.util.List;
import org.junit.Test;

import java.util.Arrays;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class RandomizedQueueTest {

    @Test
    public void test1() {
        RandomizedQueue<String> arr = new RandomizedQueue<>();
        List<String> letters = List.of("A", "B", "C", "D", "E");
        for (String letter : letters) {
            arr.enqueue(letter);
        }
        assertEquals(5, arr.size());

        assertTrue(letters.contains(arr.sample()));
        assertTrue(letters.contains(arr.sample()));
        assertTrue(letters.contains(arr.sample()));
        assertTrue(letters.contains(arr.sample()));
        assertTrue(letters.contains(arr.sample()));

        arr.dequeue();
        assertEquals(4, arr.size());
        arr.dequeue();
        assertEquals(3, arr.size());
        arr.dequeue();
        assertEquals(2, arr.size());
        arr.dequeue();
        assertEquals(1, arr.size());
        arr.dequeue();
        assertEquals(0, arr.size());
    }

    @Test
    public void testExceptionOnEmpty() {
        RandomizedQueue<String> arr = new RandomizedQueue<>();
        try {
            arr.sample();
            fail();
        } catch(NoSuchElementException e) {

        }
    }

    @Test
    public void testExceptionOnEmptyDeque() {
        RandomizedQueue<String> arr = new RandomizedQueue<>();
        try {
            arr.dequeue();
            fail();
        } catch(NoSuchElementException e) {

        }
    }



}