package 자료구조.스택_큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * 우선순위 큐 공부하기 !
 */
public class boj11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> myQueue = new PriorityQueue<>((o1, o2) -> {
            int first_abs = Math.abs(o1);
            int second_abs = Math.abs(o2);

            if (first_abs == second_abs)
                return o1 > o2 ? 1 : -1;
            else
                return first_abs - second_abs;
        });

        for(int i=0; i<n; i++){
            int number = Integer.parseInt(br.readLine());

            if (number == 0) {
                if (myQueue.isEmpty()){
                    System.out.println(0);
                }
                else {
                    System.out.println(myQueue.poll());
                }
            }
            else{
                myQueue.add(number);
            }
        }
    }
}
