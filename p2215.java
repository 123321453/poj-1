
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
Parliament
Time Limit: 1000MS		Memory Limit: 65536K
Total Submissions: 1013		Accepted: 671
Description

The representatives have to spend a lot of time in the Parliament. That is why PSOS want to choose their seats to have the best ones. The special committee was formed to check all the seats and give a score to each of them. The more attractive the seat is, the higher is its score. The score involves the upholstering of chairs, the position of cameras that could take picture of sleeping representative, e.t.c. It was not easy, but finally, after many months, the committee put a score to each seat. Unfortunatelly, it is not possible to take all the best seats. There is also a Security Committee that decided the representatives must sit all together, in a rectangular shape. Moreover, the election is still not over and PSOS do not know how many seats they are going to get. The Party needs a program that will read the score of each seat and then it will be able to determine the total score of any rectangular area. 
Input

At the first line there is a positive integer N stating the number of assignments to follow. Each assignment begins with a line consisting of two integers R and S, separated by space. R is the number of rows in the Parliament, S is the number of seats in every row (all rows are of the same size). It is known that no Parliament can have more than 1000 rows, nor more than 1000 seats in a row. Then R lines follow. Each of them describes one row of the Parliament, in sequence starting with the first one. Each line contains exactly S numbers separated by spaces. These numbers are score values of each seat in the given row, in sequence starting with the first one. The total score of all seats in the Parliament will always fit into the standard int or integer type. 

Then the line containing the single integer number D follows. It is the number of queries. Then D lines follow, each specifying a single query. The query consists of four coordinates separated by spaces, R1, S1, R2, S2 (in that order), 1 <= R1 <= R2 <= R <= 1000, 1 <= S1 <= S2 <= S <= 1000. The coordinates designate that representatives are sitting at the seats forming a rectangle. The seats are in rows from R1 to R2 (including them) and in each of these row the seats from S1 to S2 (including them) are occupied. 
Output

Output a single line for each query. The line must contain the sentence "Absolutni hodnota pohodlnosti je X bodu." (The total score is X points). Fill the total score instead of X. The total score is a sum of score values of each seat occupied by PSOS Party. Print one empty line after each assignment (including the last one). 
Sample Input

2
10 10
1 2 3 4 5 6 7 8 9 10
1 2 3 4 5 6 7 8 9 10
1 2 3 4 5 6 7 8 9 10
1 2 3 4 5 6 7 8 9 10
1 2 3 4 5 6 7 8 9 10
1 2 3 4 5 6 7 8 9 10
1 2 3 4 5 6 7 8 9 10
1 2 3 4 5 6 7 8 9 10
1 2 3 4 5 6 7 8 9 10
1 2 3 4 5 6 7 8 9 10
5
1 1 1 1
2 2 2 2
1 1 10 10
9 9 10 10
2 2 9 9
1 1
1
1
1 1 1 1
Sample Output

Absolutni hodnota pohodlnosti je 1 bodu.
Absolutni hodnota pohodlnosti je 2 bodu.
Absolutni hodnota pohodlnosti je 550 bodu.
Absolutni hodnota pohodlnosti je 38 bodu.
Absolutni hodnota pohodlnosti je 352 bodu.

Absolutni hodnota pohodlnosti je 1 bodu.
Source

CTU FEE Local 1998
 */
public class p2215 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i = 0; i < n ; i++) {
            int r = in.nextInt();
            int s = in.nextInt();
            int[][] tab = new int[r+1][s+1];
            for(int j = 1; j <= r ; j++) {
                for(int k = 1; k <= s ; k++) {
                    tab[j][k] = in.nextInt();
                }
                
            }
            int num = in.nextInt();
            for(int t = 0; t < num; t++) {
                int r1 = in.nextInt();
                int s1 = in.nextInt();
                int r2 = in.nextInt();
                int s2 = in.nextInt();
                int cnt = 0;
                for(int a = r1; a <= r2; a++) {
                    for(int b = s1; b <= s2; b++) {
                        cnt += tab[a][b];
                    }
                }
                System.out.printf("Absolutni hodnota pohodlnosti je %d bodu.\n",cnt);
            }
            System.out.println();
        }
    }
}
