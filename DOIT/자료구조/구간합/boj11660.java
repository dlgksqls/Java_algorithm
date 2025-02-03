package 자료구조.구간합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj11660 {

    /**
     * 첫째 줄에 표의 크기 N과 합을 구해야 하는 횟수 M이 주어진다. (1 ≤ N ≤ 1024, 1 ≤ M ≤ 100,000)
     * 둘째 줄부터 N개의 줄에는 표에 채워져 있는 수가 1행부터 차례대로 주어진다.
     * 다음 M개의 줄에는 네 개의 정수 x1, y1, x2, y2 가 주어지며, (x1, y1)부터 (x2, y2)의 합을 구해 출력해야 한다.
     * 표에 채워져 있는 수는 1,000보다 작거나 같은 자연수이다. (x1 ≤ x2, y1 ≤ y2)
     * 입력
     * 4 3
     * 1 2 3 4
     * 2 3 4 5
     * 3 4 5 6
     * 4 5 6 7
     * 2 2 3 4 => 27
     * 3 4 3 4 => 6
     * 1 1 4 4 => 64
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int [][] array = new int[n+1][n+1];
        int [][] sum = new int[n+1][n+1];

        for (int i=1; i<n+1; i++){
            st = new StringTokenizer(br.readLine());
            for (int j=1; j<n+1; j++){
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}
