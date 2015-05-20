
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
A multiplication game
Time Limit: 1000MS		Memory Limit: 65536K
Total Submissions: 4683		Accepted: 2351
Description

Stan and Ollie play the game of multiplication by multiplying an integer p by one of the numbers 2 to 9. Stan always starts with p = 1, does his multiplication, then Ollie multiplies the number, then Stan and so on. Before a game starts, they draw an integer 1 < n < 4294967295 and the winner is who first reaches p >= n.
Input

Each line of input contains one integer number n.
Output

For each line of input output one line either 
Stan wins. 
or 
Ollie wins. 
assuming that both of them play perfectly.
Sample Input

162
17
34012226
Sample Output

Stan wins.
Ollie wins.
Stan wins.
Source

Waterloo local 2001.09.22
 */
public class p2505 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            int n = in.nextInt();
            int m = n%18;
            System.out.println(m);
            if(m > 1 && m <= 9) {
                System.out.println("Stan wins.");
            }
            if((m > 9 && m < 18) || m == 0) {
                System.out.println("Ollie wins.");
            }
                
        }
    }
}
