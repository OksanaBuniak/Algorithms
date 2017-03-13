package Percolation;

import org.junit.Test;

import java.io.*;

import static org.junit.Assert.*;

public class PercolationTest {

    @Test
    public void test2D() {
        Percolation app = new Percolation(2);
        app.open(0, 0);
        assertTrue(app.isOpen(0, 0));
        assertFalse(app.isOpen(1, 0));
        assertFalse(app.percolates());
        app.open(0, 1);
        assertTrue(app.isOpen(0, 1));
        assertTrue(app.percolates());
    }

    @Test
    public void test1D() {
        Percolation app = new Percolation(1);
        app.open(0, 0);
        assertTrue(app.isOpen(0, 0));
        assertTrue(app.percolates());
    }


    @Test
    public void test5DT() {
        Percolation app = new Percolation(5);
        app.open(1, 0);
        app.open(3, 0);
        app.open(2, 1);
        app.open(2, 2);
        app.open(3, 3);
        app.open(4, 4);
        app.open(2, 0);
        app.open(2, 3);
        app.open(4, 3);
        assertTrue(app.percolates());
    }

    @Test
    public void test5DF() {
        Percolation app = new Percolation(5);
        app.open(1, 0);
        app.open(3, 0);
        app.open(2, 2);
        app.open(3, 3);
        app.open(4, 4);
        app.open(2, 0);
        app.open(2, 3);
        app.open(4, 3);
        assertFalse(app.percolates());
    }

    @Test
    public void test10DF() {
        Percolation app = new Percolation(10);
        app.open(1, 0);
        app.open(2, 1);
        app.open(3, 2);
        app.open(3, 3);
        app.open(3, 4);
        app.open(4, 5);
        app.open(5, 6);
        app.open(5, 7);
        app.open(5, 8);
        app.open(5, 9);
        assertFalse(app.percolates());
    }

    @Test
    public void test10DT() {
        Percolation app = new Percolation(10);
        app.open(1, 0);
        app.open(2, 1);
        app.open(3, 2);
        app.open(3, 3);
        app.open(3, 4);
        app.open(4, 5);
        app.open(5, 6);
        app.open(5, 7);
        app.open(5, 8);
        app.open(5, 9);
        app.open(2, 0);
        app.open(2, 2);
        app.open(4, 4);
        app.open(4, 6);
        assertTrue(app.percolates());
        assertTrue(app.isFull(1, 0));
        assertTrue(app.isFull(4, 4));
        assertTrue(app.isFull(5, 9));
        //assertTrue(app.isFull(3, 9));
        assertFalse(app.isFull(7, 0));
        assertFalse(app.isFull(5, 5));
        assertFalse(app.isFull(3, 8));
    }

    @Test
    public void testFileInput8() throws IOException {
        Percolation app = loadAppFromFile("input8.txt");
        assertTrue(app.percolates());
    }


    private Percolation loadAppFromFile(String fileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("/Users/Oksana/Documents/CourseraAlgorithms/percolation/" + fileName));

        Percolation app;
        try {
            String line = br.readLine();
            int N = Integer.parseInt(line);
            app = new Percolation(N);

            while (line != null) {
                line = br.readLine();
                if (line != null) {
                    String[] tokens = line.trim().split(" +");
                    if (tokens.length != 2) {
                        throw new IllegalArgumentException();
                    }
                    if (tokens.length == 2) {
                        int j = Integer.parseInt(tokens[0]) - 1;
                        int i = Integer.parseInt(tokens[1]) - 1;
                        app.open(i, j);
                    }
                }
            }
        } finally {
            br.close();
        }
        return app;
    }

}