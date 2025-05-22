package D3;

import java.util.*;

public class swea_13038 {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int n = sc.nextInt();
            int[] day = new int[7];

            for(int i=0; i<7; i++){
                day[i] = sc.nextInt();
            }

            int answer = Integer.MAX_VALUE;

            for(int i=0; i<7; i++){
                int count = 0;
                int result = 0;
                int idx = i;
                while(count != n){
                    if (day[idx % 7] == 1){
                        count ++;
                    }
                    result ++;
                    idx ++;
                }
                answer = Math.min(answer, result);
            }
            System.out.println("#" + tc + " " + answer);
        }
    }
}
