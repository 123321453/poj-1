
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 * A Mysterious Function Time Limit: 1000MS	Memory Limit: 65536K Total
 * Submissions: 3720	Accepted: 2565 Description
 *
 * For any integers p and q with q > 0, define p mod q to be the integer r with
 * 0 <= r <= q −1 such that p−r is divisible by q. For example, we have 109 mod
 * 10 = 9 −7 mod 3 = 2 −56 mod 7 = 0
 *
 * Let Φ be a function defined recursively as follows. * where a, b, c, d, e, f,
 * g, h are integers with 0 < a, b, c, d, e, f, g, h <= 1000. One can easily see
 * that 0 <= Φ(i) <= 1000 holds for any integer i >= 0. Now for any given
 * integers a, b, c, d, e, f, g, h, i with 0 < a, b, c, d, e, f, g, h, i <=
 * 1000, you are asked to write a program to output * Φ(i). (Hint: a direct
 * recursive implementation of the above recurrence * relation is likely to run
 * forever for large i.) Input
 *
 * The first line contains the number n of test cases. Each of the following n
 * lines contains the sequence a, b, c, d, e, f, g, h, i of integers. Output
 *
 * For each test case, your program has to output the correct value of Φ(i).
 * Sample Input
 *
 * 3
 * 1 2 3 4 5 6 7 8 9
 * 11 12 13 14 15 16 17 18 19 321 322 323 324 325 326 327 328 329 Sample Output
 *
 * 4
 * 0
 * 90
 */
public class p2696 {

  //  private static int[] tmp1 = null;

    public static int mod(int m, int n) {
        /*
        int i;
        if (m >= 0) {
            return m % n;
        } else {
            for (i = 1; i <= n ; i++) {
                if ((m - i) % n == 0) {
                    if(i != n)
                        return i;
                    else 
                        return 0;
                }
            }
           return -1;
        }
        * 
        */
        return (m%n + n)%n;
    }

    public static void f(int[] tmp1, int[] arr, int i) {
        int u;
        if(i%2 != 0) {
            u = arr[3] * tmp1[i-1] + arr[4]*tmp1[i-2] - arr[5] *tmp1[i-3];
            tmp1[i] = mod(u,arr[6]);
        }
        else {
            u = arr[5] * tmp1[i-1] - arr[3]*tmp1[i-2] + arr[4] *tmp1[i-3];
            tmp1[i] = mod(u,arr[7]);
        }
        
    
        
        /*
        if (i == 0) {
            return a;
        }
        if (i == 1) {
            return b;
        }
        if (i == 2) {
            return c;
        }
        if(i > 1000)
            return -1;
        if (i % 2 == 1) {
           // System.out.println(tmp1[0] + " " + tmp1[1] +);
            if (tmp1[i] != -1) {
                //System.out.println("there?? " + tmp1[i] + " i: " + i);
                return tmp1[i];
            } else {
              //  System.out.println("here");
                tmp1[i] = d * f(tmp1, a, b, c, d, e, f, g, h, i - 1) + e * f(tmp1, a, b, c, d, e, f, g, h, i - 2) - f * f(tmp1,a, b, c, d, e, f, g, h, i - 3);
             //   System.out.println("i: " + i + " tmp1[i] "+ tmp1[i]);
                return mod(tmp1[i], g);
            
        } else {
            if (tmp1[i] != -1) {
                return tmp1[i];
            } else {
              tmp1[i]  = f * f(tmp1, a, b, c, d, e, f, g, h, i - 1) - d * f(tmp1,a, b, c, d, e, f, g, h, i - 2) + e * f(tmp1,a, b, c, d, e, f, g, h, i - 3);
              //  System.out.println("i: " + i + " tmp1[i] "+ tmp1[i]);
                return mod(tmp1[i], h);
            }
        }
        */
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int k;
        int n = Integer.parseInt(in.nextLine());
        for (int i = 0; i < n; i++) {
            String[] arr = in.nextLine().split("\\s+");
            int[] tmp = new int[9];
            for (int j = 0; j < 9; j++) {
                tmp[j] = Integer.parseInt(arr[j]);
            }
            int[] tmp1 = new int[tmp[8] + 1];
            for (k = 0; k < (tmp[8]+1); k++) {
                tmp1[k] = -1;
                
            }
            tmp1[0] = tmp[0];
            tmp1[1] = tmp[1];
            tmp1[2] = tmp[2];
           // System.out.println(mod(109,10));
           // System.out.println(mod(-7,3));

           // System.out.println(mod(-56,7));
            for(k = 3; k <= tmp[8]; k++) {
                f(tmp1, tmp, k);
             //   System.out.println("i: " + k + " val: "+ tmp1[k]);
            }
            
           System.out.println(tmp1[tmp[8]]);

        }
    }
}

