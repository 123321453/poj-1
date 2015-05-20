
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
StuPId
Time Limit: 3000MS		Memory Limit: 65536K
Total Submissions: 6210		Accepted: 3226
Description

Background 
At DUT, the Dreamland University of Technology, all students have personal id, numbers with six or seven digits. But they're not just any numbers. Only those that have a checksum with a zero as last digit can be valid ids. 
Problem 
Here's how to compute the checksum of an id number. Multiply the digits from back to front (!) with repeating factors 9, 3, 7. Then simply add the products. Example: 

id number :  1  3  9  0  2  7  2

factors   :  9  7  3  9  7  3  9

products  :  9 21 27  0 14 21 18

Here the checksum is 9+21+27+0+14+21+18 = 110. The last digit is zero, so the id is valid. Sometimes students have very bad handwriting and the teaching assistents have a hard time identifying the id’s. You're asked to help in special cases, where exactly one digit is unreadable. In that case, the missing digit can be computed (there's always exactly one correct digit, thanks to 9, 3 and 7 being relatively prime to 10). Note that the students always begin concentrated and thus the first digit will always be readable (and not zero).
Input

The first line contains the number of scenarios. Each scenario is a single line that contains an id number with one digit replaced by a question mark and with six or seven digits length.
Output

The output for every scenario begins with a line containing "Scenario #i:", where i is the number of the scenario starting at 1. Then print a single line containing the correct id number. Terminate the output for the scenario with a blank line.
Sample Input

4
13?0272
3?5678
345?78
314?592
Sample Output

Scenario #1:
1390272

Scenario #2:
335678

Scenario #3:
345778

Scenario #4:
3146592
Hint

Huge input and output,scanf and printf are recommended.
 */
public class p2498 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        for(int i = 1; i <= num ; i++) {
            String tmp = in.next();
            char[] tab = tmp.toCharArray();
            int prev = 0;
            int result = 0;
            int time = 0;
            int mark = -1;
            int tmp1 = -1;
            for(int j = tab.length-1; j >= 0; j--) {
                if(prev == 0) {
                    time = 9;
                    prev = 9;
                }
                else if(prev == 9) {
                    time = 3;
                    prev = 3;
                }
                else if(prev == 3) {
                    time = 7;
                    prev = 7;
                }
                else if (prev == 7) {
                    time = 9;
                    prev = 9;
                }
                else {
                    
                }
                if(tab[j] == '?') {
                    mark = time;
                    tmp1 = j;
                    continue;
                }
                else {
                    result += (tab[j] - '0') * time;
                }
            }
            for(int p = 0; p <= 9; p++) {
                if((result + p * mark ) % 10 == 0) {
                    System.out.printf("Scenario #%d:\n",i);
                    tab[tmp1] = (char)(p+'0');
                    String ls = new String(tab);
                    System.out.println(ls);
                    System.out.println();
                    break;
                }
            }
        }
    }
}
