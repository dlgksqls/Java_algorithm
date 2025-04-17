package D2;

import java.util.*;

public class swea_1989 {

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();


        for(int tc = 1; tc <= T; tc++) {
            String input = sc.next();
            int answer = 1;

            int len = input.length();

            if (len % 2 == 0){
                for(int i=0; i<=len/2; i++){
                    if (input.charAt(i) != input.charAt(len-1-i)){
                        answer = 0;
                        break;
                    }
                }
            }
            else {
                for(int i=0; i<=len/2; i++){
                    if (i == len/2) {
                        break;
                    }
                    if (input.charAt(i) != input.charAt(len-1-i)){
                        answer = 0;
                        break;
                    }
                }
            }
            System.out.println("#" + tc + " " + answer);
        }
    }
}
