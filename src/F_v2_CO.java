import java.util.PriorityQueue;
import java.util.Scanner;

public class F_v2_CO {
    public static void main(String[] args) {
        Scanner ss = new Scanner(System.in);
        int t = ss.nextInt();
        while (t-- > 0) {
            int n = ss.nextInt();
            int k = ss.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];
            for (int i = 0; i < n; i++) a[i] = ss.nextInt();
            for (int i = 0; i < n; i++) b[i] = ss.nextInt();

            PriorityQueue<int[]> maxHeap = new PriorityQueue<>((x, y) -> Integer.compare(y[0], x[0]));

            // Initialize the heap
            for (int i = 0; i < n; i++) {
                maxHeap.add(new int[]{a[i], b[i]});
            }

            long score = 0;

            // Perform k operations
            for (int i = 0; i < k; i++) {
                // Extract the maximum value
                int[] maxElem = maxHeap.poll();
                int maxVal = maxElem[0];
                int decVal = maxElem[1];

                // Add the maximum value to the score
                score += maxVal;

                // Update the value and re-insert into the heap
                int newVal = Math.max(0, maxVal - decVal);
                maxHeap.add(new int[]{newVal, decVal});
            }

            // Output the result for the current test case
            System.out.println(score);
        }
    }
}
