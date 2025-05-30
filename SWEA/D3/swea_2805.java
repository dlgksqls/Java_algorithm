package D3;

import java.util.*;
public class swea_2805 {
    static int n;
    static int answer;
    static int [][] array;

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int tc = 1; tc <= T; tc++) {
            n = sc.nextInt();
            char[][] input = new char[n][n];
            array = new int[n][n];

            for(int i=0; i<n; i++){
                input[i] = sc.next().toCharArray();
                for(int j=0; j<n; j++){
                    array[i][j] = input[i][j] - '0';
                }
            }

            answer = 0;
            int mid = array.length / 2;
            cal(0, n, mid);

            left(mid-1);
            right(mid+1);

            System.out.println("#" + tc + " " + answer);
        }
    }

    private static void left(int y) {
        int count = 1;
        while(y >= 0){
            cal(count, n - count, y);
            y --;
            count++;
        }
    }

    private static void right(int y) {
        int count = 1;
        while(y < n){
            cal(count, n - count, y);
            y ++;
            count++;
        }
    }

    private static void cal(int count, int n, int y) {
        for (int i = count; i < n; i++) {
            answer += array[i][y];
        }
    }
}
