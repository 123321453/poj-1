
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
Number Steps
Time Limit: 1000MS		Memory Limit: 10000K
Total Submissions: 12529		Accepted: 6670
Description

Starting from point (0,0) on a plane, we have written all non-negative integers 0,1,2, ... as shown in the figure. For example, 1, 2, and 3 has been written at points (1,1), (2,0), and (3, 1) respectively and this pattern has continued. 


You are to write a program that reads the coordinates of a point (x, y), and writes the number (if any) that has been written at that point. (x, y) coordinates in the input are in the range 0...5000.
Input

The first line of the input is N, the number of test cases for this problem. In each of the N following lines, there is x, and y representing the coordinates (x, y) of a point.
Output

For each point in the input, write the number written at that point or write No Number if there is none.
Sample Input

3
4 2
6 6
3 4
Sample Output

6
12
No Number
Source

Tehran 2000
 */
public class p1663 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        for(int i = 0;i < num ; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            int tmp = x-y;
            if((x < y) || ((tmp != 2) && (tmp != 0)) ) {
                System.out.println("No Number");
                continue;
            }
            if(y%2 == 0) {
                System.out.println(x+y);
            }
            else {
                System.out.println(x+y-1);
            }
        }
    }
}
