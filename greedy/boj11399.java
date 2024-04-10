import java.io.*;
import java.util.*;
public class boj11399 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] times = new int[n];

        String[] inputs = br.readLine().split(" "); // 공백을 기준으로 문자열로 받기
        for (int i = 0; i < n; i++) {
            times[i] = Integer.parseInt(inputs[i]); // 받은 문자열을 int로 바꿔서 배열에 넣기
        }

        Arrays.sort(times);

        int sum = 0; // 이때까지의 합을 저장할 sum
        int total = 0; // 총 합을 저장할 total

        for (int time : times) {
            sum += time;
            total += sum;
        }

        bw.write(String.valueOf(total));

        br.close();
        bw.close();
    }
}
