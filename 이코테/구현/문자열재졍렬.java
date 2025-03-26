package 구현;

import java.util.Arrays;
import java.util.Scanner;

public class 문자열재졍렬 {

    static char[] n;
    static int sum;
    static String answer;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.next();
        String alpha = "";
        for(int i=0; i<input.length(); i++){
            if (input.charAt(i) < 65) sum += input.charAt(i) - '0';
            else alpha += input.charAt(i);
        }
        n = alpha.toCharArray();
        Arrays.sort(n);

        System.out.print(n);
        System.out.println(sum);
    }
}
