package 자료구조.복습.투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class boj2018 {

    static int n;
    static int sum = 1;
    static int answer = 1; // N이 15일때 15만 뽑는 경우의 수를 미리 알고 초기화
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        int start_index = 1;
        int end_index = 1;

        while (end_index != n){
            if (sum == n){
                answer ++;
                end_index ++;
                sum += end_index;
            }
            else if (sum < n){
                end_index ++;
                sum += end_index;
            }
            else if (sum > n){
                sum -= start_index;
                start_index ++;
            }
        }
        System.out.println(answer);
        sc.close();
    }
}
