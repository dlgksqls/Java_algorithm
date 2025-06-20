import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj1697_dfs {
    static boolean[] visited = new boolean[100001];
    static int n;
    static int k;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        visited = new boolean[100001];

        recursion(n, 0);
        System.out.println(answer);
        br.close();
    }

    private static void recursion(int now, int time) {
        if (now < 0 || now > 100000 || visited[now] || time >= answer) {
            return;
        }

        if (now == k){
            answer = time;
            return;
        }

        visited[now] = true;

        recursion(now - 1, time + 1);
        recursion(now + 1, time + 1);
        recursion(now * 2, time + 1);

        visited[now] = false;
    }
}
