import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj12851 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] visited = new int[100001];

        int min = Integer.MAX_VALUE;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{n, 0});
        visited[n] = 0;

        while(!queue.isEmpty()){
            int[] now = queue.poll();
            int dir = now[0];
            int time = now[1];

            if (dir == k){
                if (time < min){
                    min = time;
                    visited[k] = 1;
                }
                else if (time == min){
                    visited[k]++;
                }
                continue;
            }

            int[] nextMoves = {dir - 1, dir + 1, dir * 2};
            for (int nextMove : nextMoves) {
                if (nextMove >= 0 && nextMove <= 100000){
                    // 방문하지 않았거나, 같은 시간대로 갈 수 있다면
                    if (visited[nextMove] == 0 || visited[nextMove] == time + 1) {
                        visited[nextMove] = time + 1;
                        queue.add(new int[]{nextMove, time + 1});
                    }
                }
            }
        }

        System.out.println(min);
        System.out.println(visited[k]);
        br.close();
    }
}
