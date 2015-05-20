
import java.util.Arrays;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
Doubles
Time Limit: 1000MS		Memory Limit: 10000K
Total Submissions: 16474		Accepted: 9438
Description

As part of an arithmetic competency program, your students will be given randomly generated lists of from 2 to 15 unique positive integers and asked to determine how many items in each list are twice some other item in the same list. You will need a program to help you with the grading. This program should be able to scan the lists and output the correct answer for each one. For example, given the list 
1 4 3 2 9 7 18 22

your program should answer 3, as 2 is twice 1, 4 is twice 2, and 18 is twice 9. 
Input

The input will consist of one or more lists of numbers. There will be one list of numbers per line. Each list will contain from 2 to 15 unique positive integers. No integer will be larger than 99. Each line will be terminated with the integer 0, which is not considered part of the list. A line with the single number -1 will mark the end of the file. The example input below shows 3 separate lists. Some lists may not contain any doubles.
Output

The output will consist of one line per input list, containing a count of the items that are double some other item.
Sample Input

1 4 3 2 9 7 18 22 0
2 4 8 10 0
7 5 11 13 1 3 0
-1
Sample Output

3
2
0
Source

Mid-Central USA 2003
 */
public class p1552 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            String[] tab = in.nextLine().split("\\s+");
            if(tab[0].equals("-1"))
                break;
            int[] numD = new int[tab.length-1];
            int i;
            for(i = 0; i < (tab.length-1); i++) {
                if(!tab[i].equals("0"))
                    numD[i] = Integer.valueOf(tab[i]);
                else
                    break;
            }
            Arrays.sort(numD);
            int cnt = 0;
            for(i = 0; i < numD.length; i++){
                for(int j =i+1; j < numD.length ;j++) {
                    if(numD[j] == 2*numD[i])
                        cnt++;
                }
            }
            System.out.println(cnt);
        }
    }
}
