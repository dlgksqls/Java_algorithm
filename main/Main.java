import java.util.*;

public class Main {

    public static void main(String[] args) {
        System.out.println(fib(3));
        System.out.println(fac(3));

        int[] array = {5, 6, 4, 8};

        char a = 'b';
        String[] b = "3people unFollowed  me".split(" ");
        for (String s : b) {
            if (s.equals("")) continue;
            System.out.println(s);
        }

    }

    private static int fib(int number) {
        if (number <= 2) {
            return 1;
        } else return fib(number - 1) + fib(number - 2);
    }

    private static int fac(int number) {
        if (number == 1) {
            return 1;
        } else return number * fac(number - 1);
    }

    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        List<Integer> list = new ArrayList<>();
        int day = 0;

        int count = 0;
        while(count < speeds.length){
            for(int i=0; i<speeds.length; i++){
                if (progresses[i] < 100){
                    progresses[i] += speeds[i];
                }
            }
            int add_count = 0;
            while(day < speeds.length && progresses[day] >= 100){
                day ++;
                add_count ++;
                count ++;
            }
            if (add_count != 0){
                list.add(add_count);
            }
        }
        answer = list.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}