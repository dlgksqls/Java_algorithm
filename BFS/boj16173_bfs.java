import java.io.*;
import java.util.*;
public class boj16173_bfs {
    static int graph[][];
    static int n;
    static Queue<int[]>queue;
    static String answer = "Hing";

    public static void bfs(int x, int y){
        queue = new LinkedList<>();
        queue.offer(new int[] {x, y});

        while (!queue.isEmpty()){
            int poll[] = queue.poll();
            int cur = graph[poll[0]][poll[1]];
            if (graph[poll[0]][poll[1]] == -1){
                answer = "HaruHaru";
            }
            graph[poll[0]][poll[1]] = -2;

            int dx[] = {0, cur};
            int dy[] = {cur, 0};

            for (int i=0; i<2; i++){
                int nx = poll[0] + dx[i];
                int ny = poll[1] + dy[i];

                if (nx>=0 && nx<n && ny>=0 && ny<n){
                    queue.offer(new int[] {nx, ny});
                }
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        graph = new int[n][n];

        for (int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        bfs(0, 0);
        System.out.println(answer);

        br.close();
    }
}
