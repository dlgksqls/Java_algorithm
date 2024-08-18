import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class boj5597 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] result = new int[31];
        List<Integer> answer = new ArrayList<>();

        // 제출 한 학생 정보 받아오기
        for (int i=1; i<29; i++){
            int n = Integer.parseInt(br.readLine());
            result[n] = 1;
        }

        // 그 중 제출하지 않은 학생정보 arraylist에 저장
        for (int i=1; i<31; i++){
            if (result[i] != 1){
                answer.add(i);
            }
        }

        // default 오름차순
        Collections.sort(answer);

        // 내림차순
        // Collections.sort(answer, Collections.reverseOrder());

        for (Integer i : answer) {
            System.out.println(i);
        }
    }
}
