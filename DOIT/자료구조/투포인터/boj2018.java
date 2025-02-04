package 자료구조.투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj2018 {

    /**
     * 어떠한 자연수 N은, 몇 개의 연속된 자연수의 합으로 나타낼 수 있다.
     * 당신은 어떤 자연수 N(1 ≤ N ≤ 10,000,000)에 대해서, 이 N을 몇 개의 연속된 자연수의 합으로 나타내는 가지수를 알고 싶어한다.
     * 이때, 사용하는 자연수는 N이하여야 한다.
     *
     * 입력
     * 첫 줄에 정수 N이 주어진다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // n의 크기가 상당히 크기 때문 (하지만 제한 시간은 2초라서 O(n) 으로 짜야햄
        int result = 1;
        int sum = 1;
        int start_index = 1;
        int end_index = 1;

        while (end_index != n){ // 2중 반복문 쓰면 시간초과 뜸
            if (sum == n){
                result ++;
                end_index ++;
                sum += end_index;
            }
            else if (sum < n){
                end_index ++;
                sum += end_index;
            }
            else if (sum > n){
                sum -= start_index;
                start_index ++;
            }
        }
        System.out.println(result);
    }
}
