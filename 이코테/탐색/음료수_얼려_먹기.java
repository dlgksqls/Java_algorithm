package 탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 음료수_얼려_먹기 {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] array;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        array = new int[n][m];
        for(int i=0; i<n; i++){
            char[] tmp = br.readLine().toCharArray();
            for(int j=0; j<m; j++){
                array[i][j] = tmp[j] - '0';
            }
        }

        int answer = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if (array[i][j] == 0){
                    bfs(i, j, n, m);
                    answer ++;
                }
            }
        }
        System.out.println(answer);
        br.close();
    }

    private static void bfs(int x, int y, int n, int m) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        array[x][y] = 1;

        while(!queue.isEmpty()){
            int[] poll = queue.poll();

            for(int i=0; i<4; i++){
                int nx = poll[0] + dx[i];
                int ny = poll[1] + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && array[nx][ny] == 0){
                    queue.add(new int[]{nx, ny});
                    array[nx][ny] = 1;
                }
            }
        }
    }
}
