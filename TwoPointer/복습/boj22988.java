package 복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj22988 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long x = Long.parseLong(st.nextToken());

        long[] array = new long[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(array);

        int start = 0;
        int end = n - 1;
        int answer = 0;
        int remain = 0;
        long min;

        if (x % 2 == 0){
            min = x / 2;
        }
        else {
            min = x / 2 + 1;
        }

        while (start <= end) {
            if (array[end] >= x){
                answer ++;
                end --;
            }

            if (start < end && array[start] + array[end] >= min) {
                answer++;
                start++;
                end--;
            } else {
                remain++;
                start++;
            }
        }

        answer += remain / 3;

        System.out.println(answer);
    }
}
