package 자료구조.복습.배열;

import java.io.BufferedReader;
import java.util.Scanner;

public class boj11720 {

    static int n;
    static int answer = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String input = sc.next();

        char[] array = input.toCharArray();

        for (char c : array) {
            answer += c - '0';
        }

        System.out.println(answer);
    }
}
