
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
Ride to School
Time Limit: 1000MS		Memory Limit: 30000K
Total Submissions: 17018		Accepted: 6894
Description

Many graduate students of Peking University are living in Wanliu Campus, which is 4.5 kilometers from the main campus – Yanyuan. Students in Wanliu have to either take a bus or ride a bike to go to school. Due to the bad traffic in Beijing, many students choose to ride a bike. 

We may assume that all the students except "Charley" ride from Wanliu to Yanyuan at a fixed speed. Charley is a student with a different riding habit – he always tries to follow another rider to avoid riding alone. When Charley gets to the gate of Wanliu, he will look for someone who is setting off to Yanyuan. If he finds someone, he will follow that rider, or if not, he will wait for someone to follow. On the way from Wanliu to Yanyuan, at any time if a faster student surpassed Charley, he will leave the rider he is following and speed up to follow the faster one. 

We assume the time that Charley gets to the gate of Wanliu is zero. Given the set off time and speed of the other students, your task is to give the time when Charley arrives at Yanyuan. 
Input

There are several test cases. The first line of each case is N (1 <= N <= 10000) representing the number of riders (excluding Charley). N = 0 ends the input. The following N lines are information of N different riders, in such format: 

Vi [TAB] Ti 

Vi is a positive integer <= 40, indicating the speed of the i-th rider (kph, kilometers per hour). Ti is the set off time of the i-th rider, which is an integer and counted in seconds. In any case it is assured that there always exists a nonnegative Ti. 
Output

Output one line for each case: the arrival time of Charley. Round up (ceiling) the value when dealing with a fraction.
Sample Input

4
20	0
25	-155
27	190
30	240
2
21	0
22	34
0
Sample Output

780
771
Source

Beijing 2004 Preliminary@POJ
 */
public class p1922 {
    public static void main(String[] args) {
        Scanner in= new Scanner(System.in);
        while(in.hasNext()) {
            int N = in.nextInt();
            if(N == 0)
                break;
           // int v = in.nextInt();
           // int t0 = in.nextInt();
            int[] v =  new int[N];
            int[] t0 = new int[N];
            int[] t = new int[N];
            int min =  Integer.MAX_VALUE;
            for(int i = 0; i < N ; i++) {
                v[i] = in.nextInt();
                t0[i] = in.nextInt();
                t[i] = (int)Math.ceil(4500*3.6/(v[i])+t0[i]);
                if(t[i] < min && t0[i] >= 0)
                    min = t[i];
            }
            System.out.println(min);
            
            
        }
    }
}
