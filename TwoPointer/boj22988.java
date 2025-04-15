import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj22988 {

    static int n;
    static long x;
    static long[] array;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        x = Long.parseLong(st.nextToken());

        array = new long[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = n-1;
        int remain = 0;

        while(start <= end){ // s와 e가 교차되면 멈춘다

            if (array[end] == x){
                answer ++;
                end --;
                continue;
            }

            if (start == end){
                remain ++;
                break;
            }

            if (array[start] + array[end] >= x / 2){
                answer ++;
                start ++;
                end --;
            }
            else if (array[start] + array[end] < x / 2){
                remain ++;
                start ++;
            }
        }

        System.out.println(answer + remain/3);
        br.close();
    }
}
