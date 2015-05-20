
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
Blowing Fuses
Time Limit: 1000MS		Memory Limit: 10000K
Total Submissions: 3229		Accepted: 1244
Description

Maybe you are familiar with the following situation. You have plugged in a lot of electrical devices, such as toasters, refrigerators, microwave ovens, computers, stereos, etc, and have them all running. But at the moment when you turn on the TV, the fuse blows, since the power drawn from all the machines is greater than the capacity of the fuse. Of course this is a great safety feature, avoiding that houses burn down too often due to fires ignited by overheating wires. But it is also annoying to walk down to the basement (or some other inconvenient place) to replace to fuse or switch it back on. 

What one would like to have is a program that checks before turning on an electrical device whether the combined power drawn by all running devices exceeds the fuses capacity (and it blows), or whether it is safe to turn it on.
Input

The input consists of several test cases. Each test case describes a set of electrical devices and gives a sequence of turn on/off operations for these devices. 

The first line of each test case contains three integers n, m and c, where n is the number of devices (n <= 20), m the number of operations performed on these devices and c is the capacity of the fuse (in Amperes). The following n lines contain one positive integer ci each, the consumption (in Amperes) of the i-th device. 

This is followed by m lines also containing one integer each, between 1 and n inclusive. They describe a sequence of turn on/turn off operations performed on the devices. For every number, the state of that particular devices is toggled, i.e. if it is currently running, it is turned off, and if it is currently turned off, it will by switched on. At the beginning all devices are turned off. 

The input will be terminated by a test case starting with n = m = c = 0. This test case should not be processed.
Output

For each test case, first output the number of the test case. Then output whether the fuse was blown during the operation sequence. The fuse will be blown if the sum of the power consumptions ci of turned on devices at some point exceeds the capacity of the fuse c. 

If the fuse is not blown, output the maximal power consumption by turned on devices that occurred during the sequence. 

Output a blank line after each test case.
Sample Input

2 2 10
5
7
1
2
3 6 10
2
5
7
2
1
2
3
1
3
0 0 0
Sample Output

Sequence 1
Fuse was blown.

Sequence 2
Fuse was not blown.
Maximal power consumption was 9 amperes.
Source

Southwestern European Regional Contest 1998
 */
public class p1484 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int j = 1;
        while(in.hasNext()){
            int n = in.nextInt();
            int m = in.nextInt();
            int c = in.nextInt();
            //System.out.println(n+" "+ m+" "+c);
            if(n == 0 && m == 0 && c == 0)
                break;
            int[] nc = new int[n];
            int[] mc = new int[m];
            int i;
            int total = 0;
            boolean[] val = new boolean[n];
            boolean isBlow =false;
            int max = Integer.MIN_VALUE;
            for(i = 0;i < n;i++)
                nc[i] = in.nextInt();
            for(i = 0;i < m;i++) {
                mc[i] = in.nextInt();
                if(val[(mc[i]-1)] == false) {//turn off prev
                    total += nc[(mc[i]-1)];
                    val[(mc[i]-1)] = true;
                    if(total > c) {
                        isBlow = true;
                        //break;
                    }
                }
                else {
                    total -= nc[(mc[i]-1)];
                    val[(mc[i]-1)] = false;
                }
                if(total > max)
                    max = total;
            }
            if(isBlow) {
                System.out.printf("Sequence %d\n",j++);
                System.out.println("Fuse was blown.");
                System.out.println();
            }
            else {
                System.out.printf("Sequence %d\n",j++);
                System.out.println("Fuse was not blown.");
                System.out.printf("Maximal power consumption was %d amperes.\n",max);
                System.out.println();
            }
            
        }
    }
}
