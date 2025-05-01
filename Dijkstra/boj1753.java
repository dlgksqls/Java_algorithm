import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj1753 {
    static int v;
    static int e;
    static int start;
    static ArrayList<Edge>[] graph;
    static PriorityQueue<Edge> queue = new PriorityQueue<>();
    static int[] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(br.readLine());

        dist = new int[v+1];
        graph = new ArrayList[v+1];
        for(int i=1; i<=v; i++){
            graph[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }

        for(int i=0; i<e; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[u].add(new Edge(v, w));
        }

        dist[start] = 0;
        queue.add(new Edge(start, 0));

        while (!queue.isEmpty()){
            Edge node = queue.poll();

            for (Edge edge : graph[node.node]) {
                if (dist[edge.node] > dist[node.node] + edge.value){ // 이전까지의 최소거리 + 다음 노드까지의 거리
                    dist[edge.node] = dist[node.node] + edge.value;
                    queue.add(new Edge(edge.node, dist[edge.node]));
                }
            }
        }

        for(int i=1; i<=v; i++){
            if(dist[i] == Integer.MAX_VALUE)
                System.out.println("INF");
            else
                System.out.println(dist[i]);
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
            if (this.value > edge.value) return 1;
            else return -1;
        }
    }
}
