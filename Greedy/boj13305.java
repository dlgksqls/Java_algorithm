import java.util.*;
import java.io.*;
public class boj13305 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        long city[] = new long[n];
        long road[] = new long[n-1];

        long answer = 0;

        StringTokenizer st = new StringTokenizer(br.readLine(), " "); // 도로 정보 가져오기
        for (int i=0; i<road.length; i++){
            road[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " "); // 도시 정보 가져오기
        for (int i=0; i<city.length; i++){
            city[i] = Integer.parseInt(st.nextToken());
        }

        long min_road = city[0];

        for (int i=0; i<n-1; i++){
            /**
             * 도로 배열 길이만큼 순회하면서 최소가 되는 기름 값 갱신
             * 만약에 기름값이 갱신이 되지 않으면 다음 도로까지 계속 가고
             * 그렇지 않으면 기름값을 최소로 갱신하여 다음 도로까지 계산
             */
            if (city[i] < min_road){
                min_road = city[i];
            }
            answer += (min_road * road[i]);
        }
        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}
