
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
SPIN
Time Limit: 1000MS		Memory Limit: 65536K
Total Submissions: 5963		Accepted: 3101
Description

Simulate a locked spinner puzzle. 

A locked spinner puzzle is a puzzle where you can only change wheels in groups. It is a common puzzle to achieve some value on the spinners by only changing them in the allowed groups. 

Imagine a row of D numbered wheels, each labeled sequentially with the digits 0 through 9. This is similar to what is on a briefcase combination lock. 

Below this are a series of B buttons with labels that are D digits long. For example, D may be 4 and the labels are 1000 1200 1002 0111 and 0100. Pressing the button labeled 1000 moves the first wheel once, but leaves the others alone, while pressing the button labeled 1002 moves the first wheel once and the fourth wheel twice, leaving the center wheels unchanged. 

Your task is to simulate such a locked spinner puzzle giving the final readout of the wheels.
Input

The input to your program will be a line containing D digits (at most 10) representing the starting positions of the wheels. Following this, each line will have the button label for which button is pressed next.There will always be at least 1 digit 
Output

Output the final positions of the wheels.
Sample Input

0001
1003
0206
0034
1111
1003
Sample Output

3348
Source

Rocky Mountain 2003
 */
public class p2316 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] tmp = in.next().toCharArray();
        int[] tab = new int[tmp.length];
        for(int i = 0; i < tmp.length ; i++) {
            tab[i] = ((int)(tmp[i] - '0'))%10;
        }
        while(in.hasNext()) {
            tmp = in.next().toCharArray();
            for (int i = 0; i < tmp.length; i++) {
                tab[i] = (tab[i] + ((int) (tmp[i] - '0'))) % 10;
            }
        }
        for(int i = 0; i < tmp.length; i++) {
            System.out.print(tab[i]);
        }
    }
}
