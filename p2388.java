
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
Who's in the Middle
Time Limit: 1000MS		Memory Limit: 65536K
Total Submissions: 24681		Accepted: 14203
Description

FJ is surveying his herd to find the most average cow. He wants to know how much milk this 'median' cow gives: half of the cows give as much or more than the median; half give as much or less. 

Given an odd number of cows N (1 <= N < 10,000) and their milk output (1..1,000,000), find the median amount of milk given such that at least half the cows give the same amount of milk or more and at least half give the same or less.
Input

* Line 1: A single integer N 

* Lines 2..N+1: Each line contains a single integer that is the milk output of one cow.
Output

* Line 1: A single integer that is the median milk output.
Sample Input

5
2
4
1
3
5
Sample Output

3
* //know how to use qsort/how to write qsort in Java
 */
public class p2388 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        List<Integer> tab = new ArrayList<Integer>();
        for(int i = 0; i < N ; i++){
            tab.add(in.nextInt());
        }
        Collections.sort(tab);
        System.out.println(tab.get(N/2));
    }
}
