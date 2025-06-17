import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
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
        for(int i=1; i<=n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        visited = new boolean[n+1];
        int answer = 0;

        for(int i=1; i<=n; i++){
            if (!visited[i]){
                answer ++;
//                bfs(i);
                dfs(i);
            }
        }

        System.out.println(answer);
        br.close();
    }

    private static void dfs(int v) {
        visited[v] = true;

        for (int i : graph[v]) {
            if (!visited[i]){
                visited[i] = true;
                dfs(i);
            }
        }
    }

    private static void bfs(int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        visited[v] = true;

        while(!queue.isEmpty()){
            int poll = queue.poll();
            for (int i : graph[poll]) {
                if (!visited[i]){
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}
