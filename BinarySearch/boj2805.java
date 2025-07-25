import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] array = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }

//        Arrays.sort(array);

        int start = 0;
        int end = Arrays.stream(array).max().getAsInt();

        while(start <= end){
            int mid = (start + end) / 2;

            long wood = 0;

            for (int i : array) {
                if (i >= mid){
                    wood += i - mid;
                }
            }

            if (wood >= m) start = mid + 1;
            else end = mid - 1;
        }

        System.out.println(end);
    }
}
