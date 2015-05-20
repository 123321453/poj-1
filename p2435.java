/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
Navigating the City
Time Limit: 1000MS		Memory Limit: 65536K
Total Submissions: 818		Accepted: 448
Description

A dip in the milk market has forced the cows to move to the city. The only employment available is in the venerable field of taxi-driving. Help the cows learn their way around the city. 

Given a city map with E (1 <= E <= 40) east/west street locations and N (1 <= N <= 30) north/south street locations, create instructions for a taxi driver to navigate from the start of his route (marked 'S') to the end (marked 'E'). Each instruction is a direction (one of 'N', 'E', 'S', or 'W') followed by a space followed by an integer that tells how many blocks to drive in that direction. If multiple routes are available, your program should output the shortest route. The shortest route is guaranteed to exist and be unique. 

The map is depicted as a grid of '+'s that represent intersections and a set of roads depicted as '-' and '|'. Buildings and other obstacles are shown as '.'s. Here is a typical map: 
+-+-+.+-+-+

|...|.....|

+-+.+-+-+-+

..|.......|

S-+-+-+.E-+

The taxi should go east, north, west, north, east two blocks, and so on. See the output format and sample solution below for its complete route.
Input

* Line 1: Two space-separated integers, N and E. 

* Lines 2..2*N: These lines each contain 2*E-1 characters and encode the map of the street. Every other input line gives the data for the east/west streets; the remaining lines show the north/south streets. The format should be clear from the example.
Output

* Lines 1..?: Each line contains a direction letter and a number of blocks to travel in that direction.
Sample Input

3 6
+-+-+.+-+-+
|...|.....|
+-+.+-+-+-+
..|.......|
S-+-+-+.E-+
Sample Output

E 1
N 1
W 1
N 1
E 2
S 1
E 3
S 1
W 1
Source

USACO 2005 U S Open Silver
 */
public class p2435 {
    
}
