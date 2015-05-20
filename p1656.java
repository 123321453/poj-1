
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
Counting Black
Time Limit: 1000MS		Memory Limit: 10000K
Total Submissions: 9346		Accepted: 6036
Description

There is a board with 100 * 100 grids as shown below. The left-top gird is denoted as (1, 1) and the right-bottom grid is (100, 100). 


We may apply three commands to the board: 

1.	WHITE  x, y, L     // Paint a white square on the board, 

                           // the square is defined by left-top grid (x, y)

                           // and right-bottom grid (x+L-1, y+L-1)



2.	BLACK  x, y, L     // Paint a black square on the board, 

                           // the square is defined by left-top grid (x, y)

                           // and right-bottom grid (x+L-1, y+L-1)



3.	TEST     x, y, L    // Ask for the number of black grids 

                            // in the square (x, y)- (x+L-1, y+L-1) 

In the beginning, all the grids on the board are white. We apply a series of commands to the board. Your task is to write a program to give the numbers of black grids within a required region when a TEST command is applied. 
Input

The first line of the input is an integer t (1 <= t <= 100), representing the number of commands. In each of the following lines, there is a command. Assume all the commands are legal which means that they won't try to paint/test the grids outside the board.
Output

For each TEST command, print a line with the number of black grids in the required region.
Sample Input

5
BLACK 1 1 2
BLACK 2 2 2
TEST 1 1 3
WHITE 2 1 1
TEST 1 1 3
Sample Output

7
6
Source

POJ Monthly--2004.05.15 Liu Rujia@POJ
 */
public class p1656 {
    private static int[][] tab;
    public static void init() {
        tab =  new int[101][101];
        for(int i = 1; i <=100 ; i++) {
            for(int j = 1; j <= 100 ; j++) {
                tab[i][j] = 0; // 0 means white, 1 means black
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner in =  new Scanner(System.in);
        init();
        int num = in.nextInt();
        int j,k;
        for(int i = 0 ; i < num ; i++) {
            String cmd = in.next();
            int x = in.nextInt();
            int y = in.nextInt();
            int L = in.nextInt();
            if(cmd.equals("BLACK")) {
                for(j = x; j <= x+L-1; j++) {
                    for(k = y; k <= y+L-1; k++) {
                        tab[j][k] = 1;
                    }
                }
            }
            if(cmd.equals("WHITE")) {
                for (j = x; j <= x + L - 1; j++) {
                    for (k = y; k <= y + L - 1; k++) {
                        tab[j][k] = 0;
                    }
                }
            }
            if(cmd.equals("TEST")) {
                int cnt = 0;
                for (j = x; j <= x + L - 1; j++) {
                    for (k = y; k <= y + L - 1; k++) {
                        if(tab[j][k] == 1)
                            cnt++;
                    }
                }
                System.out.println(cnt);
            }
        }
    }
}
