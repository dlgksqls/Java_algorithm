package 자료구조.복습.투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj1253 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] array = new long[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++){
            array[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(array);

        int start_index;
        int end_index;
        long sum;
        int answer = 0;
        long choose;

        for (int i=0; i<n; i++){ // 음수가 있을 수 있으므로,,, 조사할 수를 하나 정하되,, 포인터는 처음과 끝에 하나씩 찍어서 순차적으로 조사해야함
            choose = array[i];

            start_index = 0;
            end_index = n-1;

            sum = array[start_index] + array[end_index];
            while (start_index < end_index){
                if (sum == choose){
                    if (start_index != i && end_index != i) {
                        answer++;
                        break;
                    }
                    else if (start_index == i){
                        start_index ++;
                    }
                    else if (end_index == i){
                        end_index --;
                    }
                }
                else if (sum < choose){
                    start_index ++;
                }
                else if (sum > choose){
                    end_index --;
                }
                sum = array[start_index] + array[end_index];
            }
        }
        System.out.println(answer);
        br.close();
    }
}
