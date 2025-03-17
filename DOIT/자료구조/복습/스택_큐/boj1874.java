package 자료구조.복습.스택_큐;

import java.io.*;
import java.util.Scanner;
import java.util.Stack;

public class boj1874 {
    static int n;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuilder answer = new StringBuilder();

        n  = sc.nextInt();
        Stack<Integer> stack = new Stack<>();
        int add_number = 1;

        for (int i=0; i<n; i++) {
            int number =  sc.nextInt();
            while (true) {
                if (add_number <= number){
                    stack.add(add_number++);
                    answer.append("+\n");
                }
                if (stack.peek() == number){
                    stack.pop();
                    answer.append("-\n");
                    break;
                }
                if (stack.peek() > number){
                    System.out.println("NO");
                    return;
                }
            }
        }
        System.out.println(answer);
    }
}
