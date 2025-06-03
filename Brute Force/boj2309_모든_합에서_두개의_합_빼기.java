import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class boj2309_모든_합에서_두개의_합_빼기 {
    static ArrayList<Integer> arrayList;
    static int[] result;
    static boolean flag = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] array = new int[9];
        int sum = 0;
        for(int i=0; i<9; i++){
            array[i] = Integer.parseInt(br.readLine());
            sum += array[i];
        }

        result = new int[7];

        for(int i=0; i<8; i++){
            for(int j=i+1; j<9; j++){
                if ((sum - array[i] - array[j]) == 100){
                    int idx = 0;
                    for(int k=0; k<9; k++){
                        if (k == i || k == j) continue;
                        result[idx++] = array[k];
                    }
                    Arrays.sort(result);
                    for (int num : result) {
                        System.out.println(num);
                    }
                    br.close();
                    return;
                }
            }
        }
    }
}
