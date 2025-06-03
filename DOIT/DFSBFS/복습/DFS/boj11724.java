package DFSBFS.복습.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj11724 {

    static int n;
    static int m;
    static int count = 0;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n+1];
        visited = new boolean[n+1];

        for(int i=1; i<=n; i++){
            graph[i] = new ArrayList<>();
        }

        for (int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        for(int i=1; i<=n; i++){
            if (!visited[i]){
                count ++;
                dfs(i);
            }
        }
        System.out.println(count);
        br.close();
    }

    private static void dfs(int v) {
        visited[v] = true;

        for (int now : graph[v]) {
            if (!visited[now]){
                visited[now] = true;
                dfs(now);
            }
        }
    }
}
