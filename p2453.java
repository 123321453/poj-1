
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
An Easy Problem
Time Limit: 1000MS		Memory Limit: 65536K
Total Submissions: 7287		Accepted: 4325
Description

As we known, data stored in the computers is in binary form. The problem we discuss now is about the positive integers and its binary form. 

Given a positive integer I, you task is to find out an integer J, which is the minimum integer greater than I, and the number of '1's in whose binary form is the same as that in the binary form of I. 

For example, if "78" is given, we can write out its binary form, "1001110". This binary form has 4 '1's. The minimum integer, which is greater than "1001110" and also contains 4 '1's, is "1010011", i.e. "83", so you should output "83".
Input

One integer per line, which is I (1 <= I <= 1000000). 

A line containing a number "0" terminates input, and this line need not be processed.
Output

One integer per line, which is J.
Sample Input

1
2
3
4
78
0
Sample Output

2
4
5
8
83
Source

POJ Monthly,zby03

 */
public class p2453 {
    public static int retNum(int num) {
        int result = 0;
        while(num > 0) {
            num = num & (num-1);
            result++;
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            int N = in.nextInt();
            if(N == 0)
                break;
            int sum1 = retNum(N);
            int j;
            for(j = N+1;;j++) {
                int sum2 = retNum(j);
                if(sum2 == sum1)
                    break;
            }
            System.out.println(j);
        }
    }
}
