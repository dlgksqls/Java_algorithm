package D2;

import java.util.*;

public class swea_1204 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int n = sc.nextInt();
            int[] array = new int[101];

            for(int i=0; i<1000; i++){
                array[sc.nextInt()] ++;
            }

            int max = 0;
            int max_score = 0;
            for(int i=0; i<100; i++){
                if (max <= array[i]) {
                    max = array[i];
                    max_score = i;
                }
            }
            System.out.printf("#"+max_score);
        }
        sc.close();
    }
}
