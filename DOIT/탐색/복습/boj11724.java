package 탐색.복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj11724 {

    static int n;
    static int m;
    static int answer = 0;

    static ArrayList<Integer>[] graph;
    static int[] vistied;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n+1];
        vistied = new int[n+1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        for (int i = 1; i <= n; i++) {
            if (vistied[i] == 0) {
//                dfs(i);
                bfs(i);
                answer ++;
            }
        }

        System.out.println(answer);
        br.close();
    }

    private static void bfs(int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        vistied[v] = 1;

        while(!queue.isEmpty()) {
            int now = queue.poll();

            for (int t : graph[now]) {
                if (vistied[t] == 0) {
                    vistied[t] = 1;
                    queue.add(t);
                }
            }
        }
    }

    private static void dfs(int v) {
        vistied[v] = 1;

        for (int i : graph[v]) {
            if (vistied[i] == 0) {
                dfs(i);
            }
        }
    }
}
