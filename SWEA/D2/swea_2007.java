package D2;

import java.util.*;

public class swea_2007 {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int tc = 1; tc <= T; tc++) {
            int answer = 0;
            String input = sc.next();

            for(int i=1; i<input.length(); i++){
                String tmp1 = input.substring(0, i);
                String tmp2 = input.substring(i, i+i);

                if (tmp1.equals(tmp2)){
                    answer = tmp1.length();
                    break;
                }
            }

            System.out.println("#" + tc + " " + answer);
        }
    }
}
