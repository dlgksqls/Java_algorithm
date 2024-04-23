import java.io.*;
import java.util.*;
public class boj1969 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int index = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String input[] = new String[n];
        String answer = "";
        int sum = 0;

        for (int i=0; i<n; i++) {
            input[i] = br.readLine();
        }

        while(index < m){ // 배열 안에 있는 문자 모두 조사
            int a_count = 0;
            int t_count = 0;
            int g_count = 0;
            int c_count = 0;

            for (int i=0; i<n; i++){ // 배열 중 각 자리의 문자열에 해당하는 문자 수 count
                if (input[i].charAt(index) == 'A')
                    a_count++;
                else if (input[i].charAt(index) == 'T')
                    t_count++;
                else if (input[i].charAt(index) == 'G')
                    g_count++;
                else if (input[i].charAt(index) == 'C')
                    c_count++;
            }
            index++; // 다음 자리 글자 조사

            // 가장 많이 일치하는 문자 answer에 더해주기 (사전식으로 정렬하여 ACGT로 정렬)
            if (a_count == Math.max(Math.max(a_count, t_count), Math.max(g_count, c_count)))
                answer += 'A';
            else if (c_count == Math.max(Math.max(a_count, t_count), Math.max(g_count, c_count)))
                answer += 'C';
            else if (g_count == Math.max(Math.max(a_count, t_count), Math.max(g_count, c_count)))
                answer += 'G';
            else if (t_count == Math.max(Math.max(a_count, t_count), Math.max(g_count, c_count)))
                answer += 'T';
        }

        for (int i=0; i<n; i++){ // 배열의 모든 문자열 순회하며 다른 문자열이 있다면 count
            for (int j=0; j<m; j++){
                if (input[i].charAt(j) != answer.charAt(j)){
                    sum ++;
                }
            }
        }
        System.out.println(answer);
        System.out.println(sum);
        br.close();
    }
}
