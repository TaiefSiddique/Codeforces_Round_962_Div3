import java.util.Scanner;

public class B_v1 {
    public static void main(String[] args) {
        Scanner ss = new Scanner(System.in);
        int t = ss.nextInt();
        while (t-- > 0) {
            int n = ss.nextInt();
            int k = ss.nextInt();
            int[][] a = new int[n][n];

            // Read the grid
            for (int i = 0; i < n; i++) {
                String row = ss.next();  // Read row as a string to avoid multiple nextInt calls
                for (int j = 0; j < n; j++) {
                    a[i][j] = row.charAt(j) - '0';  // Convert char to int
                }
            }

            int newSize = n / k;
            int[][] reduced = new int[newSize][newSize];

            // Reduce the grid
            for (int i = 0; i < newSize; i++) {
                for (int j = 0; j < newSize; j++) {
                    reduced[i][j] = a[i * k][j * k];
                }
            }

            // Print the reduced grid
            for (int i = 0; i < newSize; i++) {
                for (int j = 0; j < newSize; j++) {
                    System.out.print(reduced[i][j]);
                }
                System.out.println();
            }
        }
        ss.close();
    }
}
