package D2;

import java.util.*;

public class swea_1959 {
    public static void main(String args[]) throws Exception {

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int tc = 1; tc <= T; tc++){
            int n = sc.nextInt();
            int m = sc.nextInt();

            int[] n_array = new int[n];
            int[] m_array = new int[m];

            for(int i=0; i<n; i++){
                n_array[i] = sc.nextInt();
            }
            for(int i=0; i<m; i++){
                m_array[i] = sc.nextInt();
            }

            int answer = Integer.MIN_VALUE;
            int start = 0;
            int end;
            int sum;
            int count;

            if (n < m){
                end = n - 1;

                while (end != m) {
                    count = 0;
                    sum = 0;
                    for (int i = start; i <= end; i++) {
                        sum += n_array[count] * m_array[i];
                        count ++;
                    }
                    start ++;
                    end ++;
                    answer = Math.max(answer, sum);
                }
            }
            else if (n > m) {
                end = m - 1;

                while (end != n){
                    count = 0;
                    sum = 0;
                    for (int i = start; i <= end; i++) {
                        sum += n_array[i] * m_array[count];
                        count ++;
                    }
                    start ++;
                    end ++;
                    answer = Math.max(answer, sum);
                }
            }
            else if (n == m){
                sum = 0;
                for(int i=0; i<n; i++){
                    sum += n_array[i] * m_array[i];
                }
                answer = sum;
            }
            System.out.println("#" + tc + " " + answer);
        }
    }
}
