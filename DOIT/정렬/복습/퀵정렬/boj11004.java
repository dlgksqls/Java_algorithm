package 정렬.복습.퀵정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj11004 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] array = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        quickSort(array, 0, n - 1);
        System.out.println(array[k - 1]);
    }

    private static void quickSort(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }

        int pivot = start;
        int left = start + 1;
        int right = end;

        while (left <= right) {
            while (left <= end && array[left] < array[pivot]) {
                left++;
            }
            while (right > start && array[right] > array[pivot]) {
                right--;
            }
            if (left > right) {
                swap(array, right, pivot);
            } else {
                swap(array, left, right);
            }
        }

        quickSort(array, start, right - 1);
        quickSort(array, right + 1, end);
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
