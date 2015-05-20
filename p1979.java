
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
Red and Black
Time Limit: 1000MS		Memory Limit: 30000K
Total Submissions: 18156		Accepted: 9620
Description

There is a rectangular room, covered with square tiles. Each tile is colored either red or black. A man is standing on a black tile. From a tile, he can move to one of four adjacent tiles. But he can't move on red tiles, he can move only on black tiles. 

Write a program to count the number of black tiles which he can reach by repeating the moves described above. 
Input

The input consists of multiple data sets. A data set starts with a line containing two positive integers W and H; W and H are the numbers of tiles in the x- and y- directions, respectively. W and H are not more than 20. 

There are H more lines in the data set, each of which includes W characters. Each character represents the color of a tile as follows. 

'.' - a black tile 
'#' - a red tile 
'@' - a man on a black tile(appears exactly once in a data set) 
The end of the input is indicated by a line consisting of two zeros. 
Output

For each data set, your program should output a line which contains the number of tiles he can reach from the initial tile (including itself).
Sample Input

6 9
....#.
.....#
......
......
......
......
......
#@...#
.#..#.
11 9
.#.........
.#.#######.
.#.#.....#.
.#.#.###.#.
.#.#..@#.#.
.#.#####.#.
.#.......#.
.#########.
...........
11 6
..#..#..#..
..#..#..#..
..#..#..###
..#..#..#@.
..#..#..#..
..#..#..#..
7 7
..#.#..
..#.#..
###.###
...@...
###.###
..#.#..
..#.#..
0 0
Sample Output

45
59
6
13
Source

Japan 2004 Domestic
 */
public class p1979 {
    private static char[][] tab;
    private static int W;
    private static int H;
    private static int res;
    private static void dfs(int x, int y) {
       // System.out.println(x+" "+y);
        tab[y][x] = '#';
        for(int dx = -1; dx <= 1; dx++) {
            int nx = x+dx;
            if(nx >= 0 && nx < W ) {
                if(tab[y][nx] == '.') {
                    res++;
                    dfs(nx, y);
                }

            }         
        }
        for(int dy = -1; dy <= 1; dy++) {
            int ny = y + dy;
            if(ny >= 0 && ny < H ) {
                if(tab[ny][x] == '.') {
                    res++;
                    dfs(x, ny);
                }

            }
        }
    }
    public static void main(String[] args){
        Scanner in  = new Scanner(System.in);
        while(in.hasNext()) {
            W = in.nextInt();
            H = in.nextInt();
            if(W == 0 && H == 0) {
                break;
            } 
            tab = new char[H][W];
            int startX = -1;
            int startY = -1;
            for(int i = 0; i < H; i++) {
                String tmp = in.next();
              //  tab[i] = tmp.toCharArray();
                for(int j = 0; j < W; j++) {
                    tab[i][j] = tmp.charAt(j);
                    if(tab[i][j] == '@') {
                        startX = j;
                        startY = i;
                    }
                }
            }
            res = 1;
          //  System.out.println(startX+" "+startY);
            dfs(startX,startY);
            System.out.println(res);
        }
    }
}
