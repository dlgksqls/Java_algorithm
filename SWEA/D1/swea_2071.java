package D1;

import java.util.Scanner;

public class swea_2071 {

    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int sum = 0;
            for (int i = 0; i < 10; i++)
                sum += sc.nextInt();


            long avg = Math.round(sum / 10.0);
            System.out.println("#" + test_case + " " + avg);
        }
    }
}
