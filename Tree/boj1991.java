import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1991 {

    static int n;
    static int[][] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        graph = new int[26][2];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int a = st.nextToken().charAt(0) - 'A'; // 'A'를 빼주면 0부터 시작
            int b = st.nextToken().charAt(0) - 'A';
            int c = st.nextToken().charAt(0) - 'A';

            graph[a][0] = b;
            graph[a][1] = c;
        }

        preOrder(0);
        System.out.println();
        inOrder(0);
        System.out.println();
        postOrder(0);
    }

    // 부모의 정보를 아래로 내릴때
    private static void preOrder(int node) {
        if (node == -19) return;

        System.out.print((char)(node + 'A'));
        preOrder(graph[node][0]);
        preOrder(graph[node][1]);
    }

    private static void inOrder(int node) {
        if (node == -19) return;

        inOrder(graph[node][0]);
        System.out.print((char)(node + 'A'));
        inOrder(graph[node][1]);
    }

    // 자식의 정보를 위로 올릴때
    private static void postOrder(int node) {
        if (node == -19) return;

        postOrder(graph[node][0]);
        postOrder(graph[node][1]);
        System.out.print((char)(node + 'A'));
    }
}
