import java.io.*;
import java.util.*;
public class boj21314 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        int cnt = 0; // M 갯수 카운팅
        boolean flag = false; // M이 나왔는가?

        String max = maxNum(new StringBuilder(), cnt, flag, input); // 각각 새로운 StringBuilder 사용
        String min = minNum(new StringBuilder(), cnt, flag, input);

        System.out.println(max);
        System.out.println(min);

        br.close();
    }

    public static String maxNum(StringBuilder sb, int cnt, boolean flag, String input){
        for (int i=0; i<input.length(); i++){
            if (!flag && input.charAt(i) == 'K') // K만 나온다면 5 추가
                sb.append(5);
            if (input.charAt(i) == 'M') { // M이 나온다면 카운팅
                flag = true;
                cnt++;
            }
            else if (flag && input.charAt(i) == 'K'){ // M이 존재하는 상황에서 K가 나오면
                sb.append(5).append("0".repeat(cnt)); // 일단 5를 추가하고, M이 나온 수 만큼 0 추가
                flag = false; // M 갯수 초기화
                cnt = 0;
            }
        }
        if (cnt != 0) // 문자열을 다돌았는데도 M이 남았다면 M수만큼 1 추가
            sb.append("1".repeat(cnt));
        return sb.toString();
    }
    public static String minNum(StringBuilder sb, int cnt, boolean flag, String input){
        for (int i=0; i<input.length(); i++){
            if (!flag && input.charAt(i) == 'K')
                sb.append(5);
            if (input.charAt(i) == 'M') {
                flag = true;
                cnt++;
            }
            else if(flag && input.charAt(i) == 'K'){ // M이 나온 상태에서 K가 나온다면
                sb.append(1).append("0".repeat(cnt-1)); // 일단 1 추가하고, M이 나온 수-1 만큼 0 추가
                sb.append(5); // 그 다음 K 추가
                flag = false;
                cnt = 0;
            }
        }
        if (cnt != 0){ // M이 남아있다면 1추가 후 0 추가
            sb.append(1).append("0".repeat(cnt-1));
        }
        return sb.toString();
    }
}
