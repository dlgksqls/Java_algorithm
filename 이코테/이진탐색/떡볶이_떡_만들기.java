package 이진탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 떡볶이_떡_만들기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] array = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(array);
        int max = Integer.MIN_VALUE;

        int start = 0;
        int end = array[array.length - 1];

        while(start <= end){
            int sum = 0;
            int mid = (start + end) / 2;

            for(int i=0; i<array.length; i++){
                int remain = array[i] - mid;
                if (remain <= 0){
                    sum += 0;
                }
                else sum += remain;
            }

            if (sum < m){
                end = mid - 1;
            }
            else if(sum >= m){
                start = mid + 1;
                max = Math.max(max, mid);
            }
        }

        System.out.println(max);
        br.close();
    }
}
