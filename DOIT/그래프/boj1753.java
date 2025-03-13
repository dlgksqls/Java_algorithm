package 그래프;

import java.util.*;
import java.io.*;

public class boj1753 {
    static int v;
    static int e;
    static int k;
    static int[] distance;
    static boolean[] visited;
    static ArrayList<Edge>[] graph;
    static PriorityQueue<Edge> queue;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(br.readLine());

        distance = new int[v + 1];
        graph = new ArrayList[v + 1];
        visited = new boolean[v + 1];
        queue = new PriorityQueue<>();

        for (int i=1; i<=v; i++){
            distance[i] = Integer.MAX_VALUE;
        }

        for (int i=1; i<=v; i++){
            graph[i] = new ArrayList<>();
        }

        for (int i=0; i<e; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[u].add(new Edge(v, w));
        }

        distance[k] = 0;
        queue.add(new Edge(k, 0));

        while(!queue.isEmpty()){
            Edge current = queue.poll();
            int c_node = current.node;

            if (visited[c_node]) continue;
            else visited[c_node] = true;

            for (int i=0; i<graph[c_node].size(); i++){
                Edge now = graph[c_node].get(i);
                int next = now.node;
                int value = now.value;
                if (distance[next] > distance[c_node] + value){
                    distance[next] = value + distance[c_node];
                    queue.add(new Edge(next, distance[next]));
                }
            }
        }

        for(int i=1; i<=v; i++){
            if (visited[i]){
                System.out.println(distance[i]);
            }
            else System.out.println("INF");
        }

        br.close();
    }

    private static class Edge implements Comparable<Edge>{
        int node;
        int value;

        public Edge(int node, int value) {
            this.node = node;
            this.value = value;
        }

        @Override
        public int compareTo(Edge edge) {
            if (this.value > edge.value) return 1; // 값이 더 큰 경우 뒤에 정렬
            else return -1;
        }
    }
}
