package Assignment2;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;

import java.util.Iterator;

public class DequeTest {

    @Test
    public void test1() {
        Deque<String> deq = new Deque<String>();
        deq.addFirst("A"); //A
        deq.addFirst("B"); //BA
        deq.addFirst("C"); //CBA
        deq.addLast("D"); //CBAD
        deq.addLast("E"); //CBADE
        deq.removeFirst(); //BADE
        deq.removeLast(); //BAD
        System.out.println(deq.size());
        deq.forEach(System.out::println);
    }

}