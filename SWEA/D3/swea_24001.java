package D3;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class swea_24001 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int tc = 1; tc <= n; tc ++){
            int answer = 0;
            char[] array = sc.next().toCharArray();

            Arrays.sort(array);
            for(int i=array.length-1; i>=0; i--){
                if (array[i] == 'R') answer ++;
                else if (array[i] == 'L') answer --;
                else if (array[i] == '?'){
                    if (answer >= 0) answer ++;
                    if (answer < 0) answer --;
                }
            }

            System.out.println(Math.abs(answer));
        }
    }
}
