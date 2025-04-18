package D3;

import java.util.*;

public class swea_1206 {

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int tc = 1; tc <= T; tc++) {
            int n = sc.nextInt();
            int answer = 0;
            int[] array = new int[n];

            for(int i=0; i<n; i++){
                array[i] = sc.nextInt();
            }

            for(int i=2; i<n-2; i++){
                int check = array[i];
                int r_max = 0;
                int l_max = 0;
                int count = 0;
                int final_max;

                for(int j=i-1; j>=i-2; j--){
                    if (check < array[j]) break;
                    r_max = Math.max(array[j], r_max);
                    count ++;
                }
                for(int j=i+1; j<=i+2; j++){
                    if (check < array[j]) break;
                    l_max = Math.max(array[j], l_max);
                    count ++;
                }

                if (count == 4) {
                    final_max = Math.max(r_max, l_max);
                    answer += check - final_max;
                }
            }
            System.out.println("#" + tc + " " + answer);
        }
    }
}
