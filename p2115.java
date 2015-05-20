
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
C Looooops
Time Limit: 1000MS		Memory Limit: 65536K
Total Submissions: 13682		Accepted: 3379
Description

A Compiler Mystery: We are given a C-language style for loop of type 
for (variable = A; variable != B; variable += C)

  statement;

I.e., a loop which starts by setting variable to value A and while variable is not equal to B, repeats statement followed by increasing the variable by C. We want to know how many times does the statement get executed for particular values of A, B and C, assuming that all arithmetics is calculated in a k-bit unsigned integer type (with values 0 <= x < 2k) modulo 2k. 

Input

The input consists of several instances. Each instance is described by a single line with four integers A, B, C, k separated by a single space. The integer k (1 <= k <= 32) is the number of bits of the control variable of the loop and A, B, C (0 <= A, B, C < 2k) are the parameters of the loop. 

The input is finished by a line containing four zeros. 
Output

The output consists of several lines corresponding to the instances on the input. The i-th line contains either the number of executions of the statement in the i-th instance (a single integer number) or the word FOREVER if the loop does not terminate. 
Sample Input

3 3 2 16
3 7 2 16
7 3 2 16
3 4 2 16
0 0 0 0
Sample Output

0
2
32766
FOREVER
Source

CTU Open 2004
 */
public class p2115 {
    public static void  main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            
            int A = in.nextInt();
            int B = in.nextInt();
            int C = in.nextInt();
            int k = in.nextInt();
            if(A == 0  && B == 0 && C ==0 && k==0)
                break;
            int m = (int)Math.pow(2, (double)k);
            //int m = 2 << k;
           // System.out.println(m);
            long cnt = 0;
            int A1 = A;
            boolean forever = false;
            boolean fst = true; 
            int Aold = 0;
            while(A1 != B) {
                A1 += C ;
                cnt++;
                if(A1 > m) {
                    //System.out.println("Before "+A+" "+B+" "+A1);
                    if(fst) {
                        Aold = A1;
                        A1 = A1%m;
                        fst = false;
                    }
                    else {
                        if(Aold == A1) {
                            forever = true;
                            break;
                        }
                        else {
                            A1 = A1%m;
                        }
                    }
                    //System.out.println("After "+A+" "+B+" "+A1);
                //    if((B-A) == (B-A1)){
                //        forever = true;
                  //      break;
                   // }
                }
            }
            if(forever) {
                System.out.println("FOREVER");
            }
            else {
                System.out.println(cnt);
            }
        }
    }
}
