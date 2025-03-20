package 정렬.버블정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj2750 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n];

        for(int i=0; i<n; i++){
            array[i] = Integer.parseInt(br.readLine());
        }

        for(int i=0; i<n-1; i++){
            for (int j=0; j<n-1; j++){
                if (array[j] > array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }

        for (int i=0; i<n; i++){
            System.out.println(array[i]);
        }
    }
}
