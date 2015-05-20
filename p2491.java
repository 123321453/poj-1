
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
Scavenger Hunt
Time Limit: 1000MS		Memory Limit: 65536K
Total Submissions: 2365		Accepted: 1288
Description

Background 
Bill has been the greatest boy scout in America and has become quite a superstar because he always organized the most wonderful scavenger hunts (you know, where the kids have to find a certain route following certain hints). Bill has retired now, but a nationwide election quickly found a successor for him, a guy called George. He does a poor job, though, and wants to learn from Bill's routes. Unfortunately Bill has left only a few notes for his successor. 
Problem 
Bill never wrote down his routes completely, he only left lots of little sheets on which he had written two consecutive steps of the routes. He then mixed these sheets and memorized his routes similarly to how some people learn for exams: practicing again and again, always reading the first step and trying to remember the following. This made much sense, since one step always required something from the previous step. 
George however would like to have a route written down as one long sequence of all the steps in the correct order. Please help him make the nation happy again by reconstructing the routes.
Input

The first line contains the number of scenarios. Each scenario describes one route and its first line tells you how many steps (3 <= S <= 333) the route has. The next S-1 lines each contain one consecutive pair of the steps on the route separated by a single space. The name of each step is always a single string of letters.
Output

The output for every scenario begins with a line containing "Scenario #i:", where i is the number of the scenario starting at 1. Then print S lines containing the steps of the route in correct order. Terminate the output for the scenario with a blank line.
Sample Input

2
4
SwimmingPool OldTree
BirdsNest Garage
Garage SwimmingPool
3
Toilet Hospital
VideoGame Toilet
Sample Output

Scenario #1:
BirdsNest
Garage
SwimmingPool
OldTree

Scenario #2:
VideoGame
Toilet
Hospital
Source

TUD Programming Contest 2005, Darmstadt, Germany
 */
public class p2491 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        for(int i = 1; i <= num ; i++) {
            int N = in.nextInt();
            HashMap<String,String> tab = new HashMap();
            for(int j = 0; j < N-1 ;j++) {
                String input1 = in.next();
                String input2 = in.next();
                //System.out.println("tewtrsa: " +input1+" "+input2);
                tab.put(input1, input2);
            }
            Set<String> map = tab.keySet();
            Iterator iter = map.iterator();
            //System.out.println("test "+ iter.next());
            /*
            for (; iter.hasNext();) {
                String str = (String) iter.next();
                System.out.println("test "+str);
            }
            * 
            */
            int nt = 0;
            String[] list = null;
            while(iter.hasNext()) {
               // int cnt = 1;
                //Iterator it = map.iterator();
                if(nt == N)
                    break;
                nt = 1;
                String start = (String)iter.next();
               // System.out.println("%%start:%% "+start);
                list = new String[N+1];
                list[nt] = start;
                while(nt <= N) {
                    start = tab.get(start);
                 //   System.out.println("%%"+start);
                    nt++;
                    list[nt] = start;
                    if(tab.containsKey(start)) {
                       // cnt++;
                       // nt++;
                        //list[nt] = start;
                       // System.out.println("list "+list[nt]);
                        continue;
                    }
                    else {
                        break;
                    }
                }
            }
            System.out.printf("Scenario #%d:\n",i);
            for(int k1 = 1; k1 <= N; k1++) {
                System.out.println(list[k1]);
            }
            System.out.println();
        }
    }
}
