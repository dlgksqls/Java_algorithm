package 정렬.복습.병합정렬;

import java.io.*;

public class boj2751 {

    static int n;
    static int[] array;
    static int[] temp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        array = new int[n];
        temp = new int[n];

        for(int i=0; i<n; i++){
            array[i] = Integer.parseInt(br.readLine());
        }

        merge_sort(0, n-1);

        for (int i=0; i<n; i++){
            bw.write(array[i] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static void merge_sort(int start, int end) {
        if (start >= end){
            return;
        }

        int mid = start + (end - start)/2;

        merge_sort(start, mid);
        merge_sort(mid+1, end);

        for(int i=start; i<=end; i++){
            temp[i] = array[i];
        }

        int k = start;
        int index1 = start;
        int index2 = mid + 1;

        while (index1 <= mid && index2 <= end){
            if (temp[index1] > temp[index2]){
                array[k] = temp[index2];
                k++;
                index2 ++;
            }
            else{
                array[k] = temp[index1];
                k++;
                index1 ++;
            }
        }

        while(index1 <= mid){
            array[k] = temp[index1];
            k ++;
            index1 ++;
        }
        while (index2 <= end){
            array[k] = temp[index2];
            k ++;
            index2 ++;
        }
    }
}
