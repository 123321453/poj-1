
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
Count on Canton
Time Limit: 1000MS		Memory Limit: 30000K
Total Submissions: 8574		Accepted: 5011
Description

One of the famous proofs of modern mathematics is Georg Cantor's demonstration that the set of rational numbers is enumerable. The proof works by using an explicit enumeration of rational numbers as shown in the diagram below. 
1/1 1/2 1/3 1/4 1/5 ...

2/1 2/2 2/3 2/4

3/1 3/2 3/3

4/1 4/2

5/1


In the above diagram, the first term is 1/1, the second term is 1/2, the third term is 2/1, the fourth term is 3/1, the fifth term is 2/2, and so on.
Input

The input list contains a single number per line and will be terminated by endof-file.
Output

You are to write a program that will read a list of numbers in the range from 1 to 10^7 and will print for each number the corresponding term in Cantor's enumeration as given below.
Sample Input

3
14
7
Sample Output

TERM 3 IS 2/1
TERM 14 IS 2/4
TERM 7 IS 1/4
 */
public class p1969 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            int n = in.nextInt();
            int n_1 = n;
            int k = 0;
            while(n > 0) {
                k++;
                n -=k;
            }
            if(k%2 == 0) {
                System.out.printf("TERM %d IS %d/%d\n",n_1,(k+n),(1-n));
            }
            else {
                System.out.printf("TERM %d IS %d/%d\n",n_1,(1-n),(k+n));
            }
        }
    }
}
