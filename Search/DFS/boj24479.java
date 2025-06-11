package DFS;

import java.util.*;
import java.io.*;

public class boj24479 {
    final static int max = 1000000+10; // 문제의 최대크기 만큼 변수 정의
    static int N, M, R;
    static ArrayList<Integer>[] graph; // 연결리스트로 graph 정의
    static boolean visited[];
    static int answer[]; // 몇번째로 방문했는지 기록
    static int order; // 내가 현제 몇번째에 방문했는가?

    public static void dfs(int start){
        visited[start] = true; // 방문 노드 방문표시 해주기
        answer[start] = order; // 방문한 순서 answer에 기록해주기
        order++; // 방문 순서 업데이트

        for (int i=0; i<graph[start].size(); i++){ // graph 모든 노드 순회
            int next = graph[start].get(i);
            if (visited[next] == false)
                dfs(next);
        }
    }
    public static void main(String[] args) throws IOException{

        // 1. 입력 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        // 2. 그래프 정보 채우기
        graph = new ArrayList[max];
        for (int i=1; i<=N; i++) // 반복문을 돌면서 ArrayList 객체 선언하기
            graph[i] = new ArrayList<>();
        visited = new boolean[max];
        answer = new int[max];
        order = 1;

        for (int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x].add(y);
            graph[y].add(x);
        }

        // 3. 오름차순 정렬
        for (int i=1; i<=N; i++) // 반복문 돌면서 graph 모든 행 정렬하기
            Collections.sort(graph[i]);

        // 4. dfs(재귀 함수)
        dfs(R);
        // 5. 출력
        for (int i=1; i<=N; i++){ // 반복문 돌면서 answer 출력하기
            bw.write(String.valueOf(answer[i]));
            bw.newLine();
        }

        br.close();
        bw.close();
    }
}
