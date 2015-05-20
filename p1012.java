
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
Joseph
Time Limit: 1000MS		Memory Limit: 10000K
Total Submissions: 41636		Accepted: 15677
Description

The Joseph's problem is notoriously known. For those who are not familiar with the original problem: from among n people, numbered 1, 2, . . ., n, standing in circle every mth is going to be executed and only the life of the last remaining person will be saved. Joseph was smart enough to choose the position of the last remaining person, thus saving his life to give us the message about the incident. For example when n = 6 and m = 5 then the people will be executed in the order 5, 4, 6, 2, 3 and 1 will be saved. 

Suppose that there are k good guys and k bad guys. In the circle the first k are good guys and the last k bad guys. You have to determine such minimal m that all the bad guys will be executed before the first good guy. 

Input

The input file consists of separate lines containing k. The last line in the input file contains 0. You can suppose that 0 < k < 14.
Output

The output file will consist of separate lines containing m corresponding to k in the input file.
Sample Input

3
4
0
Sample Output

5
30
 */
public class p1012 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] tmp = new int[14];
        while(in.hasNext()) {
            int k = in.nextInt();
            if(k == 0)
                break;
            int m = k+1;

            while(true) {
                if(tmp[k] != 0)
                    break;
                int rest = 2*k;

                int p = 0;
                while(true) {
                    p = (p+m-1)%rest +1;
                    if(p > k) {
                        rest--;
                        p--;
                    }
                    else {
                        break;
                    }
                }
                if(rest == k) {
                    tmp[k] = m;
                    break;
                }
                m++;
            }
            System.out.println(tmp[k]);
        }
    }
    
}
