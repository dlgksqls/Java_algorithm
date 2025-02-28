package 탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj11724 {

    static ArrayList<Integer>[] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n+1];
        visited = new boolean[n+1];

        for(int i=0; i<n+1; i++){
            graph[i] = new ArrayList<Integer>();
        }

        for (int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        int count = 0;
        for (int i=1; i<n+1; i++){
            if (!visited[i]){
                count ++;
                dfs(i);
            }
        }
        System.out.println(count);
        br.close();
    }

    private static void dfs(int v) {
        if (visited[v]){
            return;
        }
        visited[v] = true;
        for (Integer i : graph[v]) {
            if (!visited[i]){
                dfs(i);
            }
        }
    }
}
