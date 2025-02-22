package 자료구조.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj11004 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] array = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(array);
//        quick_sort(array, 0, n-1);

        System.out.println(array[k-1]);
    }

    private static void quick_sort(int[] array, int start, int end) {

        if (start >= end) {
            return;
        }

        int pivot = start;
        int left = start + 1;
        int right = end;

        while(left <= right){
            while (left <= end && array[left] <= array[pivot]){
                left ++;
            }
            while (right > start && array[right] >= array[pivot]){
                right --;
            }
            if (left > right){
                swap(array, right, pivot);
            }
            else {
               swap(array, left, right);
            }
        }

        quick_sort(array, start, right-1);
        quick_sort(array, right+1, end);
    }

    private static void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}
