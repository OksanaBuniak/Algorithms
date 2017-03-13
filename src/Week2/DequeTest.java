package Week2;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static junit.framework.TestCase.fail;

public class DequeTest {

    @Test
    public void test1() {
        Week2.Deque<String> deq = new Week2.Deque<String>();
        deq.addFirst("A"); //A
        deq.addFirst("B"); //BA
        deq.addFirst("C"); //CBA
        deq.addLast("D"); //CBAD
        deq.addLast("E"); //CBADE
        deq.removeFirst(); //BADE
        deq.removeLast(); //BAD
        System.out.println(deq.size());
        deq.forEach(System.out::print);
    }


    @Test
    public void test2() {
        Week2.Deque<String> deq = new Week2.Deque<String>();
        deq.addLast("A"); //A
        deq.addLast("B"); //AB
        deq.addFirst("C"); //CAB
        deq.addLast("D"); //CABD
        deq.addFirst("E"); //ECABD
        deq.removeFirst(); //CABD
        deq.removeLast(); //CAB
        System.out.println(deq.size());
        deq.forEach(System.out::print);
    }

    @Test
    public void test3() {
        Week2.Deque<String> deq = new Week2.Deque<String>();
        deq.addLast("A"); //A
        deq.removeFirst(); //
        deq.removeLast(); //
        System.out.println(deq.size());
        deq.forEach(System.out::print);
    }

    @Test
    public void test4() {
        Week2.Deque<String> deq = new Week2.Deque<String>();
        deq.addFirst("A"); //A
        deq.removeFirst(); //
        deq.removeFirst(); //
        System.out.println(deq.size());
        deq.forEach(System.out::print);

    }

    @Test
    public void test5() {
        Week2.Deque<String> deq = new Week2.Deque<String>();
        deq.addFirst("A"); //A
        deq.removeFirst(); //
        deq.addLast("B");
        deq.removeFirst(); //
        System.out.println(deq.size());
        deq.forEach(System.out::print);
    }

    @Test
    public void test6() {
        Week2.Deque<String> deq = new Week2.Deque<String>();
        deq.addFirst(null); //A
        System.out.println(deq.size());
        deq.forEach(System.out::print);
    }

    @Test
    public void shouldThrowOnIteratorFailure() {
        Deque<String> deq = new Deque<>();
        Iterator<String> iterator = deq.iterator();
        try {
            iterator.next();
            fail();
        } catch (NoSuchElementException e) {
            // Should catch an exception
        }
    }


}