
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
Probability One
Time Limit: 1000MS		Memory Limit: 65536K
Total Submissions: 1021		Accepted: 732
Description

Number guessing is a popular game between elementary-school kids. Teachers encourage pupils to play the game as it enhances their arithmetic skills, logical thinking, and following-up simple procedures. We think that, most probably, you too will master in few minutes. Here’s one example of how you too can play this game: Ask a friend to think of a number, let’s call it n0. Then: 

Ask your friend to compute n1 = 3 * n0 and to tell you if n1 is even or odd.

If n1 is even, ask your friend to compute n2 = n1/2. If, otherwise, n1 was odd then let your friend compute n2 = (n1 + 1)/2.

Now ask your friend to calculate n3 = 3 * n2.

Ask your friend to tell tell you the result of n4 = n3/9. (n4 is the quotient of the division operation. In computer lingo, ’/’ is the integer-division operator.)

Now you can simply reveal the original number by calculating n0 = 2 * n4 if n1 was even, or n0 = 2 * n4 + 1 otherwise.


Here’s an example that you can follow: If n0 = 37, then n1 = 111 which is odd. Now we can calculate n2 = 56, n3 = 168, and n4 = 18, which is what your friend will tell you. Doing the calculation 2 * n4 + 1 = 37 reveals n0.
Input

Your program will be tested on one or more test cases. Each test case is made of a single positive number (0 < n0 < 1,000,000). 
The last line of the input file has a single zero (which is not part of the test cases.)
Output

For each test case, print the following line: 
k. B Q 
Where k is the test case number (starting at one,) B is either ’even’ or ’odd’ (without the quotes) depending on your friend’s answer in step 1. Q is your friend’s answer to step 4.
Sample Input

37
38
0
Sample Output

1. odd 18
2. even 19
 */
public class p3994 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int test = 0;
        while(in.hasNext()) {
            test++;
            int n0 = in.nextInt();
            if(n0 == 0)
                break;
            boolean ifEven = false;
            int n4 = -1;
            if(n0%2 == 0) {
                n4 = n0/2;
                ifEven = true;
            }
            else {
                n4 = (n0-1)/2;
                ifEven = false;
            }
            if(ifEven)
                System.out.println(test+". "+"even "+n4);
            else
                System.out.println(test+". "+"odd "+n4);          
            
        }
    }
}
