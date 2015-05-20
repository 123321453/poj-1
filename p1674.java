
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
Sorting by Swapping
Time Limit: 1000MS		Memory Limit: 10000K
Total Submissions: 8713		Accepted: 4632
Description

Given a permutation of numbers from 1 to n, we can always get the sequence 1, 2, 3, ..., n by swapping pairs of numbers. For example, if the initial sequence is 2, 3, 5, 4, 1, we can sort them in the following way: 

2 3 5 4 1 
1 3 5 4 2 
1 3 2 4 5 
1 2 3 4 5 

Here three swaps have been used. The problem is, given a specific permutation, how many swaps we needs to take at least. 
Input

The first line contains a single integer t (1 <= t <= 20) that indicates the number of test cases. Then follow the t cases. Each case contains two lines. The first line contains the integer n (1 <= n <= 10000), and the second line gives the initial permutation.
Output

For each test case, the output will be only one integer, which is the least number of swaps needed to get the sequence 1, 2, 3, ..., n from the initial permutation.
Sample Input

2
3
1 2 3
5
2 3 5 4 1
Sample Output

0
3
 */
public class p1674 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        for(int i = 0; i < num ; i++) {
            int N = in.nextInt();
            boolean[] visit = new boolean[N+1];
            int[] tab =  new int[N+1];
            for(int j = 1; j <= N; j++ ) {
                tab[j] = in.nextInt();
                visit[j] = false;
            }
            int result = 0;
            for(int j = 1; j <= N; j++) {
                if(tab[j] == j) {
                   // System.out.println(tab[j]+" "+j+" "+"test");
                    visit[j] = true;
                    continue;
                }
                else {         
                    if(visit[j] == true) {
                      //  System.out.println(tab[j]+" "+j+" "+"test1");
                        continue;
                    }
                    else {
                        int startI = j;
                        int cnt = 0;
                        int tmpI = startI;
                        
                        while(tab[tmpI] != startI && visit[tmpI] != true) {
                            visit[tmpI] = true;
                           // System.out.println(tmpI+"tmpI: "+visit[tmpI]);
                            tmpI = tab[tmpI];
                            cnt++;
                        }
                        visit[tmpI] = true;
                        cnt++;
                       // System.out.println(j+" "+cnt);
                        result += (cnt-1);
                    }
                }
            }
           // for(int k = 1; k <= N; k++)
           //         System.out.println(tab[k] + " " + visit[k]);
            System.out.println(result);
        }
    }
}
