package D2;

import java.util.*;

public class swea_1284 {

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int tc = 1; tc <= T; tc++) {
            int p = sc.nextInt();
            int q = sc.nextInt();
            int r = sc.nextInt();
            int s = sc.nextInt();
            int w = sc.nextInt();

            int a = p * w;
            int b;

            if (w > r) b = q + (w-r) * s;
            else b = q;

            int answer = Math.min(a, b);
            System.out.println("#" + tc + " " + answer);
        }
    }
}
