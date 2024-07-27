import java.util.Scanner;

class FenwickTree {
    private int size;
    private long[] tree;

    public FenwickTree(int size) {
        this.size = size;
        this.tree = new long[size + 1];
    }

    public void update(int idx, long value) {
        while (idx <= size) {
            tree[idx] += value;
            idx += idx & -idx;
        }
    }

    public long query(int idx) {
        long sum = 0;
        while (idx > 0) {
            sum += tree[idx];
            idx -= idx & -idx;
        }
        return sum;
    }
}

public class D_v2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {
            long n = scanner.nextLong();
            long x = scanner.nextLong();
            long count = 0;

            FenwickTree fenwickTree = new FenwickTree((int) x);

            for (int a = 1; a <= x; a++) {
                for (int b = a; b <= x; b++) {
                    int c_max = (int) Math.min(x - a - b, x);
                    if (c_max > 0) {
                        // Count valid c values and update Fenwick Tree
                        for (int c = b; c <= c_max; c++) {
                            if (a * b + a * c + b * c <= n) {
                                count++;
                                fenwickTree.update(c, 1);
                            }
                        }
                    }
                }
            }

            System.out.println(count);
        }

        scanner.close();
    }
}
