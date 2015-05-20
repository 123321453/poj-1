
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
The Suspects
Time Limit: 1000MS		Memory Limit: 20000K
Total Submissions: 16573		Accepted: 7967
Description

Severe acute respiratory syndrome (SARS), an atypical pneumonia of unknown aetiology, was recognized as a global threat in mid-March 2003. To minimize transmission to others, the best strategy is to separate the suspects from others. 
In the Not-Spreading-Your-Sickness University (NSYSU), there are many student groups. Students in the same group intercommunicate with each other frequently, and a student may join several groups. To prevent the possible transmissions of SARS, the NSYSU collects the member lists of all student groups, and makes the following rule in their standard operation procedure (SOP). 
Once a member in a group is a suspect, all members in the group are suspects. 
However, they find that it is not easy to identify all the suspects when a student is recognized as a suspect. Your job is to write a program which finds all the suspects.
Input

The input file contains several cases. Each test case begins with two integers n and m in a line, where n is the number of students, and m is the number of groups. You may assume that 0 < n <= 30000 and 0 <= m <= 500. Every student is numbered by a unique integer between 0 and n−1, and initially student 0 is recognized as a suspect in all the cases. This line is followed by m member lists of the groups, one line per group. Each line begins with an integer k by itself representing the number of members in the group. Following the number of members, there are k integers representing the students in this group. All the integers in a line are separated by at least one space. 
A case with n = 0 and m = 0 indicates the end of the input, and need not be processed.
Output

For each case, output the number of suspects in one line.
Sample Input

100 4
2 1 2
5 10 13 11 12 14
2 0 1
2 99 2
200 2
1 5
5 1 2 3 4 5
1 0
0 0
Sample Output

4
1
1
Source

Asia Kaohsiung 2003
 */
public class p1611 {
    private static int[] p;
    private static int[] rank;
    //private static int cnt;
    public static void init(int N) {
        p = new int[N+1];
        rank = new int[N+1];
        for(int i = 0 ; i < N; i++) {
            p[i] = i;
            rank[i] = 1;
        }
    }
    public static int findP(int i) {
        if(i == p[i])
            return i;
        if(p[i] != i)
            p[i] = findP(p[i]);
        return p[i];
    }
    
    public static void union(int x , int y) {
        if(x == y)
            return;
        boolean flag = false;
      //  if(x == 0 || y == 0)
       //     flag = true;
        int pX = findP(x);
        int pY = findP(y);
        if(pX == pY) {
         //   if(flag)
           //     cnt += rank[pX];
            return;
        }
        else {
            if(rank[pX] > rank[pY]) {
                p[pY] = pX;
                rank[pX] += rank[pY];
             //   if(flag)
               //     cnt += rank[pX];
            }
            else {
                p[pX] = pY;
                rank[pY] += rank[pX];
                //if(flag)
                  //  cnt += rank[pY];
            }
            return;
        }
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            int n = in.nextInt();
            int m = in.nextInt();
            if(n == 0 && m == 0)
                break;
            init(n);
           // cnt = 1;
            for(int i = 0 ; i < m ; i++) {
                int prev = -1;
                int cur = -1;
                int k = in.nextInt();
                for(int j = 0; j < k ; j++) {
                    int x = in.nextInt();
                    cur = x;
                    if(prev == -1) 
                        prev = x;
                    else {
                        union(cur,prev);
                        prev = cur;
                    }
                }
            }
            System.out.println(rank[findP(0)]);
        }
    }
}