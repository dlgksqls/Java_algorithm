import java.util.*;
import java.io.*;
public class boj18312 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int answer = 0;

        for (int i=0; i<=n; i++){ // 시, 분, 초를 모두 탐색해야하기에 3중 반복문
            String i_str = Integer.toString(i); // '시' 숫자를 문자화
            for (int j=0; j<60; j++){
                String j_str = Integer.toString(j); // '분' 숫자 문자화
                for (int l=0; l<60; l++){
                    String l_str = Integer.toString(l); // '초' 숫자 문자화
                    if (i < 10) { // 전자시계이므로 10보다 작으면 0을 앞에 붙여줘야함 예를 들어 "02시04분03초" 이런식으로
                        i_str = "0" + i_str;
                    }
                    if (j < 10){
                        j_str = "0" + j_str;
                    }
                    if (l < 10){
                        l_str = "0" + l_str;
                    }

                    String number = i_str + j_str + l_str; // 모두 더하기

                    if (number.contains(Integer.toString(k)))
                        answer ++;
                }
            }
        }
        System.out.println(answer);
    }
}
