
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * 
 * Biorhythms
Time Limit: 1000MS		Memory Limit: 10000K
Total Submissions: 94587		Accepted: 29061
Description

Some people believe that there are three cycles in a person's life that start the day he or she is born. These three cycles are the physical, emotional, and intellectual cycles, and they have periods of lengths 23, 28, and 33 days, respectively. There is one peak in each period of a cycle. At the peak of a cycle, a person performs at his or her best in the corresponding field (physical, emotional or mental). For example, if it is the mental curve, thought processes will be sharper and concentration will be easier. 
Since the three cycles have different periods, the peaks of the three cycles generally occur at different times. We would like to determine when a triple peak occurs (the peaks of all three cycles occur in the same day) for any person. For each cycle, you will be given the number of days from the beginning of the current year at which one of its peaks (not necessarily the first) occurs. You will also be given a date expressed as the number of days from the beginning of the current year. You task is to determine the number of days from the given date to the next triple peak. The given date is not counted. For example, if the given date is 10 and the next triple peak occurs on day 12, the answer is 2, not 3. If a triple peak occurs on the given date, you should give the number of days to the next occurrence of a triple peak. 
Input

You will be given a number of cases. The input for each case consists of one line of four integers p, e, i, and d. The values p, e, and i are the number of days from the beginning of the current year at which the physical, emotional, and intellectual cycles peak, respectively. The value d is the given date and may be smaller than any of p, e, or i. All values are non-negative and at most 365, and you may assume that a triple peak will occur within 21252 days of the given date. The end of input is indicated by a line in which p = e = i = d = -1.
Output

For each test case, print the case number followed by a message indicating the number of days to the next triple peak, in the form: 

Case 1: the next triple peak occurs in 1234 days. 

Use the plural form ``days'' even if the answer is 1.
Sample Input

0 0 0 0
0 0 0 100
5 20 34 325
4 5 6 7
283 102 23 320
203 301 203 40
-1 -1 -1 -1
Sample Output

Case 1: the next triple peak occurs in 21252 days.
Case 2: the next triple peak occurs in 21152 days.
Case 3: the next triple peak occurs in 19575 days.
Case 4: the next triple peak occurs in 16994 days.
Case 5: the next triple peak occurs in 8910 days.
Case 6: the next triple peak occurs in 10789 days.
Source
 */

public class p1006 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        //String input = in.nextLine();
        int p,e,i,d;
        String input = null;
        String[] arr;
        int cnt = 1;
        int tp = 0;
        int result = 0;
       // List<Integer> ls = new ArrayList<Integer>();
        while(in.hasNext()) {
            input = in.nextLine();
            arr = input.split("\\s+");
            p = Integer.parseInt(arr[0]);
            e = Integer.parseInt(arr[1]);
            i = Integer.parseInt(arr[2]);
            d = Integer.parseInt(arr[3]);
            if((p == e) && (e == i) && (i ==d) && (d == -1))
                break;
            for(tp = 0;tp <= 21252;tp++) {
                if(((tp - p) %23 == 0)&& ((tp - e) %28 == 0) && ((tp - i) %33 == 0))
                    break;
            }
            result = ((tp - d) <= 0 )? (tp-d+21252):((tp - d) > 21252 ? 21252 : (tp-d));// ((tp-d) > 21252)? 21252: (tp-d)); 
          //  ls.add(result);
            System.out.println("Case "+ (cnt++) + ": the next triple peak occurs in " + result + " days.");
        }
        
    }
}