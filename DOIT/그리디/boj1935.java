package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj1935 {

    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        int[][] array = new int[n][2];

        for (int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            array[i][0] = start;
            array[i][1] = end;
        }

        Arrays.sort(array, (o1, o2) -> {

            // 종료시간이 같을 경우 시작시간이 빠른순으로 정렬해야한다.
            if(o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }

            return o1[1] - o2[1];
        });


        int answer = 0;
        int pre = 0;

        for (int i=0; i<n; i++){
            if (pre <= array[i][0]){
                pre = array[i][1];
                answer++;
            }
        }
        System.out.println(answer);

        br.close();
    }
}
