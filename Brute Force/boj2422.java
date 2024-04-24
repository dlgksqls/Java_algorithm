import java.util.*;
import java.io.*;
public class boj2422 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int ice_cream[] = new int[n+1];
        boolean input[][] = new boolean[n+1][n+1];
        int answer = 0;

        for (int i=1; i<=n; i++)
            ice_cream[i] = i;

        for (int i=0; i<m; i++){ // input배열을 사용하여 어울리지 않는 조합 기록하기
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            input[x][y] = true;
            input[y][x] = true;
        }

        // 3중 반복 사용하여 중복하지 않는 세개 선택
        for (int i=1; i<=n-2; i++){
            for (int j=i+1; j<=n-1; j++){
                for (int k=j+1; k<=n; k++){
                    if (!input[i][j] && !input[j][k] && !input[i][k]){ // 어울린다면
                        answer++; // ++
                    }
                }
            }
        }
        System.out.println(answer);
        br.close();
    }
}
