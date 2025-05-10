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
}