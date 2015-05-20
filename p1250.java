
import java.util.HashMap;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
Tanning Salon
Time Limit: 1000MS		Memory Limit: 10000K
Total Submissions: 6293		Accepted: 3424
Description

Tan Your Hide, Inc., owns several coin-operated tanning salons. Research has shown that if a customer arrives and there are no beds available, the customer will turn around and leave, thus costing the company a sale. Your task is to write a program that tells the company how many customers left without tanning. 
Input

The input consists of data for one or more salons, followed by a line containing the number 0 that signals the end of the input. Data for each salon is a single line containing a positive integer, representing the number of tanning beds in the salon, followed by a space, followed by a sequence of uppercase letters. Letters in the sequence occur in pairs. The first occurrence indicates the arrival of a customer, the second indicates the departure of that same customer. No letter will occur in more than one pair. Customers who leave without tanning always depart before customers who are currently tanning. There are at most 20 beds per salon. 
Output

For each salon, output a sentence telling how many customers, if any, walked away. Use the exact format shown below. 
Sample Input

2 ABBAJJKZKZ
3 GACCBDDBAGEE
3 GACCBGDDBAEE
1 ABCBCA
0
Sample Output

All customers tanned successfully.
1 customer(s) walked away.
All customers tanned successfully.
2 customer(s) walked away.
Source

Mid-Central USA 2002
 */
public class p1250 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int num = in.nextInt();
            if(num == 0)
                break;
            char[] tab = in.next().toCharArray();
            int cnt = 0;
            HashMap<Character,Integer>list = new HashMap();
            HashMap<Character,Integer>outlist = new HashMap();
            for(int i = 0; i < tab.length;i++) {
                if(list.size() < num || list.containsKey(tab[i])) {
                    if(list.containsKey(tab[i])) {
                        list.remove(tab[i]);
                    }
                    else {
                        //System.out.println("xxx "+tab[i] +" "+list.size());
                        list.put(tab[i], 1);
                    }
                }
                else {
                    if(outlist.containsKey(tab[i])) {
                       // System.out.println(tab[i]+" "+cnt);
                        outlist.remove(tab[i]);
                        cnt++;
                    }
                    else {
                        outlist.put(tab[i],1);
                    }
                    
                }
            }
            if(cnt == 0)
                System.out.println("All customers tanned successfully.");
            else
                System.out.println(cnt+" customer(s) walked away.");
        }
    }
}
