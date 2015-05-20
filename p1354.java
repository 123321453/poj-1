
import java.math.BigDecimal;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
Placement of Keys
Time Limit: 1000MS		Memory Limit: 10000K
Total Submissions: 1411		Accepted: 744
Description

Assume that there are n (3<=n<=200) boxes identified by A1, A2,..., An , and each box Ai is configured a lock which is different from the others. Now put n keys to the n locks into the n boxes, each box can only hold a key. After locking all the boxes, unclench the boxes named A1, A2 and fetch out the keys in them to unlock the locked boxes. If the two keys can open some box, fetch out the key in the box to unlock other locked boxes again. If we can open all the boxes finally, we call the placement of the n keys good placement. How many are there different good placements of the n keys?
Input

The input file, ending with -1, contains several data, each of which holds a line.
Output

According to every input datum, compute the number of different good placements. Each output data hold two lines, the first line is held by the input datum, followed by a colon, which follows an equal mark before which is an N; the second is held by the number of different good placement of the n keys.
Sample Input

6
8
-1
Sample Output

N=6:
240
N=8:
10080
Source

Xi'an 2002
 */
public class p1354 {
    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        while(in.hasNext()) {
            int n = in.nextInt();
            if(n == -1)
                break;
            BigDecimal nn =  new BigDecimal(n);
            BigDecimal result = BigDecimal.ONE;
            for(BigDecimal i = BigDecimal.ONE; i.compareTo(nn) == -1; i = i.add(BigDecimal.ONE))
                result = result.multiply(i);
            BigDecimal two = new BigDecimal(2);
            result = result.multiply(two);
            System.out.printf("N=%d:\n",n);
            System.out.println(result);
        }
    }
}
