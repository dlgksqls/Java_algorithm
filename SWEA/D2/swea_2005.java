package D2;

import java.util.*;
public class swea_2005 {

    public static void main(String args[]) throws Exception {

        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int n = sc.nextInt();

            int[][] array = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j <= i; j++) {
                    if (j == 0 || j == i) {
                        array[i][j] = 1;
                        continue;
                    }
                    array[i][j] = array[i - 1][j - 1] + array[i - 1][j];
                }
            }

            System.out.println("#" + tc);
            for (int[] ints : array) {
                for (int answer : ints) {
                    if (answer == 0) continue;
                    System.out.print(answer + " ");
                }
                System.out.println();
            }
        }
    }
}
