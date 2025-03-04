package 정수론;

import java.io.*;
import java.util.*;

public class boj1456 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        int limit = (int) Math.sqrt(B);
        boolean[] isPrime = new boolean[limit + 1];
        Arrays.fill(isPrime, true);

        // 에라토스테네스의 체: 소수 판별
        for (int i = 2; i * i <= limit; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= limit; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int count = 0;

        for (int i = 2; i <= limit; i++) {
            if (isPrime[i]) {
                long power = (long) i * i;
                while (power <= B) {
                    if (power >= A) {
                        count++;
                    }
                    if (power > B / i) break;
                    power *= i;
                }
            }
        }

        System.out.println(count);
    }
}
