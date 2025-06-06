import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj11725_tree {

    static int n;
    static boolean[] visited;
    static int[] parents;
    static ArrayList<Integer>[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        visited = new boolean[n+1];
        parents = new int[n+1];
        graph = new ArrayList[n+1];

        for(int i=1; i<=n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<n-1; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x].add(y);
            graph[y].add(x);
        }
//        dfs(1);
        bfs(1);

        for(int i=2; i<=n; i++){
            System.out.println(parents[i]);
        }

        br.close();
    }

    private static void dfs(int node) {
        visited[node] = true;

        for (Integer v : graph[node]) {
            if (!visited[v]){
                parents[v] = node;
                visited[v] = true;
                dfs(v);
            }
        }
    }

    // 거리를 잴 때
    private static void bfs(int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node] = true;

        while(!queue.isEmpty()){
            int v = queue.poll();

            for (Integer i : graph[v]) {
                if (!visited[i]){
                    visited[i] = true;
                    parents[i] = v;
                    queue.add(i);
                }
            }
        }
    }
}
