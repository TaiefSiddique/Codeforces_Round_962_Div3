import java.util.*;

public class F_v4 {
    public static void main(String[] args) {
        Scanner ss = new Scanner(System.in);
        int t = ss.nextInt();
        while (t-- > 0) {
            int n = ss.nextInt();
            int k = ss.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];

            // Read input arrays
            for (int i = 0; i < n; i++) a[i] = ss.nextInt();
            for (int i = 0; i < n; i++) b[i] = ss.nextInt();

            // Use a TreeMap to track the values and their counts
            TreeMap<Integer, Integer> valueMap = new TreeMap<>(Collections.reverseOrder());

            // Initialize the TreeMap
            for (int i = 0; i < n; i++) {
                valueMap.put(a[i], valueMap.getOrDefault(a[i], 0) + 1);
            }

            long score = 0;

            // Perform k operations
            for (int i = 0; i < k; i++) {
                if (valueMap.isEmpty()) break;

                // Get the maximum value
                Map.Entry<Integer, Integer> maxEntry = valueMap.pollFirstEntry();
                int maxVal = maxEntry.getKey();
                int count = maxEntry.getValue();

                // Add the maximum value to the score
                score += (long) maxVal * count;

                // Calculate the new value and re-insert if necessary
                int newVal = maxVal - b[0]; // As b[i] is same for all, just use b[0]
                if (newVal > 0) {
                    valueMap.put(newVal, valueMap.getOrDefault(newVal, 0) + count);
                }
            }

            // Output the result for the current test case
            System.out.println(score);
        }
    }
}
