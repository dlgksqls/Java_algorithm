package 이진탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 고정점_찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }

        boolean flag = false;

        int start = 0;
        int end = array.length - 1;
        int mid = 0;

        while(start <= end){
            mid = (start + end) / 2;

            if (array[mid] == mid) {
                flag = true;
                break;
            }
            else if (array[mid] < mid){
                start = mid + 1;
            }
            else if (array[mid] > mid){
                end = mid - 1;
            }
        }

        if (flag) System.out.println(mid);
        else System.out.println(-1);
    }
}
