package D2;

import java.util.*;

public class swea_1974 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int tc = 1; tc <= T; tc++) {
            int[][] array = new int[9][9];

            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    array[i][j] = sc.nextInt();
                }
            }

            boolean flag = true;

            for(int i=0; i<9; i++){
                if (flag) {
                    boolean[] check = new boolean[10];
                    for (int j = 0; j < 9; j++) {
                        if (!check[array[i][j]]) {
                            check[array[i][j]] = true;
                            continue;
                        }
                        flag = false;
                        break;
                    }
                }
            }
            for(int i=0; i<9; i++){
                if (flag) {
                    boolean[] check = new boolean[10];
                    for (int j = 0; j < 9; j++) {
                        if (!check[array[j][i]]) {
                            check[array[j][i]] = true;
                            continue;
                        }
                        flag = false;
                        break;
                    }
                }
            }

            for(int i=0; i<9; i+=3){
                for(int j=0; j<9; j+=3){
                    if (flag){
                        boolean[] check = new boolean[10];
                        for(int k=0; k<3; k++){
                            for(int l=0; l<3; l++){
                                if (!check[array[i+k][j+l]]){
                                    check[array[i+k][j+l]] = true;
                                    continue;
                                }
                                flag = false;
                                break;
                            }
                        }
                    }
                }
            }
            if (flag) {
                System.out.println("#" + tc + " " + 1);
            }
            else System.out.println("#" + tc + " " + 0);
        }
    }
}
