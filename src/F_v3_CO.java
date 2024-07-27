import java.util.*;

public class F_v3_CO {
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

            // Priority queue to keep track of the highest ai values
            PriorityQueue<int[]> maxHeap = new PriorityQueue<>((x, y) -> Integer.compare(y[0], x[0]));

            // Initialize the heap
            for (int i = 0; i < n; i++) {
                maxHeap.add(new int[]{a[i], b[i], i});
            }

            long score = 0;

            // Perform k operations
            for (int i = 0; i < k; i++) {
                if (maxHeap.isEmpty()) break;
                // Extract the maximum value
                int[] maxElem = maxHeap.poll();
                int maxVal = maxElem[0];
                int decVal = maxElem[1];

                // Add the maximum value to the score
                score += maxVal;

                // Update the value and re-insert into the heap if necessary
                int newVal = Math.max(0, maxVal - decVal);
                if (newVal > 0) {
                    maxHeap.add(new int[]{newVal, decVal, maxElem[2]});
                }
            }

            // Output the result for the current test case
            System.out.println(score);
        }
    }
}
