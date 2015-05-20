
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
Ubiquitous Religions
Time Limit: 5000MS		Memory Limit: 65536K
Total Submissions: 18593		Accepted: 9117
Description

There are so many different religions in the world today that it is difficult to keep track of them all. You are interested in finding out how many different religions students in your university believe in. 

You know that there are n students in your university (0 < n <= 50000). It is infeasible for you to ask every student their religious beliefs. Furthermore, many students are not comfortable expressing their beliefs. One way to avoid these problems is to ask m (0 <= m <= n(n-1)/2) pairs of students and ask them whether they believe in the same religion (e.g. they may know if they both attend the same church). From this data, you may not know what each person believes in, but you can get an idea of the upper bound of how many different religions can be possibly represented on campus. You may assume that each student subscribes to at most one religion.
Input

The input consists of a number of cases. Each case starts with a line specifying the integers n and m. The next m lines each consists of two integers i and j, specifying that students i and j believe in the same religion. The students are numbered 1 to n. The end of input is specified by a line in which n = m = 0.
Output

For each test case, print on a single line the case number (starting with 1) followed by the maximum number of different religions that the students in the university believe in.
Sample Input

10 9
1 2
1 3
1 4
1 5
1 6
1 7
1 8
1 9
1 10
10 4
2 3
4 5
4 8
5 8
0 0
Sample Output

Case 1: 1
Case 2: 7
Hint

Huge input, scanf is recommended.
Source

Alberta Collegiate Programming Contest 2003.10.18
 */
public class p2524 {
    private static int result;
    private static int[] p;
    private static int[] rank;
    private static void init(int N) {
        p = new int[N+1];
        rank = new int[N+1];
        for(int i = 1; i <= N; i++) {
            p[i] = i;
            rank[i] = 0;
        }
    }
    
    public static int findP(int x) {
        if(p[x] == x)
            return x;
        p[x] = findP(p[x]);
        return p[x];
    }
    
    public static void union(int x, int y) {
        if(x == y)
            return;
        else {
            int pX = findP(x);
            int pY = findP(y);
            if(pX == pY)
                return;
            if(rank[pX] > rank[pY]) {
                p[pY] = pX;
                rank[pX]++;
            }
            else {
                p[pX] = pY;
                rank[pY]++;
            }
            result--;
        }
    }
    
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int j = 1;
        while(in.hasNext()) {
            int n = in.nextInt();
            int m = in.nextInt();
            init(n);
            if(n == 0 && m== 0)
                break;
            result = n;
            //int j = 1;
            for(int i = 1; i <= m ; i++) {
                int x = in.nextInt();
                int y = in.nextInt();
                union(x,y);
            }
            System.out.printf("Case %d: %d\n", j++,result);
            
        }
    }
}
