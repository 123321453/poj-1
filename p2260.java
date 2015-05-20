
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
Error Correction
Time Limit: 1000MS		Memory Limit: 65536K
Total Submissions: 5142		Accepted: 3359
Description

A boolean matrix has the parity property when each row and each column has an even sum, i.e. contains an even number of bits which are set. Here's a 4 x 4 matrix which has the parity property: 
1 0 1 0

0 0 0 0

1 1 1 1

0 1 0 1

The sums of the rows are 2, 0, 4 and 2. The sums of the columns are 2, 2, 2 and 2. 
Your job is to write a program that reads in a matrix and checks if it has the parity property. If not, your program should check if the parity property can be established by changing only one bit. If this is not possible either, the matrix should be classified as corrupt. 

Input

The input will contain one or more test cases. The first line of each test case contains one integer n (n<100), representing the size of the matrix. On the next n lines, there will be n integers per line. No other integers than 0 and 1 will occur in the matrix. Input will be terminated by a value of 0 for n.
Output

For each matrix in the input file, print one line. If the matrix already has the parity property, print "OK". If the parity property can be established by changing one bit, print "Change bit (i,j)" where i is the row and j the column of the bit to be changed. Otherwise, print "Corrupt".
Sample Input

4
1 0 1 0
0 0 0 0
1 1 1 1
0 1 0 1
4
1 0 1 0
0 0 1 0
1 1 1 1
0 1 0 1
4
1 0 1 0
0 1 1 0
1 1 1 1
0 1 0 1
0
Sample Output

OK
Change bit (2,3)
Corrupt
Source

Ulm Local 1998
 */
public class p2260 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            int n = in.nextInt();
            if(n == 0)
                break;
            int[][] tab = new int[n+1][n+1];
            int i,j;
            int[] row = new int[n+1];
            int[] col = new int[n+1];
            boolean flag = true;
            int cntr = 0;
            int cntl = 0;
            int r1 = 0,l1 = 0;
            for(i = 1; i <= n; i++) {
                for(j = 1; j <= n; j++) {
                    tab[i][j] = in.nextInt(); 
                    row[i] += tab[i][j];
                }
                if(row[i]%2 != 0) {
                    flag = false;
                    cntr++;
                    r1 = i;
                }
            }
            if(cntr > 1) {
                System.out.println("Corrupt");
                continue;
            }
            for(i = 1; i <= n; i++) {
                for(j = 1; j <= n ; j++) {
                    col[i] += tab[j][i];
                }
                if(col[i] %2 != 0) {
                    flag = false;
                    cntl++;
                    l1 = i;
                }
            }
            if(flag) {
                System.out.println("OK");
                continue;
            }
            else if(cntl > 1) {
                System.out.println("Corrupt");
                continue;
            }
            else {
                System.out.printf("Change bit (%d,%d)\n",r1,l1);
            }
            
        }
    }
}
