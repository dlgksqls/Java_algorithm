import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj2578 {
    static int[][] array = new int[5][5];
    static int answer = 0;
    static int bingo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int i=0; i<5; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<5; j++){
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<5; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<5; j++) {
                answer ++;
                int call = Integer.parseInt(st.nextToken());

                for(int k=0; k<5; k++){
                    for(int l=0; l<5; l++){
                        if (array[k][l] == call) array[k][l] = 0;

                        bingo = 0;
                        check_row();
                        check_col();
                        check_cross();

                        if (bingo >= 3){
                            System.out.println(answer);
                            return;
                        }
                    }
                }
            }
        }

        br.close();
    }

    private static void check_row() {
        for(int i=0; i<5; i++){
            int count = 0;
            for(int j=0; j<5; j++){
                if (array[i][j] == 0) count ++;
                else break;
            }

            if (count == 5) bingo ++;
        }
    }

    private static void check_col() {
        for(int i=0; i<5; i++){
            int count = 0;
            for(int j=0; j<5; j++){
                if (array[j][i] == 0) count ++;
                else break;
            }

            if (count == 5) bingo ++;
        }
    }

    private static void check_cross() {
        int count = 0;
        for(int i=0; i<5; i++){
            if (array[i][i] == 0) count ++;
        }

        if (count == 5) bingo ++;

        count = 0;
        for(int i=0; i<5; i++){
            if (array[i][4-i] == 0) count ++;
        }

        if (count == 5) bingo ++;
    }
}