
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
Halloween Holidays
Time Limit: 1000MS		Memory Limit: 65536K
Total Submissions: 3277		Accepted: 1354
Description

Planet Cucurbita is inhabited with intelligent pumpkins. These pumpkins are not only extremely clever, they also are fond of tourism. One of their main routes is the Earth during Halloween.

As you know, pumpkins cannot move by themselves (intelligent pumpkins are not an exception), so they make somebody else to transport them. In the case of Halloween this is done by humans. First, they make people to grow special biological docking stations, then prepare the stations (people cut special holes, fire candles etc – you know the procedure), and after these preparations pumpkins come and have fun. People usually do not see anything and think that this is just a holiday and that this holiday is for humans, but remember – if somebody is frightened at Halloween, he was frightened not by his not-very-friendly friends, but by alien pumpkins.

To use the biological docking station, a pumpkin must have a special transmitter. It’s main elements are two rings made of gold and for some unexplainable reasons these rings should be cut from one round plate. The sizes of these rings (inner and outer radii) are pumpkin-specific, so each alien should order a special set for himself.

Mr. Calabaza, an adolescent pumpkin, wants to make his first trip to the Earth. He found a discount plate, which was not redeemed by a previous customer, and it is necessary to check, whether this plate allows Mr. Calabaza to cut the rings he needs from it, or he should order a new larger plate.

Input

The input file contains five integer numbers A, a, B, b, P (0 < A, a, B, b, P ≤ 1 000 000, a < A and b < B), separated with spaces. Here, A and B are the outer radii of the rings, a and b are the inner radii of the corresponding rings, and P is the plate radius.

Output

Output a word “Yes” if the plate suits Mr. Calabaza, or a word “No” if he needs to order another one.

Sample Input

2 1 5 3 6
Sample Output

Yes
Hint


Source

Northeastern Europe 2006, Northern Subregion
 */
public class p3386 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int A = in.nextInt();
        int a = in.nextInt();
        int B = in.nextInt();
        int b = in.nextInt();
        int P = in.nextInt();
        if((A <= b && B <= P) || (B <= a && A <= P)|| ((A +B ) <=  P))
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}
