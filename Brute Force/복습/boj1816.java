package 복습;

import java.util.Scanner;

public class boj1816 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i=0; i<n; i++){
            long input = sc.nextLong();
            boolean flag = true;

            for(long j=2; j<=1000000; j++){
                if (input % j == 0){
                    flag = false;
                    break;
                }
            }
            if (flag) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
