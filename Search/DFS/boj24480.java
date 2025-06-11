package DFS;

import java.io.IOException;
import java.io.*;
import java.util.*;

public class boj24480 {
    final static int max = 100000 + 10;
    static int n, m, r;
    static ArrayList<Integer>[] graph;
    static boolean visited[];
    static int answer[];
    static int order;

    public static void dfs(int start){
        visited[start] = true;
        answer[start] = order;
        order++;

        for (int i=0; i<graph[start].size(); i++){
            int next = graph[start].get(i);
            if (visited[next] == false)
                dfs(next);
        }

    }

    public static void main(String[] args) throws IOException {

        // 1. 초기화

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        // 2. 그래프 채우기
        graph = new ArrayList[max];
        for (int i=1; i<=n; i++) // 반복문을 돌면서 ArrayList 객체 선언하기
            graph[i] = new ArrayList<>();
        visited = new boolean[max];
        answer = new int[max];
        order = 1;

        for (int i=0; i<m;i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x].add(y);
            graph[y].add(x);
        }

        // 3. 내림차순 정렬
        for (int i=1; i<=n; i++){
            Collections.sort(graph[i], Collections.reverseOrder()); // 내림차순 정렬
        }

        // 4. dfs (재귀 함수)
        dfs(r);

        // 5. 출력
        for (int i=1; i<=n; i++) {
            bw.write(String.valueOf(answer[i]));
            bw.newLine();
        }

        br.close();
        bw.close();
    }
}
