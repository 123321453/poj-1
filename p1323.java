
import java.util.Arrays;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
Game Prediction
Time Limit: 1000MS		Memory Limit: 10000K
Total Submissions: 8675		Accepted: 4141
Description

Suppose there are M people, including you, playing a special card game. At the beginning, each player receives N cards. The pip of a card is a positive integer which is at most N*M. And there are no two cards with the same pip. During a round, each player chooses one card to compare with others. The player whose card with the biggest pip wins the round, and then the next round begins. After N rounds, when all the cards of each player have been chosen, the player who has won the most rounds is the winner of the game. 



Given your cards received at the beginning, write a program to tell the maximal number of rounds that you may at least win during the whole game. 
Input

The input consists of several test cases. The first line of each case contains two integers m (2?20) and n (1?50), representing the number of players and the number of cards each player receives at the beginning of the game, respectively. This followed by a line with n positive integers, representing the pips of cards you received at the beginning. Then a blank line follows to separate the cases. 

The input is terminated by a line with two zeros. 
Output

For each test case, output a line consisting of the test case number followed by the number of rounds you will at least win during the game. 

Sample Input

2 5
1 7 2 10 9

6 11
62 63 54 66 65 61 57 56 50 53 48

0 0
Sample Output

Case 1: 2
Case 2: 4
Source

Beijing 2002
 */
public class p1323 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = 1;
        while(in.hasNext()) {
            
            int m = in.nextInt();
            int n = in.nextInt();
            if(m == 0 && n == 0)
                break;
            int[] tab = new int[n];
            int[] visit =  new int[n*m+1];
            for(int i = 0; i < n ; i++) {
                tab[i] = in.nextInt();
                visit[tab[i]] = 1;
            }
            int j = 1;
            int amount = 0;
            int c = n*m;
            Arrays.sort(tab);
            boolean flag = false;
            for(int i = 0; i < n; i++) {
                if(tab[i] == c)
                    continue;
                for (j = tab[i]+1; j <= c ; j++) {
                    flag = false;
                    if (visit[j] != 1 && j > tab[i]) {
                        //amount++;
                        visit[j] = 1;
                        flag = true;
                        j++;
                        break;
                    }
                }
                if(flag)
                    amount++;
            }
            System.out.printf("Case %d: %d\n",t++,n-amount);
        }
    }
}
