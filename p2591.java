
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
Set Definition
Time Limit: 1000MS		Memory Limit: 65536K
Total Submissions: 8694		Accepted: 4002
Description

Set S is defined as follows: 
(1) 1 is in S; 
(2) If x is in S, then 2x + 1 and 3x + 1 are also in S; 
(3) No other element belongs to S. 

Find the N-th element of set S, if we sort the elements in S by increasing order.
Input

Input will contain several test cases; each contains a single positive integer N (1 <= N <= 10000000), which has been described above.
Output

For each test case, output the corresponding element in S.
Sample Input

100
254
Sample Output

418
1461
 */
public class p2591 {
   // private static long[10000000] num1;
    public static void main(String[] args) {
         int[] num = new int[10000001];
         num[0] = 1;
         int two,three;
         int i;
         int t2,t3;
         two = 0;
         three = 0;
         for(i = 1 ; i < 10000000 ; i++){
             t2 = 2*num[two]+1;
             t3 = 3*num[three]+1;
             if(t2 > t3) {
                 num[i] = t3;
                 three++;
             }
             else if(t2 < t3) {
                 num[i] = t2;
                 two++;
             }
             else {
                 num[i] = t2;
                 two++;
                 three++;
             }
             
         }
         Scanner in = new Scanner(System.in);
         while(in.hasNext()) {
             int n = in.nextInt();
             System.out.println(num[n-1]);
         }
    }
            
}
