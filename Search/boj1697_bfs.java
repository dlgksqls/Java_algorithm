import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj1697_bfs {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[100001];
        Queue<int[]> queue = new LinkedList<>();

        // 현재 위치, 시간 저장
        visited[n] = true;
        queue.add(new int[]{n, 0});

        while(!queue.isEmpty()){
            int[] now = queue.poll();

            if (now[0] == k){
                System.out.println(now[1]);
                return;
            }

            int[] nextMoves = {now[0] - 1, now[0] + 1, now[0] * 2};
            for (int nextMove : nextMoves) {
                if (nextMove >= 0 && nextMove <= 100000 && !visited[nextMove]){
                    visited[nextMove] = true;
                    queue.add(new int[]{nextMove, now[1] + 1});
                }
            }
        }
    }
}
