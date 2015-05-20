
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
Integer Inquiry
Time Limit: 1000MS		Memory Limit: 10000K
Total Submissions: 24654		Accepted: 9576
Description

One of the first users of BIT's new supercomputer was Chip Diller. He extended his exploration of powers of 3 to go from 0 to 333 and he explored taking various sums of those numbers. 
``This supercomputer is great,'' remarked Chip. ``I only wish Timothy were here to see these results.'' (Chip moved to a new apartment, once one became available on the third floor of the Lemon Sky apartments on Third Street.) 
Input

The input will consist of at most 100 lines of text, each of which contains a single VeryLongInteger. Each VeryLongInteger will be 100 or fewer characters in length, and will only contain digits (no VeryLongInteger will be negative). 

The final input line will contain a single zero on a line by itself. 
Output

Your program should output the sum of the VeryLongIntegers given in the input.
Sample Input

123456789012345678901234567890
123456789012345678901234567890
123456789012345678901234567890
0
Sample Output

370370367037037036703703703670
 */
public class p1503 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        BigDecimal result = BigDecimal.valueOf(0);
        BigDecimal tmp ;
        String arr;
        while(in.hasNext()){
            arr = in.nextLine();
            if(arr.equalsIgnoreCase("0"))
                break;
            else {
                tmp = new BigDecimal(arr);
                result = result.add(tmp);
            }
        }
        System.out.println(result.toPlainString());
    }
}
