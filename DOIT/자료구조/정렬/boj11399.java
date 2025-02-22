package 자료구조.정렬;

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

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }

        for (int i=1; i<n; i++){
            int select = array[i];
            int j = i-1;

            while (j >= 0 && select < array[j]){
                array[j+1] = array[j];
                j --;
            }

            array[j+1] = select;
        }

        int sum = 0;
        int answer = 0;
        for (int i : array) {
            sum += i;
            answer += sum;
        }

        System.out.println(answer);

        br.close();
    }
}
