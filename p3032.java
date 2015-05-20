
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
Card Trick
Time Limit: 1000MS		Memory Limit: 65536K
Total Submissions: 3193		Accepted: 2334
Description


The magician shuffles a small pack of cards, holds it face down and performs the following procedure:

The top card is moved to the bottom of the pack. The new top card is dealt face up onto the table. It is the Ace of Spades.
Two cards are moved one at a time from the top to the bottom. The next card is dealt face up onto the table. It is the Two of Spades.
Three cards are moved one at a time…
This goes on until the nth and last card turns out to be the n of Spades.
This impressive trick works if the magician knows how to arrange the cards beforehand (and knows how to give a false shuffle). Your program has to determine the initial order of the cards for a given number of cards, 1 ≤ n ≤ 13.

Input

On the first line of the input is a single positive integer, telling the number of test cases to follow. Each case consists of one line containing the integer n.

Output

For each test case, output a line with the correct permutation of the values 1 to n, space separated. The first number showing the top card of the pack, etc…

Sample Input

2
4
5
Sample Output

2 1 4 3
3 1 4 5 2
Source

Nordic 2006
 */
public class p3032 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        for(int i = 0; i < num ; i++) {
            int n = in.nextInt();
            int[] tab = new int[n];
        }
    }
}
