import java.util.*;
import java.io.*;

public class boj10610 {
    public static void main(String[] args) throws Exception{

        // 입력

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String n = br.readLine();
        Integer input[] = new Integer[n.length()];
        int sum = 0;

        // 배열에 숫자로 변환해서 다 넣기
        for (int i = 0; i < n.length(); i++) {
            input[i] = n.charAt(i) - '0';
            sum += input[i];
        }
        
        // 0을 맨 끝으로 보내기 위해 내림차순 정렬 (30의 배수는 끝이 0이여야하고, 각 자리를 더한 합이 3의 배수여야함)
        Arrays.sort(input, Collections.reverseOrder());

        // 조건을 만족한다면, 앞에서부터 출력
        if ((sum % 3 == 0)&&(input[input.length-1]==0)) {
            for (int num : input){
                bw.write(String.valueOf(num));
            }
        } else {
            System.out.println(-1);
        }
        br.close();
        bw.close();
    }
}