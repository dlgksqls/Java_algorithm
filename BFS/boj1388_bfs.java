import java.util.*;
import java.io.*;
public class boj1388_bfs {
    static Character graph[][];
    static char cur;
    static int n, m, answer;
    static Queue<int[]> queue;

    public static void bfs(int x, int y) {
        queue = new LinkedList<>();

        queue.offer(new int[]{x, y});

        while (!queue.isEmpty()) {
            int poll[] = queue.poll();
            cur = graph[poll[0]][poll[1]];
            graph[poll[0]][poll[1]] = 'x';

            if (cur == '-') {
                int nx = poll[0];
                int ny = 1 + poll[1];

                if (ny < m) {
                    if (graph[nx][ny] == '-') {
                        queue.offer(new int[]{nx, ny});
                    } else
                        return;
                }
            } else if (cur == '|') {
                int nx = 1 + poll[0];
                int ny = poll[1];

                if (nx < n) {
                    if (graph[nx][ny] == '|') {
                        queue.offer(new int[]{nx, ny});
                    } else
                        return;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new Character[n][m];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                graph[i][j] = input.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] != 'x') {
                    answer++;
                    bfs(i, j);
                }
            }
        }
        System.out.println(answer);
        br.close();
    }
}

