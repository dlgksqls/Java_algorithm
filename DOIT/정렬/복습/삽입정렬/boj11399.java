package 정렬.복습.삽입정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj11399 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n];
        int [] sum = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(array);

        sum[0] = array[0];
        for (int i=1; i<array.length; i++){
            sum[i] = sum[i-1] + array[i];
        }

        int answer = 0;
        for (int i : sum) {
            answer += i;
        }
        System.out.println(answer);
    }
}
