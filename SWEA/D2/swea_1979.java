package D2;

import java.util.*;
import java.io.*;

public class swea_1979 {

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int answer = 0;

            int[][] array = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    array[i][j] = sc.nextInt();
                }
            }

            for (int i = 0; i < n; i++) {
                int count = 0;
                for (int j = 0; j < n; j++) {
                    if (array[i][j] == 1) count++;
                    if (array[i][j] == 0 || j == n - 1) {
                        if (count == k) answer++;
                        count = 0;
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                int count = 0;
                for (int j = 0; j < n; j++) {
                    if (array[j][i] == 1) count++;
                    if (array[j][i] == 0 || j == n - 1) {
                        if (count == k) answer++;
                        count = 0;
                    }
                }
            }
            System.out.println("#" + tc + " " + answer);
        }
    }
}
