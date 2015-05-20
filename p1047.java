
import java.math.BigInteger;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
Round and Round We Go
Time Limit: 1000MS		Memory Limit: 10000K
Total Submissions: 10710		Accepted: 4909
Description

A cyclic number is an integer n digits in length which, when multiplied by any integer from 1 to n, yields a"cycle"of the digits of the original number. That is, if you consider the number after the last digit to "wrap around"back to the first digit, the sequence of digits in both numbers will be the same, though they may start at different positions.For example, the number 142857 is cyclic, as illustrated by the following table: 
142857	*1	=	142857 
142857	*2	=	285714 
142857	*3	=	428571 
142857	*4	=	571428 
142857	*5	=	714285 
142857	*6	=	857142 
Input

Write a program which will determine whether or not numbers are cyclic. The input file is a list of integers from 2 to 60 digits in length. (Note that preceding zeros should not be removed, they are considered part of the number and count in determining n. Thus, "01"is a two-digit number, distinct from "1" which is a one-digit number.)
Output

For each input integer, write a line in the output indicating whether or not it is cyclic.
Sample Input

142857
142856
142858
01
0588235294117647
Sample Output

142857 is cyclic
142856 is not cyclic
142858 is not cyclic
01 is not cyclic
0588235294117647 is cyclic
 */

//key is num*(len + 1) = 9999999
public class p1047 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            
            String tmp = in.nextLine().trim();
            BigInteger num = new BigInteger(tmp);
            //System.out.println("De: " + num);
            int len = tmp.length()+1;
            String str = String.valueOf(len);
            BigInteger mul = new BigInteger(str);
            StringBuilder buf = new StringBuilder();
            for(int i = 0 ; i < (len-1); i++) {
                buf.append('9');
            }
            BigInteger total = new BigInteger(buf.toString());
           // System.out.println("Debug: " + total);
            if(num.multiply(mul).equals(total)) {
                System.out.println(tmp + " is cyclic");
            }
            else {
                System.out.println(tmp + " is not cyclic");
            }
            
            
        }
    }
}
