
import java.math.BigInteger;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
序列
Time Limit: 1000MS		Memory Limit: 65536K
Total Submissions: 5982		Accepted: 2641
Description

数列A满足An = An-1 + An-2 + An-3, n >= 3 

编写程序，给定A0, A1 和 A2, 计算A99
Input

输入包含多行数据 

每行数据包含3个整数A0, A1, A2 (0 <= A0, A1, A2 <= 32767) 
数据以EOF结束
Output

对于输入的每一行输出A99的值
Sample Input

1 1 1
Sample Output

69087442470169316923566147
 */
public class p3982 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = 3;
        while(in.hasNext()){
            n = 3;
            BigInteger[] tab = new BigInteger[100];
            int a0 = in.nextInt();
            tab[0] = BigInteger.valueOf(a0);
            int a1 = in.nextInt();
            tab[1] = BigInteger.valueOf(a1);
            int a2 = in.nextInt();
            tab[2] = BigInteger.valueOf(a2);
            while(n <=99) {
                tab[n] = tab[n-1].add(tab[n-2].add(tab[n-3]));
                
              // System.out.println("n: "+ n +" "+tab[n]);
                n++;
            }
            //System.out.println(Long.MAX_VALUE +" "+69087442470169316923566147);
            System.out.println(tab[99]);
        }
    }
}
