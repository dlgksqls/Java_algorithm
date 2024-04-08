import java.util.*;
import java.io.*;
public class boj11725 {
    static int max = 100000+10; // 10만개 정도 들어오면 ArrayList 사용
    static int n;
    static ArrayList<Integer>[] graph;
    static boolean visited[];
    static int answer[];

    public static void dfs(int index){
        visited[index] = true;

        for (int i=0; i<graph[index].size(); i++){
            int next = graph[index].get(i);
            if (visited[next] == false) {
                answer[next] = index;
                dfs(next);
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        graph = new ArrayList[max];

        for (int i=1; i<=n; i++){
            graph[i] = new ArrayList<>();
        }
        visited = new boolean[max];
        answer = new int[max];

        for (int i=0; i<n-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x].add(y);
            graph[y].add(x);
        }

        dfs(1);

        for (int i=2; i<=n; i++)
            System.out.println(answer[i]);
    }
}
