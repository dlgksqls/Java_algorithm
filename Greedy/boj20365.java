import java.util.*;
import java.io.*;

public class boj20365 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String input;
        input = br.readLine();

        int rCnt = 0;
        int bCnt = 0;
        char bf = 'F'; // 같은 색이 이어져있는지 확인 위해 임의 변수 설정

        for (int i = 0; i < n; i++) {
            char cur = input.charAt(i); // 배열 처음부터 조사 시작하여서 현재 값 저장
            if (cur != bf) { // 이어져있지 않다면
                if (cur == 'B') // +1
                    bCnt++;
                else
                    rCnt++;
            }
            bf = cur; // 이어져있는지 확인을 위해서 임의 변수에 이전 값 넣기
        }
        bw.write(String.valueOf(Math.min(bCnt, rCnt) + 1)); // 더 적게 색칠하는 것의 색칠 수 min() + 한번 뚝 색칠하는 수 (1)

        br.close();
        bw.close();
    }
}
