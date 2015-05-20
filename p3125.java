
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
Printer Queue
Time Limit: 1000MS		Memory Limit: 65536K
Total Submissions: 3201		Accepted: 1734
Description

The only printer in the computer science students' union is experiencing an extremely heavy workload. Sometimes there are a hundred jobs in the printer queue and you may have to wait for hours to get a single page of output. 

Because some jobs are more important than others, the Hacker General has invented and implemented a simple priority system for the print job queue. Now, each job is assigned a priority between 1 and 9 (with 9 being the highest priority, 
and 1 being the lowest), and the printer operates as follows.
The first job J in queue is taken from the queue.
If there is some job in the queue with a higher priority than job J, thenmove J to the end of the queue without printing it.
Otherwise, print job J (and do not put it back in the queue).
In this way, all those importantmuffin recipes that the Hacker General is printing get printed very quickly. Of course, those annoying term papers that others are printing may have to wait for quite some time to get printed, but that's life. 

Your problem with the new policy is that it has become quite tricky to determine when your print job will actually be completed. You decide to write a program to figure this out. The program will be given the current queue (as a list of priorities) as well as the position of your job in the queue, and must then calculate how long it will take until your job is printed, assuming that no additional jobs will be added to the queue. To simplifymatters, we assume that printing a job always takes exactly one minute, and that adding and removing jobs from the queue is instantaneous.
Input

One line with a positive integer: the number of test cases (at most 100). Then for each test case:
One line with two integers n and m, where n is the number of jobs in the queue (1 ≤ n ≤ 100) and m is the position of your job (0 ≤ m ≤ n −1). The first position in the queue is number 0, the second is number 1, and so on.
One linewith n integers in the range 1 to 9, giving the priorities of the jobs in the queue. The first integer gives the priority of the first job, the second integer the priority of the second job, and so on.

Output

For each test case, print one line with a single integer; the number of minutes until your job is completely printed, assuming that no additional print jobs will arrive.
Sample Input

3
1 0
5
4 2
1 2 3 4
6 0
1 1 9 1 1 1
Sample Output

1
2
5
Source

Northwestern Europe 2006
 */
public class p3125 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        for(int i = 0; i < N ; i++) {
            int n = in.nextInt();
            int m = in.nextInt();
            int[] priority = new int[n];
            
        }
    }
}
