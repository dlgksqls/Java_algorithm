import java.io.*;
import java.util.*;
public class boj20115 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        double answer = 0;

        // 소수 처리하기 위해 double 배열
        Double input[] = new Double[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++){
            input[i] = Double.parseDouble(st.nextToken());
        }

        // 내림차순으로 정렬
        Arrays.sort(input, Collections.reverseOrder());

        // 가장 큰 수만 그대로 더해주고, 나머지는 2를 나눠서 더해주기
        for (int i=0; i<n; i++){
            if (i == 0){
                answer += input[i];
            }
            else{
                answer += input[i] / 2;
            }
        }

        bw.write(String.valueOf(answer));
        br.close();
        bw.close();
    }
}
