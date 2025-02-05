package 자료구조.슬라이딩윈도우;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj12891 {

    /**
     * 첫 번째 줄에 민호가 임의로 만든 DNA 문자열 길이 |S|와 비밀번호로 사용할 부분문자열의 길이 |P| 가 주어진다. (1 ≤ |P| ≤ |S| ≤ 1,000,000)
     * 두번 째 줄에는 민호가 임의로 만든 DNA 문자열이 주어진다.
     * 세번 째 줄에는 부분문자열에 포함되어야 할 {‘A’, ‘C’, ‘G’, ‘T’} 의 최소 개수가 공백을 구분으로 주어진다.
     * 각각의 수는 |S| 보다 작거나 같은 음이 아닌 정수이며 총 합은 |S| 보다 작거나 같음이 보장된다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int s = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        String dna = br.readLine();

        st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int g = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        int a_count = 0;
        int c_count = 0;
        int g_count = 0;
        int t_count = 0;

        int start_index = 0;
        int end_index = p-1;
        int answer = 0;

        while (end_index < dna.length()){
            String substring = dna.substring(start_index, end_index+1);
            for (int i=0; i<substring.length(); i++) {
                if (substring.charAt(i) == 'A'){
                    a_count ++;
                }
                else if(substring.charAt(i) == 'C'){
                    c_count ++;
                }
                else if(substring.charAt(i) == 'G'){
                    g_count ++;
                }
                else if(substring.charAt(i) == 'T'){
                    t_count ++;
                }
            }
            start_index ++;
            end_index ++;

            if (a_count == a && c_count == c && g_count == g && t_count == t){
                answer += 1;
            }

            a_count = 0;
            c_count = 0;
            g_count = 0;
            t_count = 0;
        }
        System.out.println(answer);
    }
}
