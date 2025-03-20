package 정렬.복습.선택정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj1427 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] array_char = br.readLine().toCharArray();
        int[] array = new int[array_char.length];

        for(int i=0; i<array.length; i++){
            array[i] = array_char[i] - '0';
        }

        for(int i=0; i<array.length; i++){
            int max = i;
            for (int j=i+1; j<array.length; j++){
                if (array[max] < array[j]) max = j;
            }
            if (array[i] < array[max]){
                int temp = array[i];
                array[i] = array[max];
                array[max] = temp;
            }
        }

        for (int i : array) {
            System.out.print(i);
        }
    }
}
