package D1;

import java.util.*;
public class swea_2072 {

    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int answer = 0;
            for (int i=0; i<10; i++){
                int number = sc.nextInt();
                if (number % 2 != 0) answer += number;
            }
            System.out.println("#" + test_case + " "  + answer);
        }
    }
}
