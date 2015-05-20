
import java.util.HashMap;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
A Simple Poker Game
Time Limit: 1000MS		Memory Limit: 65536K
Total Submissions: 1372		Accepted: 660
Description

A software company wants to write a program to play a simple poker game. In the game, a player is given a hand, namely 5 distinct poker cards, from a deck of 52 distinct cards. A deck of 52 cards consists of 4suits of 13 cards each, coded and sequenced as A, 2, 3, 4, 5, 6, 7, 8, 9, X,J, Q, and K. The 4 suits are club (C), heart (H), spade (S), and diamond(D). 

You tasks is to write a program to determine the points of a hand of 5cards using the following scoring rules: 
Straight flush: 1000 points five cards of the same suit in sequence, such as 76543 of hearts. Note that AKQJX is treated as a valid sequence. 
Four of a kind: 750 points four cards of the same rank accompanied by a "kicker", like 44442. 
Full house: 500 points three cards of one rank accompanied by two of another, such as 777JJ. 
Flush: 350 points five cards of the same suit, such as AJ942 of hearts. 
Straight: 250 points five cards in sequence, such as 76543. Note that AKQJX is treated as a valid sequence. 
Three of a kind: 200 points three cards of the same rank and two kickers of different ranks, such as KKK84. 
Two pairs: 100 points two cards of one rank, two cards of another rank and a kicker of a third rank, such as KK449. 
One pair: 50 points two cards of one rank accompanied by three kickers of different ranks, such as AAK53. 
None of the above: O point any hand that does not qualify as one of the better hands above, such as KJ542 of mixed suits.

Note that if a hand satisfies two or more rules above, then we only apply the rule that wins the largest amount of points. For example, a "full house" consists of a "three of a kind" and a "one pair." You need to give 
the score for "full house" only (i.e., 500 points), and nothing else.
Input

The first line contains the number of hands w, w <= 100. Then the w hands are listed one by one. Note that each hand comes from a complete deck of52 cards. Each hand is listed in one line with 5 cards. Each card consists of two upper case letters. The first letter is its suit, and the second letter is its rank. There is a blank between two cards. The cards in one hand are not sorted at all.
Output

For each hand, output its points in one line.
Sample Input

3
C3 D4 D5 S3 CX
CA C5 D4 D3 S2
HA HJ HX HQ HK
Sample Output

50
250
1000
Source

Taiwan 2004
 */
public class p2694 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i = 0 ; i < n ; i++) {
            String[] tab = new String[5];
            char[][] card = new char[5][2];
            HashMap<Character,Integer> suit = new HashMap();
            int[] deck = new int[15];
            for(int j = 0; j < 5; j++) {
                tab[j] = in.next();
                card[j] = tab[j].toCharArray();
                if(!suit.containsKey(card[j][0])) {
                    suit.put(card[j][0], 1);
                }
                else {
                    suit.put(card[j][0], suit.get(card[j][0])+1);
                }
                if(card[j][1] >= '2' && card[j][1] <= '9') {
                    deck[card[j][1] - '0']++;
                }
                else if(card[j][1] == 'X') {
                    deck[10]++;
                }
                else if(card[j][1] == 'J') {
                    deck[11]++;
                }
                else if(card[j][1] == 'Q') {
                    deck[12]++;
                }
                else if(card[j][1] == 'A') {
                    deck[1] ++;
                    //deck[14]++;
                }
                else if(card[j][1] == 'K') {
                    deck[13]++;
                }
                else {
                    
                }
            }
            int ptr = 0;
            boolean StrF = false;
            boolean fourK = false;
            boolean full = false;
            boolean flush = false;
            boolean Strait = false;
            boolean threeK = false;
            boolean twoP = false;
            boolean oneP = false;
            
            if(suit.get('C') == 5 || suit.get('H') == 5 || suit.get('S') == 5 || suit.get('D') == 5) {
                int prev = -1;
                for(int j = 1; j <= 13; j++) {
                    if(j == 1) {
                        if(deck[j] == 1) {
                            boolean tmp = true;
                            for(int k = 2; k <= 5; k++) {
                                if(deck[k] != 1) {
                                    tmp = false;
                                    break;
                                }
                            }
                            if(tmp) {
                                System.out.println(1000);
                                StrF = true;
                                break;
                            }
                            for(int k = 13; k >= 10; k--) {
                                if(deck[k] != 1) {
                                    tmp = false;
                                    break;
                                }
                            }
                            if(tmp) {
                                System.out.println(1000);
                                StrF = true;
                                break;
                            }
                            else {
                                System.out.println(350);
                                flush = true;
                                break;
                            }
                        }
                    }
                    else {
                        
                    }
                }
            }
            
            
            
        }
    }
}
