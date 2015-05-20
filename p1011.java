
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicLong;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
Sticks
Time Limit: 1000MS		Memory Limit: 10000K
Total Submissions: 101070		Accepted: 22993
Description

George took sticks of the same length and cut them randomly until all parts became at most 50 units long. Now he wants to return sticks to the original state, but he forgot how many sticks he had originally and how long they were originally. Please help him and design a program which computes the smallest possible original length of those sticks. All lengths expressed in units are integers greater than zero.
Input

The input contains blocks of 2 lines. The first line contains the number of sticks parts after cutting, there are at most 64 sticks. The second line contains the lengths of those parts separated by the space. The last line of the file contains zero.
Output

The output should contains the smallest possible length of original sticks, one per line.
Sample Input

9
5 2 1 5 2 1 5 2 1
4
1 2 3 4
0
Sample Output

6
5
 */
public class p1011 {
    private static int result ;
    public static int dfs(int[] tab, int i) {
       // if(i == 0)
            return result;
        
        
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int N = in.nextInt();
            if(N == 0)
                 break;
            int[] tab = new int[N];
            int length = 0;
            result = 0;
            for(int i = 0; i < N; i++) {
                tab[i] = in.nextInt();
                length += tab[i];
            }
            Arrays.sort(tab);
            
        }
    }
    
}
