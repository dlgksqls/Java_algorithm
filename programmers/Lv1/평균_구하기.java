package Lv1;

public class 평균_구하기 {

    public static double solution(int[] arr) {
        double answer = 0;

        for (int i=0; i<arr.length; i++){
            answer += arr[i];
        }

        answer /= (long)arr.length;
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 3, 4}));
    }
}
