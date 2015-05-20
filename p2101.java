
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
Honey and Milk Land
Time Limit: 1000MS		Memory Limit: 64000K
Total Submissions: 2932		Accepted: 1619
Description

Bad rumors are spreading over the Land of Honey and Milk. Informed people say that the milk in the famous grid of milk rivers is turning sour. Of course, the security service quickly found out that the people are informed by the Kingdom of Tar, which is jealous to tourist popularity of the land. However, this discovery does not help to stop these rumors. The government wants to prevent crisis of the tourist industry, so it wants to establish daily monitoring of the rivers. 
A new Milk Security Department is established, which is responsible for preventing the milk from turning sour. It's equipped with powerful boilers and pasteurizer, so any danger for the milk can be quickly neutralized. To better fight the new threat, the department needs to know about possible dangers beforehand. They have a helicopter, capable to check milk freshness. The equipment is perfect. It's enough just to cross a river in any place in order to detect all its potentially dangerous places. 
To start the Milk Security Department operations, the government needs to add funding of the Service to the Land budget. One of the issues is the morning route of the helicopter. The helicopter should check all the rivers in the shortest time. They need to determine the price of this flight to add it to the budget. 
The grid consists of two sets of milk rivers. Rivers from the first set run from North to South, rivers from the second set --- from East to West. The rivers are straight. The rivers from each set are parallel and the distance between the adjacent rivers is known. There are n rivers, running from North to South and e rivers, running from East to West. 
The government needs to determine the minimal morning flight cost. Each kilometer costs 1 honey barrel, the Land national currency. The cost of take-off and landing is not included into this cost. You may freely choose the starting and ending points of the flight.
Input

The first line of the input file contains n and e (1 <= n, e <= 1 000). The second line contains n - 1 integer numbers that represent distances (in kilometers) between adjacent rivers running from North to South, listed from East to West. The third line contains e - 1 integer numbers that represent distances (also in kilometers) between adjacent rivers running from East to West, listed from North to South. The distance between any two adjacent rivers does not exceed 27 kilometers.
Output

Output the minimal morning flight cost in honey barrels. Since there is no smaller denomination, you must output the minimal integer number of honey barrels that would be sufficient to support the flight.
Sample Input

10 10
2 2 2 2 2 2 2 2 2
2 2 2 2 2 2 2 2 2
Sample Output

26
Source

Northeastern Europe 2004, Northern Subregion
 */
public class p2101 {
    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        int n = in.nextInt();
        int e = in.nextInt();
        int l1 = 0; 
        int l2 = 0;
        //System.out.println("tes1");
        int tmp;
        for(int i = 0; i < n-1; i++) {
            tmp = in.nextInt();
            l1 += tmp;
        }
        for(int i = 0; i < e-1; i++) {
            tmp = in.nextInt();
            l2 += tmp;
        }
        //System.out.println("tes");
        double res = Math.hypot((double)l1, (double)l2);
        int re = (int)res;
        if(re < res)
            System.out.println(re+1);
        else
            System.out.println(re);
    }
}
