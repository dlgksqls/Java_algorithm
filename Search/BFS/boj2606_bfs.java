package BFS;

import java.io.*;
import java.util.*;
public class boj2606_bfs {
    static boolean graph[][];
    static boolean visited[];
    static int n, m;
    static int count;
    static ArrayList<Integer> queue;

    public static void bfs(){
        queue = new ArrayList<>();

        queue.add(1);
        visited[1] = true;

        while (!queue.isEmpty()){
            int idx = queue.remove(0);

            for (int i=1; i<=n; i++){
                if (graph[idx][i] && !visited[i]){
                    count ++;
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        graph = new boolean[n+1][n+1];
        visited = new boolean[n+1];

        for (int i=0; i<m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x][y] = true;
            graph[y][x] = true;
        }

        bfs();
        bw.write(String.valueOf(count));

        br.close();
        bw.close();
    }
}
