
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
Trees
Time Limit: 1000MS		Memory Limit: 65536K
Total Submissions: 8819		Accepted: 5849
Description

The road off the east gate of Peking University used to be decorated with a lot of trees. However, because of the construction of a subway, a lot of them are cut down or moved away. Now please help to count how many trees are left. 

Let's only consider one side of the road. Assume that trees were planted every 1m (meter) from the beginning of the road. Now some sections of the road are assigned for subway station, crossover or other buildings, so trees in those sections will be moved away or cut down. Your job is to give the number of trees left. 

For example, the road is 300m long and trees are planted every 1m from the beginning of the road (0m). That's to say that there used to be 301 trees on the road. Now the section from 100m to 200m is assigned for subway station, so 101 trees need to be moved away and only 200 trees are left.
Input

There are several test cases in the input. Each case starts with an integer L (1 <= L < 2000000000) representing the length of the road and M (1 <= M <= 5000) representing the number of sections that are assigned for other use. 

The following M lines each describes a section. A line is in such format: 

Start End 

Here Start and End (0 <= Start <= End <= L) are both non-negative integers representing the start point and the end point of the section. It is confirmed that these sections do not overlap with each other. 

A case with L = 0 and M = 0 ends the input.
Output

Output the number of trees left in one line for each test case.
Sample Input

300 1
100 200
500 2
100 200
201 300
0 0
Sample Output

200
300
 */
public class p2665 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            String[] arr = in.nextLine().split("\\s+");
            long L = Long.parseLong(arr[0]);
            int M = Integer.parseInt(arr[1]);
            if((L == 0) && (M == 0))
                break;
            long cutT = 0;
            for(int i = 0; i < M;i++) {
                arr = in.nextLine().split("\\s+");
                long a = Long.parseLong(arr[0]);
                long b = Long.parseLong(arr[1]);
                cutT += ((b-a)+1);
            }
            Long temp = L+1-cutT;
            System.out.println(temp);
            
        }
    }
}
