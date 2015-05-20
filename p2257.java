
import java.util.HashMap;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
Balancing Bank Accounts
Time Limit: 1000MS		Memory Limit: 65536K
Total Submissions: 937		Accepted: 437		Special Judge
Description

Once upon a time there was a large team coming home from the ACM World Finals. The fifteen travellers were confronted with a big problem: 
In the previous weeks, there had been many money transactions between them: Sometimes somebody paid the entrance fees of a theme park for the others, somebody else paid the hotel room, another one the rental car, and so on. 

So now the big calculation started. Some people had paid more than others, thus the individual bank accounts had to be balanced again. "Who has to pay whom how much?", that was the question. 

As such a calculation is a lot of work, we need a program now that will solve this problem next year. 
Input

The input will contain one or more test cases. 
Each test case starts with a line containing two integers: the number of travellers n (2<=n<=20) and the number of transactions t (1<=t<=1000). On the next n lines the names of the travellers are given, one per line. The names only consist of less than 10 alphabetic characters and contain no whitespace. On the following t lines, the transactions are given in the format name1 name2 amount where name1 is the person who gave amount dollars to name2. The amount will always be a non-negative integer less than 10000. 
Input will be terminated by two values of 0 for n and t.
Output

For each test case, first print a line saying "Case #i" where i is the number of the test case. 
Then, on the following lines, print a list of transactions that reverses the transactions given in the input, i.e. balances the accounts again. Use the same format as in the input. Print a blank line after each test case, even after the last one. 
Additional restrictions: 
Your solution must consist of at most n-1 transactions. 
Amounts may not be negative, i.e. never output "A B -20", output "B A 20" instead.

If there is more than one solution satisfying these restrictions, anyone is fine.
Sample Input

2 1
Donald
Dagobert
Donald Dagobert 15
4 4
John
Mary
Cindy
Arnold 
John Mary 100
John Cindy 200
Cindy Mary 40
Cindy Arnold 150
0 0
Sample Output

Case #1
Dagobert Donald 15

Case #2
Mary John 140
Cindy John 10
Arnold John 150
Source

Ulm Local 1998
 */
public class p2257 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int cas = 1;
        while(in.hasNext()) {
            int n = in.nextInt();
            int t = in.nextInt();
            if(n == 0 && t == 0)
                break;
            String[] name = new String[n];
            int[] amt = new int[n];
          //  int[][] relation = new int[n][n];
            HashMap<String,Integer> call = new HashMap();
            for(int i = 0; i < n; i++) {
                name[i] = in.next();
                call.put(name[i], i);
            }
            for(int i = 0; i < t; i++) {
                String name1 = in.next();
                String name2 = in.next();
                int amount = in.nextInt();
                int i1 = call.get(name1);
                int i2 = call.get(name2);
               // relation[i1][i2] = 1;
               // relation[i2][i1] = 1;
                amt[i1] -= amount;
                amt[i2] += amount;                
                
            }
            System.out.printf("Case #%d\n",cas++);
            for(int i = 0; i < n; i++) {
                if(amt[i] > 0) {
                    for(int j = 0; j < n; j++) {
                      //  if(relation[i][j] == 1) {
                            int txn = 0;
                            if(amt[j] < 0) {
                                if(amt[i] <= Math.abs(amt[j])) {
                                    txn = amt[i];
                                    amt[j] += amt[i];
                                    amt[i] = 0;
                                    System.out.printf("%s %s %d\n",name[i],name[j],txn);
                                    break;
                                }
                                else {
                                    txn = Math.abs(amt[j]);
                                    amt[i] += amt[j];
                                    amt[j] = 0;
                                    System.out.printf("%s %s %d\n",name[i],name[j],txn);
                                }
                            }
                     //   }
                    }
                }
            }
            System.out.println();
        }
    }
}
