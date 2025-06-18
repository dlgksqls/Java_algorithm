import java.io.*;
import java.util.*;

public class boj21608 {
    static Map<Integer, ArrayList<Integer>> friends;
    static int[][] classRoom;
    static int[] students;
    static int n;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        classRoom = new int[n][n];
        students = new int[n * n];
        friends = new HashMap<>();

        for(int i=0; i<n * n; i++){
            st = new StringTokenizer(br.readLine());
            int sel = Integer.parseInt(st.nextToken());
            ArrayList<Integer> likes = new ArrayList<>();
            for(int j=0; j<4; j++){
                likes.add(Integer.parseInt(st.nextToken()));
            }

            friends.put(sel, likes);
            students[i] = sel;
        }

        for(int i=0; i<students.length; i++){
            placeStudent(students[i]);
        }

        System.out.println(cal());
        br.close();
    }

    private static void placeStudent(int student) {
        int maxLike = -1;
        int maxBlank = -1;
        int selX = -1;
        int selY = -1;

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if (classRoom[i][j] != 0) continue;

                int like = 0;
                int blank = 0;

                for(int d=0; d<4; d++){
                    int nx = i + dx[d];
                    int ny = j + dy[d];

                    if (nx >= 0 && nx < n && ny >= 0 && ny < n){
                        if (friends.get(student).contains(classRoom[nx][ny])) like ++;
                        else if (classRoom[nx][ny] == 0) blank ++;
                    }
                }

                if ((like > maxLike) ||
                        (like == maxLike && blank > maxBlank) ||
                        (like == maxLike && blank == maxBlank && (i < selX || (i == selX && j < selY)))){
                    maxLike = like;
                    maxBlank = blank;
                    selX = i;
                    selY = j;
                }
            }
        }

        classRoom[selX][selY] = student;
    }

    private static int cal() {
        int[] score = {0, 1, 10, 100, 1000};
        int answer = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                int stu = classRoom[i][j];
                int like = 0;

                for(int d=0; d<4; d++){
                    int nx = i + dx[d];
                    int ny = j + dy[d];

                    if (nx >= 0 && nx < n && ny >= 0 && ny < n){
                        if (friends.get(stu).contains(classRoom[nx][ny])) like ++;
                    }
                }
                answer += score[like];
            }
        }
        return answer;
    }
}