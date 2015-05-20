
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
A Contesting Decision
Time Limit: 1000MS		Memory Limit: 10000K
Total Submissions: 2069		Accepted: 1511
Description

Judging a programming contest is hard work, with demanding contestants, tedious decisions,and monotonous work. Not to mention the nutritional problems of spending 12 hours with only donuts, pizza, and soda for food. Still, it can be a lot of fun. 
Software that automates the judging process is a great help, but the notorious unreliability of some contest software makes people wish that something better were available. You are part of a group trying to develop better, open source, contest management software, based on the principle of modular design. 
Your component is to be used for calculating the scores of programming contest teams and determining a winner. You will be given the results from several teams and must determine the winner. 
Scoring 
There are two components to a team's score. The first is the number of problems solved. The second is penalty points, which reflects the amount of time and incorrect submissions made before the problem is solved. For each problem solved correctly, penalty points are charged equal to the time at which the problem was solved plus 20 minutes for each incorrect submission. No penalty points are added for problems that are never solved. 
So if a team solved problem one on their second submission at twenty minutes, they are charged 40 penalty points. If they submit problem 2 three times, but do not solve it, they are charged no penalty points. If they submit problem 3 once and solve it at 120 minutes, they are charged 120 penalty points. Their total score is two problems solved with 160 penalty points. 
The winner is the team that solves the most problems. If teams tie for solving the most problems,then the winner is the team with the fewest penalty points.
Input

For the programming contest your program is judging, there are four problems. You are guaranteed that the input will not result in a tie between teams after counting penalty points. 
Line 1 < nTeams > 
Line 2 - n+1 < Name > < p1Sub > < p1Time > < p2Sub > < p2Time > ... < p4Time > 
The first element on the line is the team name, which contains no whitespace.Following that, for each of the four problems, is the number of times the team submitted a run for that problem and the time at which it was solved correctly (both integers). If a team did not solve a problem, the time will be zero. The number of submissions will be at least one if the problem was solved.
Output

The output consists of a single line listing the name of the team that won, the number of problems they solved, and their penalty points.
Sample Input

4
Stars 2 20 5 0 4 190 3 220
Rockets 5 180 1 0 2 0 3 100
Penguins 1 15 3 120 1 300 4 0
Marsupials 9 0 3 100 2 220 3 80
Sample Output

Penguins 3 475
Source

Mid-Atlantic 2003
 */
public class p1581 {
    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        int n = in.nextInt();
        String[] name = new String[n];
        int[] p1Sub = new int[n];
        int[] p2Sub = new int[n];
        int[] p3Sub = new int[n];
        int[] p4Sub = new int[n];
        int[] p1Time =  new int[n];
        int[] p2Time = new int[n];
        int[] p3Time = new int[n];
        int[] p4Time = new int[n];
        int[] penalty = new int[n];
        int[] correS = new int[n];
        int maxIn = -1;
        int maxS = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            name[i] = in.next();
            p1Sub[i] = in.nextInt();
            p1Time[i] = in.nextInt();
            p2Sub[i] = in.nextInt();
            p2Time[i] = in.nextInt();
            p3Sub[i] = in.nextInt();
            p3Time[i] = in.nextInt();
            p4Sub[i] = in.nextInt();
            p4Time[i] = in.nextInt();
            if (p1Sub[i] >= 1) {
                if (p1Time[i] != 0 && p1Sub[i] > 1) {
                    penalty[i] += p1Time[i] + 20 * (p1Sub[i] - 1);
                    correS[i]++;
                }
                if (p1Time[i] != 0 && p1Sub[i] == 1) {
                    penalty[i] += p1Time[i];
                    correS[i]++;
                }
            }
            if (p2Sub[i] >= 1) {
                if (p2Time[i] != 0 && p2Sub[i] > 1) {
                    penalty[i] += p2Time[i] + 20 * (p2Sub[i] - 1);
                    correS[i]++;
                }
                if (p2Time[i] != 0 && p2Sub[i] == 1) {
                    penalty[i] += p2Time[i];
                    correS[i]++;
                }
            }
            if (p3Sub[i] >= 1) {
                if (p3Time[i] != 0 && p3Sub[i] > 1) {
                    penalty[i] += p3Time[i] + 20 * (p3Sub[i] - 1);
                    correS[i]++;
                }
                if (p3Time[i] != 0 && p3Sub[i] == 1) {
                    penalty[i] += p3Time[i];
                    correS[i]++;
                }
            }
            if (p4Sub[i] >= 1) {
                if (p4Time[i] != 0 && p4Sub[i] > 1) {
                    penalty[i] += p4Time[i] + 20 * (p4Sub[i] - 1);
                    correS[i]++;
                }
                if (p4Time[i] != 0 && p4Sub[i] == 1) {
                    penalty[i] += p4Time[i];
                    correS[i]++;
                }
            }
            if(maxS <= correS[i]) {
                if(maxS < correS[i]) {
                    maxIn = i;
                    maxS = correS[i];
                }
                if(maxS == correS[i]) {
                    if(penalty[maxIn] > penalty[i]) {
                        maxIn = i;
                    }
                }
            }
            
        }
        System.out.println(name[maxIn]+" "+correS[maxIn]+" "+penalty[maxIn]);
      //  for(int i = 0; i < n; i++) {
       //     System.out.println(name[i]+" "+correS[i]+" "+penalty[i]);
        //}
    }
}
