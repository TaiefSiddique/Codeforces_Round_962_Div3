import java.util.HashMap;
import java.util.Scanner;

public class E_v1 {
    static final int MOD = 1000000007;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            String s = scanner.next();
            System.out.println(countBalancedSubstrings(s));
        }
    }

    static long countBalancedSubstrings(String s) {
        int n = s.length();
        long result = 0;

        // To store the number of times each balance has occurred
        HashMap<Integer, Integer> balanceCount = new HashMap<>();

        // Initial balance and its count
        int balance = 0;
        balanceCount.put(balance, 1);

        // Traverse the string and compute the balance
        for (int i = 0; i < n; i++) {
            // Update balance
            if (s.charAt(i) == '1') {
                balance++;
            } else {
                balance--;
            }

            // If this balance has been seen before, add the count of its occurrences
            result = (result + balanceCount.getOrDefault(balance, 0)) % MOD;

            // Update the balance count
            balanceCount.put(balance, balanceCount.getOrDefault(balance, 0) + 1);
        }

        return result;
    }
}
