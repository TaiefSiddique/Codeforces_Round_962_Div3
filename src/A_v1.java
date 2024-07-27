import java.util.Scanner;

public class A_v1 {
    public static void main(String[] args) {
        Scanner ss=new Scanner(System.in);
        int t=ss.nextInt();
        while(t-->0){
            int n;
            n=ss.nextInt();
            if(n%4==0) System.out.println(n/4);
            else System.out.println(n/4+1);
        }
    }
}
