
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
Oil Deposits
Time Limit: 1000MS		Memory Limit: 10000K
Total Submissions: 10009		Accepted: 5455
Description

The GeoSurvComp geologic survey company is responsible for detecting underground oil deposits. GeoSurvComp works with one large rectangular region of land at a time, and creates a grid that divides the land into numerous square plots. It then analyzes each plot separately, using sensing equipment to determine whether or not the plot contains oil. A plot containing oil is called a pocket. If two pockets are adjacent, then they are part of the same oil deposit. Oil deposits can be quite large and may contain numerous pockets. Your job is to determine how many different oil deposits are contained in a grid.
Input

The input contains one or more grids. Each grid begins with a line containing m and n, the number of rows and columns in the grid, separated by a single space. If m = 0 it signals the end of the input; otherwise 1 <= m <= 100 and 1 <= n <= 100. Following this are m lines of n characters each (not counting the end-of-line characters). Each character corresponds to one plot, and is either `*', representing the absence of oil, or `@', representing an oil pocket. 

Output

are adjacent horizontally, vertically, or diagonally. An oil deposit will not contain more than 100 pockets.
Sample Input

1 1
*
3 5
*@*@*
**@**
*@*@*
1 8
@@****@*
5 5 
****@
*@@*@
*@**@
@@@*@
@@**@
0 0
Sample Output

0
1
2
2
Source

Mid-Central USA 1997
 */
public class p1562 {
    private static char[][] tab;
    private static int N;
    private static int M;
    public static void dfs(int x, int y) {
        tab[x][y] = '*';
        for(int i = x-1; i <= x+1 ; i++) {
            for(int j = y-1; j <= y+1 ; j++) {
                if(i >= 0 && i < N && j >= 0 && j < M && tab[i][j] == '@') {
                    dfs(i,j);
                }
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            String[] tmp = in.nextLine().split("\\s+");
            N = Integer.valueOf(tmp[0]);
            M = Integer.valueOf(tmp[1]);
            tab = new char[N][M];
            if(N == 0 && M == 0)
                break;
            int i, j;
            for (i = 0; i < N; i++) {
                char[] tmp1 = in.nextLine().toCharArray();
                // System.out.println(tmp.length);
                for (j = 0; j < tmp1.length; j++) {
                    tab[i][j] = tmp1[j];

                }
            }
            int sum = 0;
            for(i = 0 ; i < N ;i++) {
                for(j = 0; j < M ; j++) {
                    if(tab[i][j] == '@') {
                        dfs(i,j);
                        sum++;
                    }
                }
            }
            System.out.println(sum);
            
        }
    }
}
