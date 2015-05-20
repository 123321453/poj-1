
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
Big Clock
Time Limit: 1000MS		Memory Limit: 131072K
Total Submissions: 8776		Accepted: 5568
Description

Our vicar raised money to have the church clock repaired for several weeks. The big clock, which used to strike the hours days and nights, was damaged several weeks ago and had been silent since then. 

After the clock was repaired, it works all right, but there is still something wrong with it: the clock will strike thirteen times at one o’clock, fourteen times at two o’clock... 24 times at 12:00, 1 time at 13:00... 

How many times will it strike now? 
Input

The first line consists of only one integer T (T <= 30), representing the number of test cases. Then T cases follow. 

Each test case consists of only one line, representing the time now. Each line includes 2 integers H, M separated by a symbol ":". (0 <= H < 24, 0 <= M < 60) 
Output

For each test case, output the answer in one line.
Sample Input

3
1:00
01:01
00:00
Sample Output

13
0
12
Source

POJ Monthly--2006.06.25, Lei Tao
 */
public class p2840 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int i;
        for(i = 0; i < num ;i++) {
            String[] test = in.next().split(":");
            if(!test[1].equals("00")){
                System.out.println("0");
                continue;
            }
            else {
                int x = Integer.parseInt(test[0]);
                if(x != 12)
                    System.out.println((x+12)%24);
                else
                    System.out.println(24);
            }
        }
    }
}
