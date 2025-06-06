package 정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj1715 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i=0; i<n; i++){
            queue.add(Integer.parseInt(br.readLine()));
        }

        int result = 0;

        while(queue.size() > 1){
            int a = queue.poll();
            int b = queue.poll();
            result += a + b;
            queue.add(a + b);
        }

        System.out.println(result);
        br.close();
    }
}
