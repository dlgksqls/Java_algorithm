package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 효율적인_화폐_구성 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] array = new int[n];
        for(int i=0; i<n; i++){
            array[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[m+1];
        for(int i=0; i<=m; i++){
            dp[i] = Integer.MAX_VALUE;
        }

        dp[0] = 0;
        for(int i : array){
            for(int j=i; j<=m; j++){
                if (dp[j - i] != Integer.MAX_VALUE){
                    dp[j] = Math.min(dp[j], dp[j - i] + 1);
                }
            }
        }

        if (dp[m] == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(dp[m]);
    }
}
