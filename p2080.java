
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
Calendar
Time Limit: 1000MS		Memory Limit: 30000K
Total Submissions: 9253		Accepted: 3477
Description

A calendar is a system for measuring time, from hours and minutes, to months and days, and finally to years and centuries. The terms of hour, day, month, year and century are all units of time measurements of a calender system. 
According to the Gregorian calendar, which is the civil calendar in use today, years evenly divisible by 4 are leap years, with the exception of centurial years that are not evenly divisible by 400. Therefore, the years 1700, 1800, 1900 and 2100 are not leap years, but 1600, 2000, and 2400 are leap years. 
Given the number of days that have elapsed since January 1, 2000 A.D, your mission is to find the date and the day of the week.
Input

The input consists of lines each containing a positive integer, which is the number of days that have elapsed since January 1, 2000 A.D. The last line contains an integer −1, which should not be processed. 
You may assume that the resulting date won’t be after the year 9999.
Output

For each test case, output one line containing the date and the day of the week in the format of "YYYY-MM-DD DayOfWeek", where "DayOfWeek" must be one of "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday" and "Saturday".
Sample Input

1730
1740
1750
1751
-1
Sample Output

2004-09-26 Sunday
2004-10-06 Wednesday
2004-10-16 Saturday
2004-10-17 Sunday
 */
public class p2080 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd EEEE", Locale.US);
        Date start = new Date(100,0,1,0,0,0);
        Date t1 = new Date(100,0,1,0,0,0);
        Date t2 = new Date(100,0,2,0,0,0);
        long day = t2.getTime() - t1.getTime();
        while(in.hasNext()){
            long dur = in.nextLong();
            if(dur == -1)
                break;
            long now = dur*day + start.getTime();
            Date res = new Date(now);
            System.out.println(sdf.format(res)); 
        }
    }
}
