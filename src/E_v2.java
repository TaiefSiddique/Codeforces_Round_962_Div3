import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class E_v2 {
    private static final int MOD = 1000000007;

    // Function to count the number of substrings with equal number of 0s and 1s
    private static long countEqualZerosOnes(String s) {
        int n = s.length();
        // Prefix difference array
        int[] diff = new int[n + 1];
        for (int i = 0; i < n; i++) {
            diff[i + 1] = diff[i] + (s.charAt(i) == '1' ? 1 : -1);
        }

        // Use a hashmap to count occurrences of each difference value
        Map<Integer, Long> countMap = new HashMap<>();
        long totalCount = 0;

        for (int i = 0; i <= n; i++) {
            int diffValue = diff[i];
            // Check how many times this diffValue has appeared before
            totalCount = (totalCount + countMap.getOrDefault(diffValue, 0L)) % MOD;
            // Update the count of this diffValue
            countMap.put(diffValue, countMap.getOrDefault(diffValue, 0L) + 1);
        }

        return totalCount;
    }

    // Function to sum the counts over all possible (l, r) pairs
    public static long sumOfCounts(String s) {
        long totalSum = 0;
        int n = s.length();

        // Iterate over all possible starting points l
        for (int l = 0; l < n; l++) {
            // Create substring s[l:]
            String substring = s.substring(l);
            totalSum = (totalSum + countEqualZerosOnes(substring)) % MOD;
        }

        return totalSum;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            String s = scanner.next();
            System.out.println(sumOfCounts(s));
        }
    }
}
