
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
Assistance Required
Time Limit: 1000MS		Memory Limit: 65536K
Total Submissions: 2626		Accepted: 1527
Description

After the 1997/1998 Southwestern European Regional Contest (which was held in Ulm) a large contest party took place. The organization team invented a special mode of choosing those participants that were to assist with washing the dirty dishes. The contestants would line up in a queue, one behind the other. Each contestant got a number starting with 2 for the first one, 3 for the second one, 4 for the third one, and so on, consecutively. 

The first contestant in the queue was asked for his number (which was 2). He was freed from the washing up and could party on, but every second contestant behind him had to go to the kitchen (those with numbers 4, 6, 8, etc). Then the next contestant in the remaining queue had to tell his number. He answered 3 and was freed from assisting, but every third contestant behind him was to help (those with numbers 9, 15, 21, etc). The next in the remaining queue had number 5 and was free, but every fifth contestant behind him was selected (those with numbers 19, 35, 49, etc). The next had number 7 and was free, but every seventh behind him had to assist, and so on. 

Let us call the number of a contestant who does not need to assist with washing up a lucky number. Continuing the selection scheme, the lucky numbers are the ordered sequence 2, 3, 5, 7, 11, 13, 17, etc. Find out the lucky numbers to be prepared for the next contest party.
Input

The input contains several test cases. Each test case consists of an integer n. You may assume that 1<=n<=3000. A zero follows the input for the last test case.
Output

For each test case specified by n output on a single line the n-th lucky number.
Sample Input

1
2
10
20
0
Sample Output

2
3
29
83
Source

Ulm Local 2003
 */
public class p2552_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> tab = new ArrayList();
        for(int i = 2; i < 35000; i++)
            tab.add(i);
        
        int j;
        int i;
        int cnt;
       // boolean flag = false;
        for(j = 0 ; j < tab.size(); j++) {
          //  int cnt = 0;
           // if(!flag) {
              //  System.out.println("test1: " +j);
             //   flag = true;
          //  }
            //int t = 0;
            i = tab.get(j);
            for(cnt = j + i; cnt < tab.size(); cnt += i) {
                tab.set(cnt, 0);
            }
            for(int k = 0; k < tab.size(); k++) {
                if(tab.get(k) == 0)
                    tab.remove(k);
            }
        }
        //System.out.println(tab.size());
        while(in.hasNext()) {
            int n = in.nextInt();
            if(n == 0)
                break;
            if(n <= 3000)
                System.out.println(tab.get(n-1));
        }
    }
}
