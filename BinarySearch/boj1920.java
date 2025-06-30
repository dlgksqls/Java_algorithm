import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(array);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++){
            int findNum = Integer.parseInt(st.nextToken());
            boolean flag = false;

            int start = 0;
            int end = n-1;

            while(start <= end){
                int mid = (start + end) / 2;

                if (findNum == array[mid]){
                    flag = true;
                    break;
                }
                if (findNum < array[mid]){
                    end = mid - 1;
                }
                else if (findNum > array[mid]){
                    start = mid + 1;
                }
            }

            if (flag) System.out.println(1);
            else System.out.println(0);
        }

        br.close();
    }
}
