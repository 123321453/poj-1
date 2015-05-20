
import java.math.BigInteger;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
How many Fibs?
Time Limit: 1000MS		Memory Limit: 65536K
Total Submissions: 9538		Accepted: 3561
Description

Recall the definition of the Fibonacci numbers: 
f1 := 1 

f2 := 2 

fn := fn-1 + fn-2     (n>=3) 

Given two numbers a and b, calculate how many Fibonacci numbers are in the range [a,b].
Input

The input contains several test cases. Each test case consists of two non-negative integer numbers a and b. Input is terminated by a=b=0. Otherwise, a<=b<=10100. The numbers a and b are given with no superfluous leading zeros.
Output

For each test case output on a single line the number of Fibonacci numbers fi with a<=fi<=b.
Sample Input

10 100
1234567890 9876543210
0 0
Sample Output

5
4
Source

Ulm Local 2000
 */
public class p2413 {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            
            BigInteger a = in.nextBigInteger();
            BigInteger b = in.nextBigInteger();
            if(a.equals(BigInteger.ZERO) && b.equals(BigInteger.ZERO))
                break;
            int cnt = 0;
            BigInteger[] f = new BigInteger[1000000];
            f[1] = BigInteger.ONE;
            f[2] = f[1].add(f[1]);
            for(int j = 1 ; j < f.length; j++) {
                if(j > 2)
                    f[j] = f[j-1].add(f[j-2]);
                if(f[j].compareTo(b) == 1)
                    break;
                if(f[j].compareTo(a) >= 0)
                    cnt++;
            }
            System.out.println(cnt);
        }
    }
}
