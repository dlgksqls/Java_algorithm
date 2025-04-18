package D2;

import java.util.*;
public class swea_1970 {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int tc = 1; tc <= T; tc++) {
            int money = sc.nextInt();
            System.out.println("#" + tc);

            System.out.print(money / 50000 + " ");
            money %= 50000;
            System.out.print(money / 10000 + " ");
            money %= 10000;
            System.out.print(money / 5000 + " ");
            money %= 5000;
            System.out.print(money / 1000 + " ");
            money %= 1000;
            System.out.print(money / 500 + " ");
            money %= 500;
            System.out.print(money / 100 + " ");
            money %= 100;
            System.out.print(money / 50 + " ");
            money %= 50;
            System.out.print(money / 10 + " ");
            System.out.println();
        }
    }
}
