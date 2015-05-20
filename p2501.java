
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
Average Speed
Time Limit: 1000MS		Memory Limit: 65536K
Total Submissions: 4468		Accepted: 1984
Description

You have bought a car in order to drive from Waterloo to a big city. The odometer on their car is broken, so you cannot measure distance. But the speedometer and cruise control both work, so the car can maintain a constant speed which can be adjusted from time to time in response to speed limits, traffic jams, and border queues. You have a stopwatch and note the elapsed time every time the speed changes. From time to time you wonder, "how far have I come?". To solve this problem you must write a program to run on your laptop computer in the passenger seat.
Input

Standard input contains several lines of input: Each speed change is indicated by a line specifying the elapsed time since the beginning of the trip (hh:mm:ss), followed by the new speed in km/h. Each query is indicated by a line containing the elapsed time. At the outset of the trip the car is stationary. Elapsed times are given in non-decreasing order and there is at most one speed change at any given time.
Output

For each query in standard input, you should print a line giving the time and the distance travelled, in the format below.
Sample Input

00:00:01 100
00:15:01
00:30:01
01:00:01 50
03:00:01
03:00:05 140
Sample Output

00:15:01 25.00 km
00:30:01 50.00 km
03:00:01 200.00 km
Source

Waterloo local 2001.09.22

 */
public class p2501 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double dis = 0.0;
        int speed = 0;
        int phh = 0;
        int pmm = 0;
        int pss = 0;
        int chh = 0;
        int cmm = 0;
        int css = 0;
        while(in.hasNext()) {
            String[] input = in.nextLine().split("\\s+");
            String[] curT ;
            if (input.length == 2) {
                curT = input[0].split(":");
                chh = Integer.parseInt(curT[0]);
                cmm = Integer.parseInt(curT[1]);
                css = Integer.parseInt(curT[2]);
                dis += speed * ((chh - phh) + ((double) (cmm - pmm) / 60) + ((double) (css - pss) / 3600));
                speed = Integer.parseInt(input[1]);

                
                phh = chh;
                pmm = cmm;
                pss = css;
                continue;
            }
            else {
                curT = input[0].split(":");
                chh = Integer.parseInt(curT[0]);
                cmm = Integer.parseInt(curT[1]);
                css = Integer.parseInt(curT[2]);
                //System.out.println("test1: "+speed+" "+dis);
                dis += speed * ((chh - phh) + ((double) (cmm - pmm) / 60) + ((double) (css - pss) / 3600));
                phh = chh;
                pmm = cmm;
                pss = css;
                System.out.printf("%s %.2f km\n", input[0], dis);
            }           
        }
        
    }
}
