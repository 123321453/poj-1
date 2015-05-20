
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
K-th Number
Time Limit: 20000MS		Memory Limit: 65536K
Total Submissions: 29204		Accepted: 8830
Case Time Limit: 2000MS
Description

You are working for Macrohard company in data structures department. After failing your previous task about key insertion you were asked to write a new data structure that would be able to return quickly k-th order statistics in the array segment. 
That is, given an array a[1...n] of different integer numbers, your program must answer a series of questions Q(i, j, k) in the form: "What would be the k-th number in a[i...j] segment, if this segment was sorted?" 
For example, consider the array a = (1, 5, 2, 6, 3, 7, 4). Let the question be Q(2, 5, 3). The segment a[2...5] is (5, 2, 6, 3). If we sort this segment, we get (2, 3, 5, 6), the third number is 5, and therefore the answer to the question is 5.
Input

The first line of the input file contains n --- the size of the array, and m --- the number of questions to answer (1 <= n <= 100 000, 1 <= m <= 5 000). 
The second line contains n different integer numbers not exceeding 109 by their absolute values --- the array for which the answers should be given. 
The following m lines contain question descriptions, each description consists of three numbers: i, j, and k (1 <= i <= j <= n, 1 <= k <= j - i + 1) and represents the question Q(i, j, k).
Output

For each question output the answer to it --- the k-th number in sorted a[i...j] segment.
Sample Input

7 3
1 5 2 6 3 7 4
2 5 3
4 4 1
1 7 3
Sample Output

5
6
3
Hint

This problem has huge input,so please use c-style input(scanf,printf),or you may got time limit exceed.
 */
public class p2104 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] ini = in.nextLine().split("\\s+");
        int n = Integer.parseInt(ini[0]);
        int m = Integer.parseInt(ini[1]);
        String[] arr = in.nextLine().split("\\s+");
        for(int t = 0; t < m; t++) {
            String[] tmp = in.nextLine().split("\\s+");
            int i = Integer.parseInt(tmp[0]);
            int j = Integer.parseInt(tmp[1]);
            int k = Integer.parseInt(tmp[2]);
           // System.out.println("DE: "+ i+" "+j+" "+k);
            ArrayList<Integer> list = new ArrayList<Integer>(j-i+1);
            for(int p = 0 ; p < (j-i+1); p++){
                list.add(Integer.parseInt(arr[i+p-1]));
            }
            Collections.sort(list);
            System.out.println(list.get(k-1));
        }
        
    }
}
