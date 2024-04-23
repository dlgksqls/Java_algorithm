import java.io.*;
import java.util.*;
public class boj2231 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int i=1; i<n; i++){
            int sum = 0;
            int number = i; // 1부터 n이 될때까지 완전 탐색

            while (number != 0){ // number가 0이 되면 나누지 못하므로 다음으로
                sum += number % 10;  // ex) 첫 번째 반복 192 => 192 % 10 = 2, 192 / 10 = 19
                number = number / 10; // 두 번째 반복 19 % 10 = 9, 19 / 10 = 1 // 세 번째 반복 1 * 10 = 1
                // 2 + 9 + 1 처럼 각 자리 합 만들 수 있음
            }

            if (sum + i == n){ // 원래 수에 각 자리 합을 더해서 n이 되면 return
                System.out.println(i);
                return;
            }
        }
        System.out.println(0);
    }
}
