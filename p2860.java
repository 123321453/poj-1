
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
Block game with the Little Prince
Time Limit: 1000MS		Memory Limit: 65536K
Total Submissions: 1758		Accepted: 1187
Description

The Little Prince, who lives in the B-615 planet, sometimes enjoys a game to pile up blocks. He has N identical blocks and a box with K rooms for M blocks at most. That is, he can pile up M blocks, at most, into one of the K rooms, but can't more than M blocks. For example, if N = 3, K = 3, M = 2, there are seven ways to pile up all blocks: 




Given two states of blocks, He wants to know how many times he should move blocks one by one, to change the initial state into the final state. For instance, he can choose one block from any of 3 rooms (A, B, C), and then move it into another room. Of course, he cannot put more than M blocks at the room.

Input

First line has three positives integers, N (1 ≤ N ≤ 30), M (1 ≤ M ≤ 4), and K (1 ≤ K ≤ 10). Each of next K lines contains the number of blocks piled at the room. This represents the initial state. Likely, another K lines are given, and this indicates the final state that the Little Prince want to make. Input is always valid.

Output

Output the minimal number of moves necessary to make the final state.

Sample Input

3 2 3
1
1
1
2
0
1
Sample Output

1
Source

Hooyeon Lee (ltdtl@POJ)
 */
public class p2860 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        int K = in.nextInt();
        int[] init = new int[K];
        int[] fin = new int[K];
        for(int i = 0; i < K ; i++) {
            init[i] = in.nextInt();
        }
        for(int i = 0; i < K ; i++) {
            fin[i] = in.nextInt();
        }
        int cnt = 0;
        for(int i = 0; i < K ; i++) {
            if(fin[i] > init[i])
                cnt += (fin[i] - init[i]);
        }
        System.out.println(cnt);
    }
}
