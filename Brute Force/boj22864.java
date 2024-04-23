import java.io.*;
import java.util.*;
public class boj22864 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int tired = 0;
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int answer = 0;

        for (int i=0; i<24; i++){ // 24시간을 1시간별로 조사하기
            if (i == 0 && tired > m) // 처음부터 피곤수치가 m을 넘어가면 번아웃 ==> 업무 불가
                break;
            if (tired + a > m){  // 그렇지 않다면 누적 피곤수치와 피로도를 더해서 번아웃이 온다면 쉬어주기
                tired -= c;
                if (tired < 0) // 누적 피곤수치가 0보다 작아지면 0으로 설정
                    tired = 0;
            }
            else { // 일을 할 수 있다면 일 하기
                answer += b;
                tired += a;
            }
        }
        System.out.println(answer);
        br.close();
    }
}
