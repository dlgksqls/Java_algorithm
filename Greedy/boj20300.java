import java.io.*;
import java.util.*;
public class boj20300 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        long max = 0;
        // 큰 수를 받기위한 long
        Long input[] = new Long[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++)
            input[i] = Long.parseLong(st.nextToken());

        // 오름차순 정렬
        Arrays.sort(input);

        // n이 짝수라면
        if (n%2==0){
            // 정상적으로 큰값 작은값 더해가면서 max값 갱신
            for (int i=0; i<(n/2)+1;i++){
                long sum = input[i] + input[n-1-i];
                max = Math.max(max, sum);
            }
        }
        else{
            // 그렇지 않다면 젤 큰 값을 저장하고 젤 큰값을 제외하고 더해서 max값 갱신
            max = input[n-1];
            for (int i=0; i<(n/2)+1;i++){
                long sum = input[i] + input[n-2-i];
                max = Math.max(max, sum);
            }
        }

        bw.write(String.valueOf(max));

        br.close();
        bw.close();
    }
}
