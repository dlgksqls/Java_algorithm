package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1로_만들기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int x = Integer.parseInt(br.readLine());

        int[] array = new int[300001];
        for(int i=2; i<=x; i++) {
            array[i] = array[i-1] + 1; // 경우의 수 +1

            if (i % 2 == 0){
                array[i] = Math.min(array[i], array[i/2] + 1);
            }
            if (i % 3 == 0){
                array[i] = Math.min(array[i], array[i/3] + 1);
            }
            if (i % 5 == 0){
                array[i] = Math.min(array[i], array[i/5] + 1);
            }
        }

        System.out.println(array[x]);
    }
}
