
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
Above Average
Time Limit: 1000MS		Memory Limit: 65536K
Total Submissions: 13309		Accepted: 6980
Description

It is said that 90% of frosh expect to be above average in their class. You are to provide a reality check.
Input

The first line of standard input contains an integer C, the number of test cases. C data sets follow. Each data set begins with an integer, N, the number of people in the class (1 <= N <= 1000). N integers follow, separated by spaces or newlines, each giving the final grade (an integer between 0 and 100) of a student in the class.
Output

For each case you are to output a line giving the percentage of students whose grade is above average, rounded to 3 decimal places.
Sample Input

5
5 50 50 70 80 100
7 100 95 90 80 70 60 50
3 70 90 80
3 70 90 81
9 100 99 98 97 96 95 94 93 91
Sample Output

40.000%
57.143%
33.333%
66.667%
55.556%
 */
public class p2350 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = Integer.valueOf(in.nextLine());
        for(int i = 0 ; i < num ; i++){
            int nStud = in.nextInt();
            int[] tab = new int[nStud];
            int sum = 0;
            for(int j = 0; j < nStud ; j++){
                tab[j] = in.nextInt();
                sum += tab[j];
            }
            double avg = sum/nStud;
            int count = 0;
            for(int j = 0; j < nStud ; j++){
                if(tab[j] > avg) {
                    count++;
                }
            }
           // System.out.println(count+" "+nStud); 
            double output = ((double)count/(double)nStud)*100;
            System.out.printf("%.3f",output);
            System.out.println("%");
        }
    }
}
