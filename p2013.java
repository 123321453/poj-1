
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
Symmetric Order
Time Limit: 1000MS		Memory Limit: 30000K
Total Submissions: 10779		Accepted: 6675
Description

In your job at Albatross Circus Management (yes, it's run by a bunch of clowns), you have just finished writing a program whose output is a list of names in nondescending order by length (so that each name is at least as long as the one preceding it). However, your boss does not like the way the output looks, and instead wants the output to appear more symmetric, with the shorter strings at the top and bottom and the longer strings in the middle. His rule is that each pair of names belongs on opposite ends of the list, and the first name in the pair is always in the top part of the list. In the first example set below, Bo and Pat are the first pair, Jean and Kevin the second pair, etc. 
Input

The input consists of one or more sets of strings, followed by a final line containing only the value 0. Each set starts with a line containing an integer, n, which is the number of strings in the set, followed by n strings, one per line, sorted in nondescending order by length. None of the strings contain spaces. There is at least one and no more than 15 strings per set. Each string is at most 25 characters long.
Output

For each input set print "SET n" on a line, where n starts at 1, followed by the output set as shown in the sample output.
Sample Input

7
Bo
Pat
Jean
Kevin
Claude
William
Marybeth
6
Jim
Ben
Zoe
Joey
Frederick
Annabelle
5
John
Bill
Fran
Stan
Cece
0
Sample Output

SET 1
Bo
Jean
Claude
Marybeth
William
Kevin
Pat
SET 2
Jim
Zoe
Frederick
Annabelle
Joey
Ben
SET 3
John
Fran
Cece
Stan
Bill
Source

Mid-Central USA 2004
 */
public class p2013 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int k = 1;
        while(in.hasNext()) {
            int num = in.nextInt();
            if(num == 0)
                break;
            //String[] prev = new String[num];
            String[] curr = new String[num];
            int i,j;
            if(num %2 != 0) {
                for(i = 0, j = num -1; i != j; i++, j--) {
                    curr[i] = in.next();
                    curr[j] = in.next();
                }
                curr[i] = in.next();
            }
            else {
                for(i = 0, j = num -1; i < num/2; i++, j--) {
                    curr[i] = in.next();
                    curr[j] = in.next();
                }
            }
            System.out.printf("SET %d\n",k++);
            for(i = 0; i < num ; i++) {
                System.out.println(curr[i]);
            }
        }
    }
}
