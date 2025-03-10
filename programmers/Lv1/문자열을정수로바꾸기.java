package Lv1;

import java.util.*;
import java.io.*;

public class 문자열을정수로바꾸기 {

    public static int solution(String s) {
        int answer = 0;
        String answer_sub = "";

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '-'){
                answer_sub += '-';
                continue;
            }
            answer_sub += s.charAt(i);
        }

        answer = Integer.valueOf(answer_sub);
        return answer;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(solution("-1234"));
    }
}
