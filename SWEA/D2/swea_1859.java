package D2;

import java.util.Scanner;

public class swea_1859 {

    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {

            int n = sc.nextInt();
            int[] array = new int[n];

            for(int i=0; i<n; i++){
                array[i] = sc.nextInt();
            }

            long buy_price = 0;
            long count = 0;
            long result = 0;
            long max = Long.MIN_VALUE;

            for(int i=array.length-1; i>=0; i--){
                if (array[i] > max){
                    result += (max * count) - buy_price;
                    max = array[i];
                    buy_price = 0;
                    count = 0;
                }
                else{
                    buy_price += array[i];
                    count ++;
                }
            }
            result += (max * count) - buy_price;
            System.out.println("#" + test_case + " " + result);
        }
    }
}
