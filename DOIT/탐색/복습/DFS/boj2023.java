package 탐색.복습.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class boj2023 {

    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        dfs(2, 1);
        dfs(3, 1);
        dfs(5, 1);
        dfs(7, 1);
    }

    private static void dfs(int number, int digit) {
        if (digit == n){
            if (isPrime(number)){
                System.out.println(number);
            }
            return;
        }
        for (int i=1; i<10; i++){
            if (i % 2 == 0) continue;
            if (isPrime(number * 10 + i)) {
                dfs(number * 10 + i, digit + 1);
            }
        }
    }

    private static boolean isPrime(int number) {
        for (int i=2; i<=number/2; i++){
            if (number % i == 0) return false;
        }
        return true;
    }
}