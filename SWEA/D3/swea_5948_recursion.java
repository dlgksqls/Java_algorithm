package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class swea_5948_recursion {
    static int count;
    static TreeSet<Integer> result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc ++){
            int[] array = new int[7];
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<7; i++){
                array[i] = Integer.parseInt(st.nextToken());
            }

            result = new TreeSet<>(Collections.reverseOrder());
            count = 0;
            recursion(0, 0, 0, array.length - 1, array);

            int answer = 0;
            for(int i=0; i<5; i++){
                answer = result.pollFirst();
            }
            System.out.println("#" + tc + " " + answer);
        }
    }

    private static void recursion(int idx, int sum, int depth, int n, int[] array) {

        if (depth == 3){
            result.add(sum);
            return;
        }

        if (idx > n) return;

        recursion(idx + 1, sum + array[idx], depth + 1, n, array);

        recursion(idx + 1, sum, depth, n, array);
    }
}
