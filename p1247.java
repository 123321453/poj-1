
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
Magnificent Meatballs
Time Limit: 1000MS		Memory Limit: 10000K
Total Submissions: 5912		Accepted: 3946
Description

Sam and Ella run a catering service. They like to put on a show when serving meatballs to guests seated at round tables. They march out of the kitchen with pots of meatballs and start serving adjacent guests. Ella goes counterclockwise and Sam goes clockwise, until they both plop down their last meatball, at the same time, again at adjacent guests. This impressive routine can only be accomplished if they can divide the table into two sections, each having the same number of meatballs. You are to write a program to assist them. 

At these catering events, each table seats 2 <= N <= 30 guests. Each guest orders at least one and at most nine meatballs. Each place at the table is numbered from 1 to N, with the host at position 1 and the host's spouse at position N. Sam always serves the host first then proceeds to serve guests in increasing order. Ella serves the spouse first, then serves guests in decreasing order. The figures illustrate the first two example input cases. 

Input

Input consists of one or more test cases. Each test case contains the number of guests N followed by meatballs ordered by each guest, from guest 1 to guest N. The end of the input is a line with a single zero. 
Output

For each table, output a single line with the ending positions for Sam and Ella, or the sentence indicating an equal partitioning isn't possible. Use the exact formatting shown below. 
Sample Input

5 9 4 2 8 3
5 3 9 4 2 8
6 1 2 1 2 1 2
6 1 2 1 2 1 1
0
Sample Output

Sam stops at position 2 and Ella stops at position 3.
No equal partitioning.
No equal partitioning.
Sam stops at position 3 and Ella stops at position 4.
Source

Mid-Central USA 2002
 */
public class p1247 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            int num = in.nextInt();
            if(num == 0)
                break;
            int[] gst = new int[num];
            int i,j,k;
            for(i = 0 ;i < num ; i++)
                gst[i] = in.nextInt();
            boolean equal = false;
            int samH = 0;
            int ellaH;
            for(i = 0; i < num; i++){
                samH += gst[i];
                ellaH = 0;
                for(j = i+1; j< num;j++){
                    ellaH += gst[j];
                }
                if(samH == ellaH){
                    equal = true;
                    break;
                }
            }
            if(equal) {
                System.out.printf("Sam stops at position %d and Ella stops at position %d.\n",(i+1),(i+2));
            }
            else {
                System.out.println("No equal partitioning.");
            }
        }
    }
}
