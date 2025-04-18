import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.OptionalInt;
import java.util.StringTokenizer;

public class boj2559 {

    static int n;
    static int k;
    static int[] array;
    static int[] sum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        array = new int[n+1];
        sum = new int[n+1];

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++){
            array[i] = Integer.parseInt(st.nextToken());
            sum[i] = sum[i-1] + array[i];
        }

        int max = Integer.MIN_VALUE;
        for(int i = k; i<=n; i++){
            max = Math.max(max, sum[i] - sum[i - k]);
        }

        System.out.println(max);
        br.close();
    }
}
