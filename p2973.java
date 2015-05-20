
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
Scrabble
Time Limit: 1000MS		Memory Limit: 65536K
Total Submissions: 1718		Accepted: 979
Description

The game of Scrabble is played with tiles. A tile either has a single letter written on it, or it is blank. In the latter case, the tile may be used to represent a letter of your choice. On your turn, you arrange the tiles to form a word. Each tile may be used at most once, but not all tiles need to be used. Given several Scrabble tiles and a dictionary, determine how many words in the dictionary can be formed using the given Scrabble tiles.

Input

The input test file will contain multiple test cases. In each test case, the first line contains a positive integer n ≤ 1000 indicating the number of words in the dictionary. The following n lines each contain a single string with between 1 and 7 uppercase letters, representing a word in the dictionary. No word will appear in the dictionary twice. The next line contains a single string giving the tiles you have available. It will contain only capital letters, representing tiles with that letter on it, and underscores, representing blank tiles. The string will contain between 1 and 7 characters, possibly including duplicate tiles. The end-of-file is marked by a test case with n = 0 and should not be processed.

Output

For each test case, write a single line with the number of dictionary words that can be spelled with the given Scrabble tiles.

Sample Input

5
PROGRAM
CONTEST
PIZZA
ZA
PITA
_PIZA
3
BANANAS
CARROTS
FIGS
A__AA__
0
Sample Output

3
2
Hint

In the first test case, PIZZA, ZA and PITA can be spelled as PIZ_A, ZA and PI_A. There are not enough letters to spell PROGRAM or CONTEST. In the second test case, BANANAS and FIGS can be spelled as _A_A_A_ and ____. On the other hand, CARROTS would require 6 blanks in addition to the A.

Source

Stanford Local 2005
 */
public class p2973 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            int N = in.nextInt();
            if(N == 0)
                break;
            String[] tab = new String[N];
            for(int i = 0; i < N ;i++) {
                tab[i] = in.next();                
            }
            String test = in.next();
            char[] tmp2 = test.toCharArray();
            int numU = 0;
            for(int i = 0; i < tmp2.length; i++) {
                if(tmp2[i] == '_')
                    numU++;
            }
            int num = 0;
            for(int i = 0; i < N ; i++) {
                char[] tmp1 = tab[i].toCharArray();
                boolean flag = false;
                if(tmp1.length > tmp2.length)
                    continue;
                else {
                    int numS = 0;
                    boolean[] visit = new boolean[tmp2.length];
                    for(int j = 0; j < tmp1.length; j++) {
                        for(int k = 0; k < tmp2.length; k++) {
                            if(tmp1[j] == tmp2[k] && visit[k] == false) {
                                numS++;
                                visit[k] = true;
                                break;
                            }
                        }
                    }
                  //  System.out.println("test1: "+numS+" "+numU+" len: "+tmp1.length);
                    if(numS+numU >= tmp1.length) {
                        num++;
                    }
                }
            }
            System.out.println(num);
        }
    }
}
