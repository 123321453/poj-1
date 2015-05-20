
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
Colour Sequence
Time Limit: 1000MS		Memory Limit: 65536K
Total Submissions: 997		Accepted: 617
Description

We have a pile of cards consisting of 100 cards that are coloured on both sides. There is a finite number of colours (at most 26). In addition there are special cards called jokers. Jokers have a joker sign on both sides, which can assume any of the possible colours. We consider here a one-player card game, in which the player is challenged to derive a given colour sequence from a given row of cards, following certain rules.

Before the actual beginning of the game a colour sequence S of length at most 100 (not containing a joker) is given. Furthermore a number of cards are chosen from the pile and are put in a row. The sides turned upwards form a row of colours. Now the aim for the player is to create the colour sequence S with the cards from the row in the following way. For each card in the row the player decides whether or not to turn it over. When the card is turned over, only the colour on the other side is visible. Jokers may be part of the row of cards.

These steps lead to the final sequence of colours formed by the visible side of the cards in the row. If the player has been able to turn the cards in such a way that the pre-given colour sequence S is contained (from left to right) in the final row of colours, the player wins. If not, he loses. In matching the pre-given colour sequence to the row, cards in the row may be skipped, as long as the relative order of the colours is preserved. A joker can assume any colour. For example, the colour sequence (red, blue, yellow) is contained in (green, joker, blue, red, yellow), and (blue, green, blue, green) is contained in (red, blue, joker, yellow, joker, blue, green, green).

Your job is to find out if the player can win, given the colour sequence S and the row of cards chosen from the pile. This means that the sequence of colours that are face up is known, and so are the colours on the other side of these cards.

Input

The first line of the input file contains a single number: the number of test cases to follow. Each test case has the following format:

One line describing the colour sequence S. This line contains a string of m (with 1 ≤ m ≤ 100) characters from the set {'A', 'B', …, 'Z'}, denoting the colours. Different colours correspond to different characters. For example: "BGBG" denotes the sequence blue, green, blue, green.

Two lines, corresponding to the row of cards chosen from the pile. Each of these lines contains a string of k (1 ≤ k ≤ 100) characters from the set {'A', 'B', …, 'Z', '*'}. The character '*' denotes a joker, which can play the role of any of the possible colours.

The string in the first line corresponds to the row of colours on the visible side of the cards. The string in the second line corresponds to the row of colours on the hidden side of the cards.
So for the ith card in the row, the first line gives the colour of the side turned upwards and the second line shows the colour of the side face down. Obviously the strings on both lines have the same length. Furthermore, a '*' in one line (denoting a joker) always corresponds to a '*' in the other line at the corresponding position.

Output

For every test case in the input file, the output should contain one line. This line contains "win" if the colour sequence S can be achieved by the player by turning the right cards upside down, and "lose" if this is not the case.

Sample Input

3
RBY
B*RRB
G*BRY
BGBG
RZ*Y*PGG
AB*Y*BCB
BAPC
BUBCDAPVDAVVDLPF
VLDCUSPGLSGPPVDD
Sample Output

win
win
lose
Source

BAPC 2006 Qualification
 */
public class p3458 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        for(int i = 0; i < N ; i++) {
            String S = in.next();
            String front = in.next();
            String back = in.next();
            boolean[] flag = new boolean[S.length()];
            boolean win = true;
            int start = 0;
            //System.out.println(flag[S.length()-1]);
            for(int j = 0; j < S.length(); j++) {
                char c = S.charAt(j);
                for(int k = start; k < front.length(); k++) {
                    char ft = front.charAt(k);
                    char bk = back.charAt(k);
                    if(ft == '*' || bk == '*') {
                        flag[j] = true;
                        start = k+1;
                        break;
                    }
                    else if(ft == c || bk == c) {
                        flag[j] = true;
                        //System.out.println("test: "+c);
                        start = k+1;
                        break;
                    }
                    else 
                        continue;
                }
                if(flag[j] == false) {
                    win = false;
                    break;
                }
            }
            if(win) {
                System.out.println("win");
            }
            else {
                System.out.println("lose");
            }
        }
    }
}
