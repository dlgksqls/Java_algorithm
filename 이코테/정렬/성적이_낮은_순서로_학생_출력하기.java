package 정렬;

import java.util.Arrays;
import java.util.Scanner;

public class 성적이_낮은_순서로_학생_출력하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Student[] students = new Student[n];
        for(int i=0; i<n; i++){
            students[i] = new Student(sc.next(), sc.nextInt());
        }

        Arrays.sort(students);

        for (Student student : students) {
            System.out.print(student.name + " ");
        }
    }

    static class Student implements Comparable<Student>{
        String name;
        int score;

        public Student(String name, int score) {
            this.name = name;
            this.score = score;
        }

        @Override
        public int compareTo(Student s){
            return Integer.compare(this.score, s.score); // 오름차순
        }
    }
}
