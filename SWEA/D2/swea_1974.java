package D2;

import java.util.*;

public class swea_1974 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int tc = 1; tc <= T; tc++) {
            int[][] board = new int[9][9];

            for(int i = 0; i < 9; i++) {
                for(int j = 0; j < 9; j++) {
                    board[i][j] = sc.nextInt();
                }
            }

            int answer = 1;

            // 1. 행 체크
            for(int i = 0; i < 9; i++) {
                Set<Integer> set = new HashSet<>();
                for(int j = 0; j < 9; j++) {
                    set.add(board[i][j]);
                }
                if(set.size() != 9) answer = 0;
            }

            // 2. 열 체크
            for(int j = 0; j < 9; j++) {
                Set<Integer> set = new HashSet<>();
                for(int i = 0; i < 9; i++) {
                    set.add(board[i][j]);
                }
                if(set.size() != 9) answer = 0;
            }

            // 3. 3x3 박스 체크
            for(int r = 0; r < 9; r += 3) {
                for(int c = 0; c < 9; c += 3) {
                    Set<Integer> set = new HashSet<>();
                    for(int i = r; i < r + 3; i++) {
                        for(int j = c; j < c + 3; j++) {
                            set.add(board[i][j]);
                        }
                    }
                    if(set.size() != 9) answer = 0;
                }
            }

            System.out.println("#" + tc + " " + answer);
        }
    }
}
