package Percolation;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

import java.util.Arrays;

public class Percolation {

    private Boolean[] array;
    private int size;
    private WeightedQuickUnionUF union;
    private int top;
    private int bottom;

    public Percolation(int N) { // create N-by-N grid, with all sites blocked
        array = new Boolean[N * N];
        Arrays.fill(array, Boolean.FALSE);
        size = N;
        top = N * N;
        bottom = N * N + 1;
        union = new WeightedQuickUnionUF(N * N + 2);
    }

    public void open(int i, int j) {          // open site (row i, column j) if it is not open already
        int k = coordinateTransform(i, j);
        array[k] = true;

        unionIfValid(i, j, i - 1, j);
        unionIfValid(i, j, i + 1, j);
        unionIfValid(i, j, i, j - 1);
        unionIfValid(i, j, i, j + 1);

        unionVirtualIfFrontier(i, j);
    }

    private void unionIfValid(int i1, int j1, int i2, int j2) {
        if (i2 < 0 || j2 < 0 || i2 >= size || j2 >= size) {
            return;
        }
        if (isOpen(i2, j2)) {
            int coord1 = coordinateTransform(i1, j1);
            int coord2 = coordinateTransform(i2, j2);
            union.union(coord1, coord2);
        }
    }

    private void unionVirtualIfFrontier(int i, int j) {
        int k = coordinateTransform(i, j);

        if (j == 0) {
            union.union(top, k);
        }
        if (j == size - 1) {
            union.union(k, bottom);
        }
    }

    public boolean isOpen(int i, int j) {     // is site (row i, column j) open?
        return array[coordinateTransform(i, j)];
    }

    public boolean isFull(int i, int j) {     // is site (row i, column j) full?
        return (union.connected(top, coordinateTransform(i, j)) && (isOpen(i, j)));
    }

    public boolean percolates() {            // does the system percolate?
        return union.connected(top, bottom);
    }

    private int coordinateTransform(int i, int j) {
        return j * size + i;
    }

    public static void main(String[] args) {    // test client (described below) {

    }
}



    /*public void connectVirtual(int N) {
        if ((N == 0) && (isOpen(0, 0))) {
            union.union(0, 1);
            union.union(0, 2);
        }
        for (int i = 0; i < N; i++) {
            if (isOpen(i, 0)) {
                union.union(top, i);
            }
            if (isOpen(i, N - 1)) {
                union.union((N - 1) * N + i, bottom);
            }
        }
    }*/

/*
        if (k != size * size - 1) {
            if (isOpen(i + 1, j)) {
                union.union(k, k + 1);
            }
        }
        if (k != 0) {
            if (isOpen(i - 1, j)) {
                union.union(k, k - 1);
            }
            if (k >= size) {
                if (isOpen(i, j - 1)) {
                    union.union(k, k - size);
                }
            }
        }
        if (k <= size * size - size - 1) {
            if (isOpen(i, j + 1)) {
                union.union(k, k + size);
            }
        }
*/

