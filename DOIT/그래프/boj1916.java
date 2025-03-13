package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj1916 {
    static int n, m;
    static int[] distance;
    static ArrayList<Edge>[] graph;
    static PriorityQueue<Edge> queue = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        distance = new int[n + 1];
        graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
            distance[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[u].add(new Edge(v, cost));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dijkstra(start);
        System.out.println(distance[end]);
        br.close();
    }

    private static void dijkstra(int start) {
        distance[start] = 0;
        queue.add(new Edge(start, 0));

        while (!queue.isEmpty()) {
            Edge node = queue.poll();
            int now_node = node.node;

            // ✅ 이미 처리된 거리보다 크다면 무시 (방문 처리 역할)
            if (distance[now_node] < node.value) continue;

            for (Edge edge : graph[now_node]) {
                int next = edge.node;
                int value = edge.value;

                if (distance[next] > distance[now_node] + value) {
                    distance[next] = distance[now_node] + value;
                    queue.add(new Edge(next, distance[next]));
                }
            }
        }
    }

    private static class Edge implements Comparable<Edge> {
        int node, value;

        public Edge(int node, int value) {
            this.node = node;
            this.value = value;
        }

        @Override
        public int compareTo(Edge edge) {
            return Integer.compare(this.value, edge.value); // 작은 값이 먼저 오도록 정렬
        }
    }
}
