import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj2578 {

    static int[][] array = new int[5][5];
    static int answer = 0;
    static int bingo_count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 빙고판 입력 받기
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 사회자가 부르는 숫자 처리
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                answer++;
                int number = Integer.parseInt(st.nextToken());

                for (int x = 0; x < 5; x++) {
                    for (int y = 0; y < 5; y++) {
                        if (array[x][y] == number) {
                            array[x][y] = 0;

                            row_check(x);
                            col_check(y);
                            if (x == y) cross_check();
                            if (x + y == 4)cross_check_reverse();

                            if (bingo_count >= 3) {
                                System.out.println(answer);
                                return;
                            }
                        }
                    }
                }
            }
        }
    }

    private static void row_check(int row) {
        for (int i = 0; i < 5; i++) {
            if (array[row][i] != 0) return;
        }
        bingo_count++;
    }

    private static void col_check(int col) {
        for (int i = 0; i < 5; i++) {
            if (array[i][col] != 0) return;
        }
        bingo_count++;
    }

    private static void cross_check() {
        for (int i = 0; i < 5; i++) {
            if (array[i][i] != 0) return;
        }
        bingo_count++;
    }

    private static void cross_check_reverse() {
        for (int i = 0; i < 5; i++) {
            if (array[i][4 - i] != 0) return;
        }
        bingo_count++;
    }
}