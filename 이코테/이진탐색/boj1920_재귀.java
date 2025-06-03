package 이진탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj1920_재귀 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(array);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int findNum = Integer.parseInt(st.nextToken());
            boolean result = binarySearch(0, array.length - 1, findNum, array);
            System.out.println(result ? 1 : 0);
        }
    }

    private static boolean binarySearch(int start, int end, int findNum, int[] array) {
        if (start > end) return false;

        int mid = (start + end) / 2;

        if (findNum == array[mid]) {
            return true;
        }
        else if (findNum < array[mid]) {
            return binarySearch(start, mid - 1, findNum, array);
        }
        else {
            return binarySearch(mid + 1, end, findNum, array);
        }
    }
}
