
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 * Dirichlet's Theorem on Arithmetic Progressions Time Limit: 1000MS	Memory
 * Limit: 65536K Total Submissions: 12186	Accepted: 6150 Description
 *
 * If a and d are relatively prime positive integers, the arithmetic sequence
 * beginning with a and increasing by d, i.e., a, a + d, a + 2d, a + 3d, a + 4d,
 * ..., contains infinitely many prime numbers. This fact is known as
 * Dirichlet's Theorem on Arithmetic Progressions, which had been conjectured by
 * Johann Carl Friedrich Gauss (1777 - 1855) and was proved by Johann Peter
 * Gustav Lejeune Dirichlet (1805 - 1859) in 1837.
 *
 * For example, the arithmetic sequence beginning with 2 and increasing by 3,
 * i.e.,
 *
 * 2, 5, 8, 11, 14, 17, 20, 23, 26, 29, 32, 35, 38, 41, 44, 47, 50, 53, 56, 59,
 * 62, 65, 68, 71, 74, 77, 80, 83, 86, 89, 92, 95, 98, ... ,
 *
 * contains infinitely many prime numbers
 *
 * 2, 5, 11, 17, 23, 29, 41, 47, 53, 59, 71, 83, 89, ... .
 *
 * Your mission, should you decide to accept it, is to write a program to find
 * the nth prime number in this arithmetic sequence for given positive integers
 * a, d, and n.
 *
 * Input
 *
 * The input is a sequence of datasets. A dataset is a line containing three
 * positive integers a, d, and n separated by a space. a and d are relatively
 * prime. You may assume a <= 9307, d <= 346, and n <= 210.
 *
 * The end of the input is indicated by a line containing three zeros separated
 * by a space. It is not a dataset.
 *
 * Output
 *
 * The output should be composed of as many lines as the number of the input
 * datasets. Each line should contain a single integer and should never contain
 * extra characters.
 *
 * The output integer corresponding to a dataset a, d, n should be the nth prime
 * number among those contained in the arithmetic sequence beginning with a and
 * increasing by d.
 *
 * FYI, it is known that the result is always less than 106 (one million) under
 * this input condition.
 *
 * Sample Input
 *
 * 367 186 151 179 10 203 271 37 39 103 230 1 27 104 185 253 50 85 1 1 1 9075
 * 337 210 307 24 79 331 221 177 259 170 40 269 58 102 0 0 0 Sample Output
 *
 * 92809 6709 12037 103 93523 14503 2 899429 5107 412717 22699 25673
 */
public class p3006 {

    public static boolean isZh(int p) {
        if (p == 1) {
            return false;
        }
        if (p == 2) {
            return true;
        }
        if (p % 2 == 0) {
            return false;
        }
        for (int i = 3; i * i <= p; i = i + 2) {
            if (p % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        boolean[] prime = new boolean[1000005];
        int i, j;
        for (i = 0; i < prime.length; i++) {
            prime[i] = true;
        }

        for (i = 3; i < prime.length; i++) {
            for (j = 3; j <= Math.sqrt((double) i); j += 2) {
                if (i % j == 0) {
                    prime[i] = false;
                    break;
                }
                if(i%2 == 0) {
                    prime[i] = false;
                    break;
                }
            }
        }

        /*
         * for (i = 3; i <= 1000; i += 2) { for (j = 3; j < prime.length / i; j
         * += 2) { if (prime[i]) { prime[i * j] = false; } } }
         */
        prime[0] = false;
        prime[1] = false;
        prime[2] = true;

        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int k = 0;
            int a = in.nextInt();
            int d = in.nextInt();
            int n = in.nextInt();
            if ((a | d | n) == 0) {
                break;
            }
            j = 1;
            i = 0;
            
            while(j <= n) {
                if(isZh(a+i*d)) {
                    j++;
                }
                i++;
            }
            /*
           // if (a != 1) {
                for (i = a; j <= n; i += d) {
                    if (isZh(i+d)) {
                        j++;
                    }
                    k++;
                }
           // } else {
           //     for (i = a; j <= n; i += d) {
            //        if (isZh(i+d)) {
             //           j++;
             ///       }
              //      k++;
              //  }
           // }
             */
            
            System.out.println(a+(k-1)*d);
        }


    }
}
