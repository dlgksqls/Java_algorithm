package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 게임개발 {

    static int n, m;
    static int a, b, d;
    static int answer = 0;
    static int[][] graph;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[n][m];

        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<m; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int nx;
        int ny;
        int now_x = a;
        int now_y = b;
        graph[a][b] = 1;
        answer ++;
        int stack = 0;
        while(true){
            if (stack == 4){
                System.out.println(answer);
                break;
            }
            if (d == 0) {// 북쪽
                d = 3;
                nx = now_x + dx[2];
                ny = now_y + dy[2];
                if (graph[nx][ny] == 1 || nx < 0 && nx > n && ny < 0 && ny > m) {
                    stack ++;
                    continue;
                }
                now_x = nx;
                now_y = ny;
                graph[nx][ny] = 1;
                answer ++;
                stack = 0;
            }
            else if (d == 1) { // 동쪽
                d = 0;
                nx = now_x + dx[3];
                ny = now_y + dy[3];
                if (graph[nx][ny] == 1 || nx < 0 && nx > n && ny < 0 && ny > m) {
                    stack ++;
                    continue;
                }
                now_x = nx;
                now_y = ny;
                graph[nx][ny] = 1;
                answer ++;
                stack = 0;
            }
            else if (d == 2) { // 남쪽
                d = 1;
                nx = now_x + dx[0];
                ny = now_y + dy[0];
                if (graph[nx][ny] == 1 || nx < 0 && nx > n && ny < 0 && ny > m) {
                    stack ++;
                    continue;
                }
                now_x = nx;
                now_y = ny;
                graph[nx][ny] = 1;
                answer ++;
                stack = 0;
            }
            else if (d == 3) { // 서쪽
                d = 2;
                nx = now_x + dx[1];
                ny = now_y + dy[1];
                if (graph[nx][ny] == 1 || nx < 0 && nx > n && ny < 0 && ny > m) {
                    stack ++;
                    continue;
                }
                now_x = nx;
                now_y = ny;
                graph[nx][ny] = 1;
                answer ++;
                stack = 0;
            }
        }
    }
}
