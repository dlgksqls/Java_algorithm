import java.util.*;
import java.io.*;
public class boj2217 {
    static int n;
    static int answers[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        int max = 0;
        answers = new int[n];

        for (int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            answers[i] = w; // 로프가 버틸 수 있는 하중 배열에 저장
        }
        Arrays.sort(answers); // 버틸 수 있는 크기가 작은 순으로 오름차순 정렬

        for (int i=0; i<n; i++){
            /*
            answers = {10, 20, 30, 40 50} 이면
            5개 다 사용할 때 최대 하중 = 50
            10 제외 4개 사용할 때 최대 하중 = 80
            10 ,20 제외 3개 사용할 때 = 90
            .
            .
             */
            max = Math.max(max, answers[i] * (n - i));
        }
        bw.write(String.valueOf(max));

        bw.close();
        br.close();
    }
}
