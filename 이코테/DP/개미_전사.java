package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 개미_전사 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[101];
        int[] array = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = array[0];
        dp[1] = Math.max(array[0], array[1]);

        for(int i=2; i<n; i++){
            dp[i] = Math.max(dp[i-1], dp[i-2] + array[i]);
        }

        System.out.println(dp[n-1]);
        br.close();
    }
}
