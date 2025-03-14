package 자료구조.복습.배열;

import java.util.Scanner;

public class boj1546 {

    static int n;
    static int[] array;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int max = 0;
        float answer = 0;
        array = new int[n];

        for (int i=0; i<n; i++){
            int input = sc.nextInt();
            if (max < input) max = input;
            array[i] = input;
        }

        for (int i=0; i<n; i++){
            answer += (float) array[i] / max * 100;
        }

        System.out.println(answer / n);
    }
}
