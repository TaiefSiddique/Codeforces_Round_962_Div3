import java.util.Scanner;

public class C_v2 {
    public static void main(String[] args) {
        Scanner ss = new Scanner(System.in);
        int t = ss.nextInt();
        while (t-- > 0) {
            int n = ss.nextInt();
            int q = ss.nextInt();
            ss.nextLine();

            char[] a = ss.nextLine().toCharArray();
            char[] b = ss.nextLine().toCharArray();

            // Prefix frequency arrays
            int[][] freqA = new int[n + 1][26];
            int[][] freqB = new int[n + 1][26];

            for (int i = 1; i <= n; i++) {
                for (int j = 0; j < 26; j++) {
                    freqA[i][j] = freqA[i - 1][j];
                    freqB[i][j] = freqB[i - 1][j];
                }
                freqA[i][a[i - 1] - 'a']++;
                freqB[i][b[i - 1] - 'a']++;
            }

            for (int i = 0; i < q; i++) {
                int l = ss.nextInt();
                int r = ss.nextInt();
                ss.nextLine();

                // Convert to zero-based index
                l--;
                r--;

                int minChanges = 0;
                for (int j = 0; j < 26; j++) {
                    int countA = freqA[r + 1][j] - freqA[l][j];
                    int countB = freqB[r + 1][j] - freqB[l][j];
                    if (countA > countB) {
                        minChanges += countA - countB;
                    }
                }

                System.out.println(minChanges);
            }
        }
        ss.close();
    }
}
