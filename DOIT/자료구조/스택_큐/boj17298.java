package 자료구조.스택_큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj17298 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n];
        int[] answer = new int[n];
        int output;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> myStack = new Stack<>();
        myStack.push(0);

        for (int i=1; i<n; i++){
            while(array[myStack.push()]){
                if (array[myStack.peek()] > array[i]){
                    myStack.push(array[i]);
                    break;
                }
                output = myStack.pop();
                myStack.push(i);
                answer[output] = array[i];
            }
        }

        while (!myStack.isEmpty()){
            output = myStack.pop();
            answer[output] = -1;
        }

        for (int i : answer) {
            System.out.println(i);
        }
    }
}
