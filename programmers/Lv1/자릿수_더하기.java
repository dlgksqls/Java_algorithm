package Lv1;

public class 자릿수_더하기 {

    public static int solution(int n) {
        int answer = 0;
        String string_num = Integer.toString(n);

        for(int i=0; i<string_num.length(); i++){
            answer += string_num.charAt(i) - '0';
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(100000000));
    }
}
