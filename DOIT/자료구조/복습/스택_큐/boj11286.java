package 자료구조.복습.스택_큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class boj11286 {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> queue = new PriorityQueue<>((t1, t2) -> {
                int abs_t1 = Math.abs(t1);
                int abs_t2 = Math.abs(t2);

                if (abs_t1 == abs_t2) return t1 > t2 ? 1 : -1; // 실제 값이 작은 것이 앞으로 정렬
                else return abs_t1 > abs_t2 ? 1 : -1; // 절댓값이 큰 것을 뒤로 정렬
        });

        int input;
        for (int i=0; i<n; i++){
            input = Integer.parseInt(br.readLine());
            if (input == 0){
                if (queue.isEmpty()){
                    System.out.println(0);
                    continue;
                }
                System.out.println(queue.poll());
                continue;
            }
            queue.add(input);
        }
    }
}
