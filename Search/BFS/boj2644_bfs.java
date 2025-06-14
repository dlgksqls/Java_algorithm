package BFS;

import java.io.*;
import java.util.*;
public class boj2644_bfs {
    static int n, a, b, m;
    static boolean graph[][];
    static int visited[];
    static ArrayList<Integer> queue;

    public static void bfs(){
        queue = new ArrayList<>();
        queue.add(a);

        while (!queue.isEmpty()){
            int idx = queue.remove(0);
            for (int i=1; i<=n; i++){
                if (graph[idx][i] && visited[i] == 0){
                    queue.add(i);
                    visited[i] = visited[idx] + 1;
                }
            }
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        graph = new boolean[n+1][n+1];
        visited = new int[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        m = Integer.parseInt(br.readLine());

        for (int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x][y] = true;
            graph[y][x] = true;
        }

        bfs();

        if (visited[b] == 0)
            System.out.println(-1);
        else
            bw.write(String.valueOf(visited[b]));

        br.close();
        bw.close();
    }
}
