
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
Parsing Real Numbers
Time Limit: 2000MS		Memory Limit: 65536K
Total Submissions: 2305		Accepted: 867
Description

Write a program that read a line of input and checks if the line contains a valid real number. Real numbers may have a decimal point, an exponent (starting with the character e or E), or both. Additionally, it has the usual collection of decimal digits. If there is a decimal point, there must be at least one digit on each side of the point. There may be a plus or minus sign in front of the number, or the exponent, or both (without any blank characters after the sign). Exponents are integers (not having decimal points). There may be blank characters before or after a number, but not inside it. Note that there is no bound on the range of the numbers in the input, but for the sake of simplicity, you may assume the input strings are not longer than 1000 characters.

Input

The first line of the input contains a single integer T which is the number of test cases, followed by T lines each containing the input line for a test case.

Output

The output contains T lines, each having a string which is LEGAL or ILLEGAL.

Sample Input

2
  1.5e+2
3.

Sample Output

LEGAL
ILLEGAL
Source

Tehran 2006 Preliminary
 */
public class p3332 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        for(int i = 0; i < num ; i++) {
            //boolean flag;
            Pattern pattern = Pattern.compile("[//s]*([+-]?[0-9]+)([/.][0-9]+)?([eE][+-]?[0-9]+)?[//s]*");
            Matcher matcher = pattern.matcher(in.next());
            boolean flag = matcher.matches();
            if(flag)
                System.out.println("LEGAL");
            else
                System.out.println("ILLEGAL");
        }
    }
}
