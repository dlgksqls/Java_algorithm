import java.util.*;
import java.io.*;
public class boj5568 {
    static int n, k;
    static HashSet<String> hashSet = new HashSet<>(); // 중복 처리를 위한 HashSet
    static boolean visited[]; // 방문한 노드 처리를 위한 visited
    static String input[];

    public static void dfs(int depth, String num){
        if (depth == k) { // 뽑은 카드 수가 k와 같다면 hashSet에 넣기
            hashSet.add(num);
        }
        else{
            for (int i=0; i<n; i++){
                if (!visited[i]) { // 만약 방문하지 않은 노드라면
                    visited[i] = true; // 방문 처리 해주기
                    dfs(depth + 1, num + input[i]);
                    visited[i] = false; // 다음 순번 처리를 위해서 방무 처리 해제
                }
            }
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        input = new String[n];
        visited = new boolean[n];

        for (int i=0; i<n; i++){
            input[i] = br.readLine();
        }


        dfs(0, ""); // 숫자를 이어야하기 때문에 numeh 도 같이 보내기
        System.out.println(hashSet.size());

        br.close();

    }
}
