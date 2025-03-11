package Lv1;

public class 나머지가_1이_되는수 {

    public static int solution(int n) {
        int answer = 0;

        for (int i=1; i<n; i++){
            if (n % i == 1){
                answer = i;
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(100000));
    }
}
