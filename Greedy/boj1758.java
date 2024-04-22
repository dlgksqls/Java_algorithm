import java.util.*;
import java.io.*;
public class boj1758 {
    static int n;
    static Integer answers[];

    public static void main(String[] args) throws Exception {

        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        // 팁들을 저장하기 위해 배열 선언
        answers = new Integer[n];

        // 모든 팁의 합을 저장하기 위해 int 가 아닌 long으로 선언
        long answer = 0;

        // tip을 하나씩 받아서 배열에 저장 후 큰 수부터 내림차순으로 정렬
        for (int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int tip = Integer.parseInt(st.nextToken());
            answers[i] = tip;
        }
        Arrays.sort(answers, Collections.reverseOrder());

        /*
        tip = 원래 tip - (등수 - 1)
        ex) 1등 => 원래 팁(10) - (1 - 1)
        여기서 (1-1)은 0이 되고, 1등은 배열의 0번째에 있으므로 i를 그대로 빼주면 됨
        원래 팁이 i보다 작으면 팁을 못받으므로 조건에서 제외
         */
        for (int i=0; i<n; i++){
            if (answers[i] > i) {
                answer += answers[i] - i;
            }
        }
        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}
