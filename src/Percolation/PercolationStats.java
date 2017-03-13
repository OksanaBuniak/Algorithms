package Percolation;

import edu.princeton.cs.algs4.*;

public class PercolationStats {

    private Percolation percTest;
    public double[] fractions;
    private int count;

    public PercolationStats(int N, int T) {   // perform T independent experiments on an N-by-N grid
        count = T;
        fractions = new double[T];
        for (int a = 0; a < T; a++) {
            percTest = new Percolation(N);
            int openedSites = 0;
            while (!percTest.percolates()) {
                int i = StdRandom.uniform(N);
                int j = StdRandom.uniform(N);
                if (!percTest.isOpen(i, j)) {
                    percTest.open(i, j);
                    openedSites++;
                }
            }
            double fraction = (double) openedSites / (N * N);
            fractions[a] = fraction;
        }
    }

    public double mean() {                      // sample mean of percolation threshold
        return StdStats.mean(fractions);
    }

    public double stddev() {                  // sample standard deviation of percolation threshold
        return StdStats.stddev(fractions);
    }

    public double confidenceLo() {            // low  endpoint of 95% confidence interval
        return mean() - ((1.96 * stddev()) / Math.sqrt(count));
    }

    public double confidenceHi() {             // high endpoint of 95% confidence interval
        return mean() + ((1.96 * stddev()) / Math.sqrt(count));
    }

    public static void main(String[] args) {    // test client (described below)
        Stopwatch measureTime = new Stopwatch();
        PercolationStats stats = new PercolationStats(200, 100);
        double time = measureTime.elapsedTime();
        System.out.println(time);

        String confidence = stats.confidenceLo() + ", " + stats.confidenceHi();
        StdOut.println("mean = " + stats.mean());
        StdOut.println("stddev = " + stats.stddev());
        StdOut.println("95% confidence interval = " + confidence);
    }
}
