package D2;

import java.util.*;

public class swea_2001 {

    static int n;
    static int m;
    static int[][] array;
    static int answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            n = sc.nextInt();
            m = sc.nextInt();
            answer = 0;

            array = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    array[i][j] = sc.nextInt();
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int sum = 0;
                    for (int k = 0; k < m; k++) {
                        int nx = i + k;
                        for(int l = 0; l < m; l++){
                            int ny = j + l;
                            if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                                sum += array[nx][ny];
                            }
                        }
                    }
                    answer = Math.max(answer, sum);
                }
            }
            System.out.println("#" + tc + " " + answer);
        }
    }
}
