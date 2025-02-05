package 자료구조.배열;

import java.util.Scanner;

public class boj11720 {

    public static void main(String[] args) {
        int n;
        int answer = 0;
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        String input = sc.next();

        char[] arrays = input.toCharArray();

        for (char array : arrays) {
            answer += array - '0'; // 아스키 코드 상에서 같은 의미의 문자와 숫자의 코드 값 차이는 48
            // 그래서 48에 해당하는 '0'을 빼주는 것임
        }
        System.out.println(answer);
        sc.close();
    }
}
