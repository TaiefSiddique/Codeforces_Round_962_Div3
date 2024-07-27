
import java.util.Scanner;
import java.util.Arrays;

public class C_v1 {
    public static void main(String[] args) {
        Scanner ss = new Scanner(System.in);
        int t = ss.nextInt();
        while (t-- > 0) {
            int n = ss.nextInt();
            int q = ss.nextInt();
            ss.nextLine();

            char[] a = ss.nextLine().toCharArray();
            char[] b = ss.nextLine().toCharArray();

            for (int i = 0; i < q; i++) {
                int l = ss.nextInt();
                int r = ss.nextInt();

                // Convert to zero-based index
                l--;
                r--;

                int[] freqA = new int[26];
                int[] freqB = new int[26];

                // Count frequencies for the substring a[l..r]
                for (int j = l; j <= r; j++) {
                    freqA[a[j] - 'a']++;
                    freqB[b[j] - 'a']++;
                }

                int minChanges = 0;
                for (int k = 0; k < 26; k++) {
                    if (freqA[k] > freqB[k]) {
                        minChanges += freqA[k] - freqB[k];
                    }
                }

                System.out.println(minChanges);
            }
        }
        ss.close();
    }
}
