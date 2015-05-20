
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
Eva's Problem
Time Limit: 1000MS		Memory Limit: 10000K
Total Submissions: 15854		Accepted: 9646
Description

Eva的家庭作业里有很多数列填空练习。填空练习的要求是：已知数列的前四项，填出第五项。因为已经知道这些数列只可能是等差或等比数列，她决定写一个程序来完成这些练习。
Input

第一行是数列的数目t（0 <= t <= 20）。以下每行均包含四个整数，表示数列的前四项。约定数列的前五项均为不大于10^5的自然数，等比数列的比值也是自然数。
Output

对输入的每个数列，输出它的前五项。
Sample Input

2
1 2 3 4
1 2 4 8
Sample Output

1 2 3 4 5
1 2 4 8 16
Source

POJ Monthly--2004.05.15 Null
 */
public class p1658 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i = 0; i < n ; i++) {
            int[] num = new int[5];
            boolean DC = false;
            boolean DB = false;
            num[0] = in.nextInt();
            num[1] = in.nextInt();
            num[2] = in.nextInt();
            num[3] = in.nextInt();
            int d1 = num[1] - num[0];
            int d2 = num[2] - num[1];
            int d3 = num[3] - num[2];
            if((d1 == d2) && (d3 == d2))
                DC = true;
            else
                DB = true;
            
            if(DC) {          
                num[4] = num[3] + d3;
                System.out.println(num[0]+" "+num[1] +" "+num[2]+" "+num[3]+" "+num[4]);
            }
            if(DB) {
              //  if(!smallN)
                    num[4] = num[3] * (num[3] / num[2]);
                //else
                  //  num[4] = 
                System.out.println(num[0]+" "+num[1] +" "+num[2]+" "+num[3]+" "+num[4]);
            }
        }
    }
}
