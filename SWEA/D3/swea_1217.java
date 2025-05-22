package D3;

import java.util.*;

public class swea_1217 {

    static int answer;
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);

        for(int tc = 1; tc <= 1; tc++) {
//            int n = sc.nextInt();
//            answer = 1;
//            recursion_1(0, sc.nextInt(), sc.nextInt());
//            System.out.println("#" + n + " " + answer);
            System.out.println("fib4: " + fib(6));
        }
    }

    private static void recursion_1(int idx, int x, int y) {
        if (idx == y) {
            return;
        }

        answer *= x;
        recursion_1(idx + 1, x, y);
    }

    private static int recursion_2(int x, int y){
        if (y == 0) return 1;
        if (y == 1) return x;
        return x * recursion_2(x, y-1);
    }

    /**
     * 1 1 2 3 5 8 ...
     */
    private static int fib(int x){
        if (x <= 2) return 1;
        return fib(x - 1) + fib(x - 2);
    }
}
