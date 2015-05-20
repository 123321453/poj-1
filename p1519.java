
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
Digital Roots
Time Limit: 1000MS		Memory Limit: 10000K
Total Submissions: 23895		Accepted: 7916
Description

The digital root of a positive integer is found by summing the digits of the integer. If the resulting value is a single digit then that digit is the digital root. If the resulting value contains two or more digits, those digits are summed and the process is repeated. This is continued as long as necessary to obtain a single digit. 

For example, consider the positive integer 24. Adding the 2 and the 4 yields a value of 6. Since 6 is a single digit, 6 is the digital root of 24. Now consider the positive integer 39. Adding the 3 and the 9 yields 12. Since 12 is not a single digit, the process must be repeated. Adding the 1 and the 2 yeilds 3, a single digit and also the digital root of 39.
Input

The input file will contain a list of positive integers, one per line. The end of the input will be indicated by an integer value of zero.
Output

For each integer in the input, output its digital root on a separate line of the output.
Sample Input

24
39
0
Sample Output

6
3
Source

Greater New York 2000
 */
public class p1519 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            String N = in.next();
            if(N.equals("0"))
                break;
            char[] tmp = N.toCharArray();
            StringBuffer tab = new StringBuffer();
            int sum = 0;
            while(true) {
                sum = 0;
               // System.out.println(tmp);
                for(int i = 0; i < tmp.length; i++) {
                    sum += tmp[i]-'0';
                }
                tmp = String.valueOf(sum).toCharArray();
                if(tmp.length > 1)
                    continue;
                else {
                    break;
                }               
            }
            System.out.println(sum);
        }
    }
}
