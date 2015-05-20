
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
Brainman
Time Limit: 1000MS		Memory Limit: 30000K
Total Submissions: 7471		Accepted: 4082
Description

Background 
Raymond Babbitt drives his brother Charlie mad. Recently Raymond counted 246 toothpicks spilled all over the floor in an instant just by glancing at them. And he can even count Poker cards. Charlie would love to be able to do cool things like that, too. He wants to beat his brother in a similar task. 

Problem 
Here's what Charlie thinks of. Imagine you get a sequence of N numbers. The goal is to move the numbers around so that at the end the sequence is ordered. The only operation allowed is to swap two adjacent numbers. Let us try an example: 
Start with: 2 8 0 3 
swap (2 8) 8 2 0 3 
swap (2 0) 8 0 2 3 
swap (2 3) 8 0 3 2 
swap (8 0) 0 8 3 2 
swap (8 3) 0 3 8 2 
swap (8 2) 0 3 2 8 
swap (3 2) 0 2 3 8 
swap (3 8) 0 2 8 3 
swap (8 3) 0 2 3 8

So the sequence (2 8 0 3) can be sorted with nine swaps of adjacent numbers. However, it is even possible to sort it with three such swaps: 
Start with: 2 8 0 3 
swap (8 0) 2 0 8 3 
swap (2 0) 0 2 8 3 
swap (8 3) 0 2 3 8

The question is: What is the minimum number of swaps of adjacent numbers to sort a given sequence?Since Charlie does not have Raymond's mental capabilities, he decides to cheat. Here is where you come into play. He asks you to write a computer program for him that answers the question. Rest assured he will pay a very good prize for it.
Input

The first line contains the number of scenarios. 
For every scenario, you are given a line containing first the length N (1 <= N <= 1000) of the sequence,followed by the N elements of the sequence (each element is an integer in [-1000000, 1000000]). All numbers in this line are separated by single blanks.
Output

Start the output for every scenario with a line containing "Scenario #i:", where i is the number of the scenario starting at 1. Then print a single line containing the minimal number of swaps of adjacent numbers that are necessary to sort the given sequence. Terminate the output for the scenario with a blank line.
Sample Input

4
4 2 8 0 3
10 0 1 2 3 4 5 6 7 8 9
6 -42 23 6 28 -100 65537
5 0 0 0 0 0
Sample Output

Scenario #1:
3

Scenario #2:
0

Scenario #3:
5

Scenario #4:
0
Source

TUD Programming Contest 2003, Darmstadt, Germany
 */
public class p1804 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        for(int i = 1; i <= N; i++) {
            int num = in.nextInt();
            int[] tab = new int[num];
            for(int j = 0; j < num; j++) {
                tab[j] = in.nextInt();               
            }
            int cnt = 0;
            int temp = 0;
            for(int k = 0; k < num; k++) {
                for(int j = num-1; j > k; j--) {
                    if(tab[j] < tab[j-1]) {
                        cnt++;
                        temp = tab[j];
                        tab[j] = tab[j-1];
                        tab[j-1] = temp;
                             
                    }
                }
            }
            System.out.printf("Scenario #%d:\n",i);
            System.out.println(cnt);
            System.out.println();
        }
    }
}
