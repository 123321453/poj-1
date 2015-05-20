
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
Number-guessing Game
Time Limit: 1000MS		Memory Limit: 65536K
Total Submissions: 6055		Accepted: 4389
Description

Larry likes playing the number-guessing game.

Two players are needed in a game. Suppose they are X and Y, and X presents a number for Y to guess. Firstly, X chooses a number with four different digits, keeping it in mind, and tells Y to start guessing. Every time Y has guessed, X should give out *A*B to show Y how close to the number his answer is. Here the symbol * stands for a number, and the number before A is the number of digits in Y's answer with both correct value and position. The number before B is the number of digits in Y's answer with correct value but incorrect position.

For example, if X chooses the number 5204, and Y guesses 4902, then X should give out 1A2B, in which 1A corresponds for digit 0 with both correct value and position and 2B corresponds for digit 2 and 4 with correct value but incorrect position. Then Y will go on guessing according to 1A2B that X presents him until he gets the totally correct number 5204 (when X shows him 4A0B).

Now you are given two numbers, and what you need to do is just testing how close they are.

Input

The first line of the input is an integer T which indicates the number of test cases. For each test case, input two numbers. Each number contains four different digits.

Output

For each test case, output *A*B stands for how close the two numbers are.
　

Sample Input

2
5204 4902
0123 3210
Sample Output

1A2B
0A4B
Source

South Central China 2008 hosted by NUDT
 */
public class p3589 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        for(int i = 0; i < num ; i++) {
            char[] tab1 = in.next().toCharArray();
            char[] tab2 = in.next().toCharArray();
            int nA = 0;
            int nB = 0;
            for(int j = 0; j < tab1.length; j++) {
                if(tab1[j] == tab2[j]) {
                    nA++;
                    //break;
                }
                else {
                    for(int k = 0; k < tab2.length; k++) {
                        if(tab2[k] == tab1[j] && k != j) {
                            nB++;
                        }
                    }
                }
            }
            System.out.printf("%dA%dB\n",nA,nB);
        }
    }
}
