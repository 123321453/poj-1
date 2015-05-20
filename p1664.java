
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
放苹果
Time Limit: 1000MS		Memory Limit: 10000K
Total Submissions: 21538		Accepted: 13761
Description

把M个同样的苹果放在N个同样的盘子里，允许有的盘子空着不放，问共有多少种不同的分法？（用K表示）5，1，1和1，5，1 是同一种分法。
Input

第一行是测试数据的数目t（0 <= t <= 20）。以下每行均包含二个整数M和N，以空格分开。1<=M，N<=10。
Output

对输入的每组数据M和N，用一行输出相应的K。
Sample Input

1
7 3
Sample Output

8
 */
public class p1664 {
    public static int f(int m,int n){
        if(m < 0)
            return 0;
        if(m == 0 || n == 1)
            return 1;
        else
            return f(m-n,n)+f(m,n-1);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = Integer.parseInt(in.nextLine());
        for(int i = 0; i < num; i++){
            int M = in.nextInt();
            int N = in.nextInt();
            System.out.println(f(M,N));
        }
    }
}
