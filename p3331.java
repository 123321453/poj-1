
import java.math.BigDecimal;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
The Idiot of the Year Contest!
Time Limit: 2000MS		Memory Limit: 65536K
Total Submissions: 3567		Accepted: 1873
Description

There is just one basic rule in the Idiot of the Year Contest (IYC)! The contestant picks a random digit between 0 and 9, computes the factorial of the day of the year he/she is born, and counts the how many times the digit picked appears in the factorial. The contestant with highest count is the Idiot of the Year! For example, if you are born on 5th of Mordad which is the 129th day of the year, and you pick the digit 6, your score will be the number of times the digit 6 appears in 129! (that is 1 × 2 × 3 × ... × 129).

The chief judge of IYC wants you to write a program to get an integer which is the day of the year a contestant is born on and a digit and report the number of times the digit appears in the factorial of the first number.

Input

The first line of the input contains a single integer T which is the number of test cases, followed by T lines each containing the data for a test case having two numbers. The first number is the day of the year a contestant is born and the second one is the digit he/she has picked.

Output

The output contains T lines, each having one integer which is the number of times the digit appears in the factorial of the first number.

Sample Input

2
5 2
7 0
Sample Output

1
2 
Source

Tehran 2006 Preliminary
 */
public class p3331 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        for(int i = 0; i < N ; i++) {
            int m = in.nextInt();
            String n = in.next();
            BigDecimal sum = BigDecimal.ONE;
            for(int j = 1; j <= m; j++) {
                sum = sum.multiply(new BigDecimal(j));
            }
            char[] tab = sum.toString().toCharArray();
            int cnt = 0;
            for(int j = 0; j < tab.length; j++) {
                StringBuilder tmp = new StringBuilder();
                tmp.append(tab[j]);
                if(tmp.toString().equals(n))
                    cnt++;
            }
            System.out.println(cnt);
        }
    }
}
