
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
Gnome Sequencing
Time Limit: 1000MS		Memory Limit: 65536K
Total Submissions: 1364		Accepted: 941
Description

In the book All Creatures of Mythology, gnomes are kind, bearded creatures, while goblins tend to be bossy and simple-minded. The goblins like to harass the gnomes by making them line up in groups of three, ordered by the length of their beards. The gnomes, being of different physical heights, vary their arrangements to confuse the goblins. Therefore, the goblins must actually measure the beards in centimeters to see if everyone is lined up in order. 
Your task is to write a program to assist the goblins in determining whether or not the gnomes are lined up properly, either from shortest to longest beard or from longest to shortest.
Input

The input starts with line containing a single integer N, 0 < N < 30, which is the number of groups to process. Following this are N lines, each containing three distinct positive integers less than 100.
Output

There is a title line, then one line per set of beard lengths. See the sample output for capitalization and punctuation. 
Sample Input

3
40 62 77
88 62 77
91 33 18
Sample Output

Gnomes:
Ordered
Unordered
Ordered
 */
public class p3913 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = Integer.valueOf(in.nextLine());
        System.out.println("Gnomes:");
        for(int i = 0; i < N ; i++){
            String[] tab = in.nextLine().split("\\s+");
            boolean flag = true;
            boolean isIncrease = true;
            for(int j = 1 ; j < tab.length;j++) {
               // System.out.println(j + " "+ tab[j-1]);
                int n1 = Integer.valueOf(tab[j-1]);
                int n2 = Integer.valueOf(tab[j]);
                if(j == 1) {
                    if(n1 < n2) {
                        isIncrease = true;
                    }
                    else {
                        isIncrease = false;
                    }
                    continue;
                }
                else {
                    if(isIncrease) {
                        if(n1 < n2) {
                            continue;
                        }
                        else {
                            flag = false;
                            break;
                        }
                    }
                    else {
                        if(n1 > n2) {
                            continue;
                        }
                        else {
                            flag = false;
                            break;
                        }
                        
                    }
                }
            }
            if(flag) {
                System.out.println("Ordered");
            }
            else {
                System.out.println("Unordered");
            }
        }
    }
}
