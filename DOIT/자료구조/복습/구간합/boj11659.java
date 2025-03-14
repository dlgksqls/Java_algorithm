package 자료구조.복습.구간합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class boj11659 {
    static int n;
    static int m;
    static int[] array;
    static int[] array_sum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        array_sum = new int[n+1];

        st = new StringTokenizer(br.readLine());
        for (int i=1; i<=n; i++){
            array_sum[i] = array_sum[i-1] + Integer.parseInt(st.nextToken());
        }

        for (int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            System.out.println(array_sum[b] - array_sum[a-1]);
        }
    }
}
