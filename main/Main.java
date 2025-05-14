import java.util.*;

public class Main {

    public static void main(String[] args) {
        System.out.println(fib(3));
        System.out.println(fac(3));

        int[] array = {5, 6, 4, 8};

        char a = 'b';
        String[] b = "3people unFollowed  me".split(" ");
        for (String s : b) {
            if (s.equals("")) continue;
            System.out.println(s);
        }

    }

    private static int fib(int number) {
        if (number <= 2) {
            return 1;
        } else return fib(number - 1) + fib(number - 2);
    }

    private static int fac(int number) {
        if (number == 1) {
            return 1;
        } else return number * fac(number - 1);
    }

    private static int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr1[0].length];

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2[0].length; j++) {
                int sum = 0;
                for (int k = 0; k < arr1[0].length; k++) {
                    sum += arr1[i][k] * arr2[k][j];
                }
                answer[i][j] = sum;
            }
        }
        return answer;
    }
}