
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
Faulty Odometer
Time Limit: 1000MS		Memory Limit: 65536K
Total Submissions: 8601		Accepted: 5327
Description

You are given a car odometer which displays the miles traveled as an integer. The odometer has a defect, however: it proceeds from the digit 3 to the digit 5, always skipping over the digit 4. This defect shows up in all positions (the one's, the ten's, the hundred's, etc.). For example, if the odometer displays 15339 and the car travels one mile, odometer reading changes to 15350 (instead of 15340).
Input

Each line of input contains a positive integer in the range 1..999999999 which represents an odometer reading. (Leading zeros will not appear in the input.) The end of input is indicated by a line containing a single 0. You may assume that no odometer reading will contain the digit 4.
Output

Each line of input will produce exactly one line of output, which will contain: the odometer reading from the input, a colon, one blank space, and the actual number of miles traveled by the car.
Sample Input

13
15
2003
2005
239
250
1399
1500
999999
0
Sample Output

13: 12
15: 13
2003: 1461
2005: 1462
239: 197
250: 198
1399: 1052
1500: 1053
999999: 531440
Source

Rocky Mountain 2005
 */
public class p2719 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            String tmp = in.next();
            char[] tmp1 = tmp.toCharArray();
            int result = 0;
            if(tmp.equals("0"))
                break;
            for(int i = 0; i < tmp1.length; i++) {
                int n = tmp1[i]-'0';
                if(n > 4)
                    n--;
                result += (int)n*Math.pow(9, tmp1.length-i-1);
            }
            System.out.println(tmp+": "+result);
        }
    }
}
