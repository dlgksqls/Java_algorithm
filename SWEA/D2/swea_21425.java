package D2;

import java.util.Scanner;

public class swea_21425 {

    public static void main(String args[]) throws Exception
    {
        Scanner scan = new Scanner(System.in);

        int T = scan.nextInt();

        for(int i = 0; i < T; i++) {
            int A = scan.nextInt();
            int B = scan.nextInt();
            int N = scan.nextInt();
            int count = 0;

            while(A <= N && B <= N){
                if (A < B) {
                    A += B;
                }else {
                    B += A;
                }
                count ++;
            }

            System.out.println(count);
        }
    }
}
