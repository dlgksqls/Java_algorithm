package D2;

import java.util.Scanner;

public class swea_1926 {

    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i=1; i<=n; i++){
            String value = String.valueOf(i);
            if (value.contains("3") || value.contains("6") || value.contains("9")){
                for(int j=0; j<value.length(); j++){
                    if (value.charAt(j) == '3' || value.charAt(j) == '6' || value.charAt(j) == '9')
                        System.out.print("-");
                }
                System.out.print(" ");
            }
            else System.out.print(i + " ");
        }
    }
}
