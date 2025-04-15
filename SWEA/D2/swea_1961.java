package D2;

import java.util.*;

public class swea_1961 {

    static int n;
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int tc = 1; tc <= T; tc++) {
            n = sc.nextInt();
            int[][] array = new int[n][n];

            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    array[i][j] = sc.nextInt();
                }
            }

            int[][] array_90 = rotate(array);
            int[][] array_180 = rotate(array_90);
            int[][] array_270 = rotate(array_180);

            System.out.println("#" + tc);

            for(int i=0; i<n; i++){
                for (int j=0; j<n; j++){
                    System.out.print(array_90[i][j]);
                }
                System.out.print(" ");
                for (int j=0; j<n; j++){
                    System.out.print(array_180[i][j]);
                }
                System.out.print(" ");
                for (int j=0; j<n; j++){
                    System.out.print(array_270[i][j]);
                }
                System.out.println();
            }
        }
    }

    private static int[][] rotate(int[][] array) {
        int[][] result = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                result[i][j] = array[array.length-1-j][i];
            }
        }
        return result;
    }
}
