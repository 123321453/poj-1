
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
Robot Motion
Time Limit: 1000MS		Memory Limit: 10000K
Total Submissions: 8350		Accepted: 4058
Description



A robot has been programmed to follow the instructions in its path. Instructions for the next direction the robot is to move are laid down in a grid. The possible instructions are 

N north (up the page) 
S south (down the page) 
E east (to the right on the page) 
W west (to the left on the page) 

For example, suppose the robot starts on the north (top) side of Grid 1 and starts south (down). The path the robot follows is shown. The robot goes through 10 instructions in the grid before leaving the grid. 

Compare what happens in Grid 2: the robot goes through 3 instructions only once, and then starts a loop through 8 instructions, and never exits. 

You are to write a program that determines how long it takes a robot to get out of the grid or how the robot loops around. 
Input

There will be one or more grids for robots to navigate. The data for each is in the following form. On the first line are three integers separated by blanks: the number of rows in the grid, the number of columns in the grid, and the number of the column in which the robot enters from the north. The possible entry columns are numbered starting with one at the left. Then come the rows of the direction instructions. Each grid will have at least one and at most 10 rows and columns of instructions. The lines of instructions contain only the characters N, S, E, or W with no blanks. The end of input is indicated by a row containing 0 0 0.
Output

For each grid in the input there is one line of output. Either the robot follows a certain number of instructions and exits the grid on any one the four sides or else the robot follows the instructions on a certain number of locations once, and then the instructions on some number of locations repeatedly. The sample input below corresponds to the two grids above and illustrates the two forms of output. The word "step" is always immediately followed by "(s)" whether or not the number before it is 1.
Sample Input

3 6 5
NEESWE
WWWESS
SNWWWW
4 5 1
SESWE
EESNW
NWEEN
EWSEN
0 0 0
Sample Output

10 step(s) to exit
3 step(s) before a loop of 8 step(s)
Source

Mid-Central USA 1999
 */
public class p1573 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            int r = in.nextInt();
            int c = in.nextInt();
            int s = in.nextInt();
            if(r == 0 && c == 0 && s == 0)
                break;
            char[][] tab = new char[r][c];
            for(int i = 0; i < r; i++) {
                tab[i] = in.next().toCharArray();
               // System.out.println(tab[i]);
            }
            int[][] visit = new int[r][c];
            int sX = 0;
            int sY = (s-1);
            int step = 0;
            int loopS = 0;
            boolean flag = false;
            while(true) {
                if(sX <0 || sX >= r || sY < 0|| sY >= c) {
                   // System.out.println("test1");
                    flag = true;
                    break;
                }
                else if(visit[sX][sY] == 1 || visit[sX][sY] == 2){
                    if(visit[sX][sY] == 1) {
                        visit[sX][sY]++;
                        loopS++;
                        if (tab[sX][sY] == 'N') {
                            sX -= 1;
                            sY = sY;
                        } else if (tab[sX][sY] == 'S') {
                            sX += 1;
                            sY = sY;
                        } else if (tab[sX][sY] == 'E') {
                            sX = sX;
                            sY += 1;
                        } else {
                            sX = sX;
                            sY -= 1;
                        }
                    }
                    else {
                        break;
                    }
                }
                else {
                    visit[sX][sY]++;
                    step++;
                    if(tab[sX][sY] == 'N') {
                        sX -= 1;
                        sY = sY;
                    }
                    else if(tab[sX][sY] == 'S') {
                        sX += 1;
                        sY = sY;
                    }
                    else if(tab[sX][sY] == 'E') {
                        sX = sX;
                        sY += 1;
                    }
                    else {
                        sX = sX;
                        sY -= 1;
                    }
                }
            }
            if(flag) {
                System.out.printf("%d step(s) to exit\n",step);
            }
            else {
                System.out.printf("%d step(s) before a loop of %d step(s)\n",(step-loopS),loopS);
            }
            
        }
    }
}
