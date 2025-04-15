import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj12865 {

    static class bag{
        int w;
        int v;

        public bag(int w, int v) {
            this.w = w;
            this.v = v;
        }
    }

    static int n;
    static int k;
    static List<bag> array = new ArrayList<>();
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            array.add(new bag(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        
        recursion(0, 0, 0);

        System.out.println(answer);

        br.close();
    }

    private static void recursion(int idx, int weight, int value) {

        if (idx >= n){
            answer = Math.max(answer, value);
            return;
        }

        if (weight + array.get(idx).w <= k) {
            recursion(idx + 1, weight + array.get(idx).w, value + array.get(idx).v);
        }

        recursion(idx + 1, weight, value);
    }
}
