package DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj18352 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] graph = new ArrayList[n+1];
        ArrayList<Integer> answer = new ArrayList<>();
        boolean[] visited = new boolean[n+1];
        int[] dist = new int[n+1];

        for(int i=0; i<=n; i++){
            graph[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        visited[x] = true;
        dist[x] = 0;

        while(!queue.isEmpty()){
            Integer now = queue.poll();

            for (Integer i : graph[now]) {
                if (!visited[i]){
                    queue.add(i);
                    visited[i] = true;
                    dist[i] = Math.min(dist[i], dist[now] + 1);
                }
            }
        }

        for(int i=0; i<dist.length; i++){
            if (dist[i] == k) answer.add(i);
        }

        if (answer.isEmpty()) System.out.println(-1);
        else{
            for (Integer i : answer) {
                System.out.println(i);
            }
        }
        br.close();
     }
}
