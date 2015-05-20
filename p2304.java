
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
Combination Lock
Time Limit: 1000MS		Memory Limit: 65536K
Total Submissions: 4111		Accepted: 2522
Description

Now that you're back to school for another term, you need to remember how to work the combination lock on your locker. A common design is that of the Master Brand, shown at right. The lock has a dial with 40 calibration marks numbered 0 to 39. A combination consists of 3 of these numbers; for example: 15-25-8. To open the lock, the following steps are taken: 
turn the dial clockwise 2 full turns 
stop at the first number of the combination 
turn the dial counter-clockwise 1 full turn 
continue turning counter-clockwise until the 2nd number is reached 
turn the dial clockwise again until the 3rd number is reached 
pull the shank and the lock will open.

Given the initial position of the dial and the combination for the lock, how many degrees is the dial rotated in total (clockwise plus counter-clockwise) in opening the lock?
Input

Input consists of several test cases. For each case there is a line of input containing 4 numbers between 0 and 39. The first number is the position of the dial. The next three numbers are the combination. Consecutive numbers in the combination will be distinct. A line containing 0 0 0 0 follows the last case.
Output

For each case, print a line with a single integer: the number of degrees that the dial must be turned to open the lock.
Sample Input

0 30 0 30
5 35 5 35
0 20 0 20
7 27 7 27
0 10 0 10
9 19 9 19
0 0 0 0
Sample Output

1350
1350
1620
1620
1890
1890
 */
public class p2304 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int a0,a1,a2,a3;
        String[] arr;
        int out;
        int de = 9;
        int r1,r2,r3;
        while(true){
           // arr = in.nextLine().split("\\s+");
          //  a0 = Integer.parseInt(arr[0]);
          //  a1 = Integer.parseInt(arr[1]);
          //  a2 = Integer.parseInt(arr[2]);
          //  a3 = Integer.parseInt(arr[3]);
            
            a0 = in.nextInt();
            a1 = in.nextInt();
            a2 = in.nextInt();
            a3 = in.nextInt();
            if((a0 | a1 | a2 |a3) == 0 )
                break;
            if(a1 > a0)
                r1 = (40 - a1 + a0) * de;
            else 
                r1 = (a0 - a1) * de;
       
            
            if (a2 < a1)
                r2 = (40 - a1 + a2)* de;
            else 
                r2 = (a2 - a1) * de;
            
            if(a3 > a2)
                r3 = (40- a3 + a2) * de;
            else 
                r3 = (a2 - a3) * de;
            out = r1 + r2 + r3 + 720 + 360;
            System.out.println(out);
        }
    }
}
