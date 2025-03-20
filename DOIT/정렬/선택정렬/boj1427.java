package 정렬.선택정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class boj1427 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String n = br.readLine();

        char[] array_char = n.toCharArray();
        Integer[] array_int = new Integer[array_char.length];

        for(int i=0; i<array_char.length; i++) {
            array_int[i] = Integer.parseInt(String.valueOf(array_char[i]));
        }

//        Arrays.sort(array_int, Comparator.reverseOrder());
//
//        for(int i=0; i<array_int.length; i++){
//            System.out.print(array_int[i]);
//        }

        for (int i=0; i<array_int.length; i++){
            int max = i;
            for (int j=i+1; j<array_int.length; j++){
                if (array_int[max] < array_int[j]){
                    max = j;
                }
            }
            if (array_int[i] < array_int[max]){
                int temp = array_int[max];
                array_int[max] = array_int[i];
                array_int[i] = temp;
            }
            System.out.print(array_int[i]);
        }
    }
}
