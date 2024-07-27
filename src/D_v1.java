import java.util.Scanner;

public class D_v1 {
    public static void main(String[] args) {
        Scanner ss = new Scanner(System.in);
        int t = ss.nextInt();

        while (t-- > 0) {
            long n = ss.nextLong();
            long x = ss.nextLong();
            long count = 0;

            for (long a = 1; a <= x - 2; a++) {
                for (long b = 1; b <= x - a - 1; b++) {
                    for (long c = 1; c <= x - a - b; c++) {
                        if (a + b + c <= x && a * b + a * c + b * c <= n) {
                            count++;
                        }
                    }
                }
            }

            System.out.println(count);
        }
        ss.close();
    }
}
