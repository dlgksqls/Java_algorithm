package 복습;

import java.util.Scanner;

public class boj14568 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int answer = 0;

        for(int a=0; a<=n; a++){
            for(int b=0; b<=n; b++){
                for(int c=0; c<=n; c++){
                    if ((a+b+c) == n){
                        if (a>=b+2){
                            if(a!=0 && b!=0 && c!=0){
                                if (c % 2 == 0) answer ++;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
