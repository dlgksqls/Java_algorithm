package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class swea_22979 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc ++){
            ArrayList<Character> arrayList = new ArrayList<>();
            for (char c : br.readLine().toCharArray()) {
                arrayList.add(c);
            }
            int n = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++){
                int order = Integer.parseInt(st.nextToken());

                int start = 0;
                int end = arrayList.size()-1;
                if (order == 0) continue;
                else if (order > 0){
                    while(order != 0){
                        arrayList.add(arrayList.remove(start));
                        order --;
                    }
                }
                else if (order < 0){
                    while(order != 0){
                        arrayList.add(start, arrayList.remove(end));
                        order ++;
                    }
                }
            }
            arrayList.stream().forEach(x -> System.out.print(x));
            System.out.println();
        }
    }
}
