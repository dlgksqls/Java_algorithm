import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj2578 {
    static int count = 0;
    static int result = 0;
    static Integer[][] graph = new Integer[5][5];

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 그래프 채우기
        for (int i=0; i< graph.length; i++){
            // 한 줄 통으로 받아와서(띄워쓰기)
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<graph[i].length; j++){
                // 하나씩 삽입
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int k=0; k<5; k++){
            // 한 줄 통으로 읽어와서
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int m=0; m<5; m++) {
                // 하나씩 보기
                int num = Integer.parseInt(st.nextToken());
                result ++ ;

                for (int i = 0; i < graph.length; i++) {
                    for (int j = 0; j < graph[i].length; j++) {
                        if (graph[i][j] == num) {
                            graph[i][j] = 0;
                        }
                    }
                }

                count = 0;

                /**
                 * 빙고 체크
                 */
                // 열 (row)
                rCheck();
                // 행 (column)
                cCheck();
                // 우측방향 대각선
                rcCheck();
                // 좌측방향 대각선
                lcCheck();

                if (count >= 3){
                    System.out.println(result);
                    return;
                }
            }
        }
    }
    private static void cCheck() {
        for (int i=0; i< graph.length; i++){
            boolean win = true;
            for (int j=0; j< graph.length; j++){
                if (graph[j][i] != 0){
                    win = false;
                    break;
                }
            }
            if (win) count ++;
        }
    }
    private static void rCheck() {
        for (int i=0; i< graph.length; i++){
            boolean win = true;
            for (int j=0; j< graph.length; j++){
                if (graph[i][j] != 0){
                    win = false;
                    break;
                }
            }
            if (win) count ++;
        }
    }
    private static void lcCheck() {
        boolean win = true;
        for (int i=0; i<graph.length; i++){
            if(graph[i][i] != 0){
                win = false;
                break;
            }
        }
        if (win) count ++;
    }

    private static void rcCheck() {
        boolean win = true;
        for (int i=0; i<graph.length; i++){
            if(graph[i][graph.length - i - 1] != 0){
                win = false;
                break;
            }
        }
        if(win) count ++;
    }
}
