import java.util.*;
import java.io.*;
public class boj14916 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int answer = 0;

        int n = Integer.parseInt(br.readLine());

        if (n % 5 == 0) // 5로 나누어 떨어지면 몫을 답으로
            answer = n / 5;
        else{
            while (n!=0){ // n이 0이 될 때까지
                if (n >= 10) { // n이 10보다 크면 5 빼주기
                    n -= 5;
                    answer += 1;
                }
                else if (n % 2 == 0){ // n이 10보다 작고 2로 나누어떨어지면 2로 나눠주기
                    answer += n / 2;
                    n %= 2;
                }
                else if (n >= 5){ // 2로 나누어떨어지지 않는다면 5로 빼줘서 2로 나누어떨어지게 하기
                    n -= 5;
                    answer += 1;
                }
                else if (n == 3 || n == 1) { // 나머지가 3 또는 1이면 만들 수 없는 수
                    answer = -1;
                    break;
                }
            }
        }
        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}

/** 더 짧고 효율적인 풀이..... 5로 나누어 떨어지면 나눠주고, 나머지는 무조건 2로 빼주기....
 * import java.io.BufferedReader;
 * import java.io.IOException;
 * import java.io.InputStreamReader;
 *
 * public class Main {
 *
 *
 * 	public static void main(String[] args) throws IOException {
 *
 * 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 *
 * 		// 거슬러 줄 돈
 * 		int n = Integer.parseInt(br.readLine());
 *
 * 		// 동전 개수
 * 		int cnt = 0;
 *
 * 		while(true) {
 *
 * 			if(n % 5 == 0) {
 * 				cnt += n / 5;
 * 				System.out.println(cnt);
 * 				break;
 * 			            } else {
 * 				n -= 2;
 * 				cnt++;
 *            }
 *
 * 			if(n < 0) {
 * 				System.out.println(-1);
 * 				break;
 *            }
 *        * 		}
 *
 * 	}
 * }
 */
