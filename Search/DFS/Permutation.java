package DFS;

import java.util.Scanner;

// n : 3, m : 2 n : 원소 갯수, m : 뽑는 수
// 원소 : 3, 6, 9
public class Permutation {
    static int n, m;

    public static void permutation(int input[], int answer[], int depth){
        if (depth == m){
            for (int i=0; i<m; i++)
                System.out.print(answer[i] + " ");
            System.out.println();
        }
        else{
            for (int i=0; i<n; i++){
                answer[depth] = input[i];
                permutation(input, answer, depth + 1);
            }
        }
    }
    public static void main(String[] args) {
        n = 3; // 원소 갯수
        m = 2; // 뽑는 수
        int input[] = new int[n];
        int answer[] = new int[m];

        Scanner sc = new Scanner(System.in);
        for(int i=0; i<n; i++){
            input[i] = sc.nextInt();
        }

        permutation(input, answer, 0);
    }
}
