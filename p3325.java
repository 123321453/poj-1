
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
ICPC Score Totalizer Software
Time Limit: 2000MS		Memory Limit: 65536K
Total Submissions: 6403		Accepted: 4447
Description

The International Clown and Pierrot Competition (ICPC), is one of the most distinguished and also the most popular events on earth in the show business.
One of the unique features of this contest is the great number of judges that sometimes counts up to one hundred. The number of judges may differ from one contestant to another, because judges with any relationship whatsoever with a specific contestant are temporarily excluded for scoring his/her performance.

Basically, scores given to a contestant's performance by the judges are averaged to decide his/her score. To avoid letting judges with eccentric viewpoints too much influence the score, the highest and the lowest scores are set aside in this calculation. If the same highest score is marked by two or more judges, only one of them is ignored. The same is with the lowest score. The average, which may contain fractions, are truncated down to obtain final score as an integer.

You are asked to write a program that computes the scores of performances, given the scores of all the judges, to speed up the event to be suited for a TV program.

Input

The input consists of a number of datasets, each corresponding to a contestant's performance. There are no more than 20 datasets in the input.

A dataset begins with a line with an integer n, the number of judges participated in scoring the performance (3 ≤ n ≤ 100). Each of the n lines following it has an integral score s (0 ≤ s ≤ 1000) marked by a judge. No other characters except for digits to express these numbers are in the input. Judges' names are kept secret.

The end of the input is indicated by a line with a single zero in it.

Output

For each dataset, a line containing a single decimal integer indicating the score for the corresponding performance should be output. No other characters should be on the output line.

Sample Input

3
1000
342
0
5
2
2
9
11
932
5
300
1000
0
200
400
8
353
242
402
274
283
132
402
523
0
Sample Output

342
7
300
326
Source

Japan 2007 Domestic
 */
public class p3325 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            int n = in.nextInt();
            if(n == 0)
                break;
            int[] judge = new int[n];
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            int result = 0;
            for(int i = 0; i < n;i++) {
                judge[i] = in.nextInt();
                result += judge[i];
                if(judge[i] > max) {
                    max = judge[i];
                }
                if(judge[i] < min) {
                    min = judge[i];
                }
            }
            result -= (max+min);
            int avg = result/(n-2);
            System.out.println(avg);
        }
    }
}
