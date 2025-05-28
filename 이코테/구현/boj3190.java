package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj3190 {
    static int time = 0;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        int[][] array = new int[n+1][n+1];
        for(int i=0; i<k; i++){
            st = new StringTokenizer(br.readLine());
            array[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
        }

        ArrayList<Order> orders = new ArrayList<>();
        int l = Integer.parseInt(br.readLine());
        for(int i=0; i<l; i++) {
            st = new StringTokenizer(br.readLine());
            orders.add(new Order(Integer.parseInt(st.nextToken()), st.nextToken().charAt(0)));
        }

        simulate(array, orders, n);
        System.out.println(time);

        br.close();
    }

    private static void simulate(int[][] array, ArrayList<Order> orders, int n) {
        int x = 1;
        int y = 1;
        int idx = 0;
        int dir = 0;
        array[x][y] = 2;
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, y));

        while(true){
            time ++;
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx >= 1 && nx <= n && ny >= 1 && ny <= n && array[nx][ny] != 2){
                if (array[nx][ny] == 1){
                    array[nx][ny] = 2;
                    queue.add(new Node(nx, ny));
                }
                else if (array[nx][ny] == 0){
                    array[nx][ny] = 2;
                    queue.add(new Node(nx, ny));
                    Node poll = queue.poll();
                    array[poll.x][poll.y] = 0;
                }
            }
            else{
                return;
            }
            x = nx;
            y = ny;
            if (idx < orders.size() && time == orders.get(idx).time){
                if (orders.get(idx).dir == 'L') dir = (dir + 3) % 4;
                else dir = (dir + 1) % 4;
                idx ++;
            }
        }
    }

    private static class Order {
        int time;
        char dir;

        public Order(int time, char dir) {
            this.time = time;
            this.dir = dir;
        }
    }

    private static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
