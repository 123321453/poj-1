
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
Jolly Jumpers
Time Limit: 1000MS		Memory Limit: 65536K
Total Submissions: 14737		Accepted: 4469
Description

A sequence of n > 0 integers is called a jolly jumper if the absolute values of the difference between successive elements take on all the values 1 through n-1. For instance, 

1 4 2 3 

is a jolly jumper, because the absolutes differences are 3, 2, and 1 respectively. The definition implies that any sequence of a single integer is a jolly jumper. You are to write a program to determine whether or not each of a number of sequences is a jolly jumper.
Input

Each line of input contains an integer n < 3000 followed by n integers representing the sequence.
Output

For each line of input, generate a line of output saying "Jolly" or "Not jolly". 
Sample Input

4 1 4 2 3
5 1 4 2 -1 6
Sample Output

Jolly
Not jolly
 */
public class p2575 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int cur;
        int prev = 0;
        while(in.hasNext()) {
            int num = in.nextInt();
            boolean flag = true;
            if(num == 1) {
                cur = in.nextInt();
                System.out.println("Jolly");
                continue;
            }
            int[] diff = new int[num];
            for(int i = 0 ; i < num ; i++){
                cur = in.nextInt();
                if(i == 0) {
                    prev = cur;
                }
                else {
                    int tmp = (int)Math.abs(prev - cur);
                    //System.out.println("prev cur " + prev + " "+cur + "tmp: "+ tmp);
                    if(tmp < 1 || tmp >(num-1))
                        flag = false;
                    else
                        diff[tmp] = 1;
                    prev = cur;
                }
            }
            for(int j = 1; j <= (num-1) ; j++) {
                if(diff[j] == 0) {
                    flag = false;
                    break;
                }
            }
            if(flag)
                System.out.println("Jolly");
            else 
                System.out.println("Not jolly");
        }
    }
}
