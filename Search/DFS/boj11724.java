package DFS;

import java.util.*;
import java.io.*;
public class boj11724 {
    static boolean graph[][];
    static boolean visited[];
    static int N, M;
    static int answer;

    public static void dfs(int idx){
        visited[idx] = true;

        for (int i=0; i<N; i++){
            if (visited[i] == false && graph[idx][i] == true)
                dfs(i);
        }
    }
    public static void main(String[] args) throws IOException{
        // 1. 입력 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new boolean[N][N];
        visited = new boolean[N];

        // 2. 연결 정보 채우기
        int x, y;
        for (int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            graph[x-1][y-1] = true;
            graph[y-1][x-1] = true;
        }

        // 3. dfs(재귀 함수) 호출
        for (int i=0; i<N; i++){
            if (visited[i] == false) {
                dfs(i);
                answer++;
            }
        }
        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}
