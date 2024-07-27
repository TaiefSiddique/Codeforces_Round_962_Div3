import java.util.PriorityQueue;
import java.util.Scanner;

public class F_v1 {
    public static void main(String[] args) {
        Scanner ss=new Scanner(System.in);
        int t=ss.nextInt();
        while(t-->0){
            int n;
            int k;
            n=ss.nextInt();
            k=ss.nextInt();
            int[]a=new int[n];
            int[]b=new int[n];
            for(int i=0;i<n;i++)a[i]= ss.nextInt();
            for(int i=0;i<n;i++)b[i]= ss.nextInt();
            // Max-Heap implementation using PriorityQueue with a custom comparator
            PriorityQueue<int[]> maxHeap = new PriorityQueue<>((x, y) -> Integer.compare(y[0], x[0]));

            // Initialize the heap
            for (int i = 0; i < n; i++) {
                maxHeap.add(new int[] {a[i], i});
            }

            long score = 0;

            // Perform k operations
            for (int i = 0; i < k; i++) {
                // Extract the maximum value
                int[] maxElem = maxHeap.poll();
                int maxVal = maxElem[0];
                int index = maxElem[1];

                // Add the maximum value to the score
                score += maxVal;

                // Update the value in array a
                int newVal = Math.max(0, a[index] - b[index]);
                a[index] = newVal;

                // Push the updated value back into the heap
                maxHeap.add(new int[] {newVal, index});
            }

            // Output the result for the current test case
            System.out.println(score);
        }
    }
}
