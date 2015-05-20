
import java.math.BigDecimal;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
Judging Olympia
Time Limit: 1000MS		Memory Limit: 65536K
Total Submissions: 6871		Accepted: 3258
Description

For years, a group of Regional Contest Directors (RCDs) of the ACM International Collegiate Programming Contest (ICPC) have been unsatisfied with the way contest submissions get ranked. The group sees it is academically wrong to emphasize the importance of program correctness, disregarding the “quality” of the program itself. After all, programming as a profession promotes design, style, maintainability, etc. and not just correctness. The group’s suggestion is to have a panel of six judges. Each judge is assigned the task of grading the submissions based on a particular aspect: 1) Correctness; 2) Robustness; 3) Overall design; 4) Clarity; 5) Coding style; and finally 6) Maintainability. The final grade of a submission would be the average of the six grades it gets.

The old guards of the current ICPC judging style have always responded that it is not possible to impartially judge a program on anything but correctness. How can the ICPC be certain that judging is fair? In other words, how can the ICPC be sure that non of the judges is favoring certain teams and disadvantaging others? Any hint of accusation to the judging process and ICPC loses the prestigious status it worked on for years. (Alright! So they do have a point.) Still, this hasn’t stopped other domains from judging candidates based on subjective metrics. Take for example Gymnastics, or The Nobel Prizes, or even the ACM’s very own Doctoral Dissertation Award. These are all highly respected awards where the winner is selected by judges using subjective metrics. ICPC could use a new judging system based on what is used in gymnastics. Rather than having each judge grade a certain aspect of the program, each of the six judges would assign an overall grade (out of ten) based on all of the six metrics mentioned above. To enforce impartiality, the final grade of a submission would be calculated as the average of all the grades after deleting two grades: The highest and the lowest. Any judge that favors a certain team (and assigns them an undeserved high grade,) risks the possibility of that grade being dismissed. Similarly, any judge that attempts to disadvantage a team by assigning them a low grade faces a similar risk.

Write a program to print the final grade of a submission.

Input

Your program will be tested on one or more test cases. Each test case is described on a single input line listing the grades of the judges. The end of the test cases is identified with a dummy test case with all the grades being zero.

Output

For each test case, print the grade on a separate line (without unnecessary decimal points and/or zeros.)

Sample Input

8 8 8 4 4 4
8 8 6 4 4 3
0 0 0 0 0 0
Sample Output

6
5.5
 */
public class p3507 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            int[] panel = new int[6];
            int minI = -1;
            int maxI = -1;
            //boolean flag = true;
            for(int i = 0; i <6 ;i++) {
                panel[i] = in.nextInt();
                if(max < panel[i]) {
                    max = panel[i];
                    maxI = i;
                }
                if(min > panel[i]) {
                    min = panel[i];
                    minI = i;
                }
                if(panel[i] != 0) {
                   // flag = false;
                }
                
            }
            if(panel[0] == 0 && panel[1] ==0 && panel[2] ==0 && panel[3] == 0 && panel[4] == 0 && panel[5] == 0 ) {
                //all are 0
                break;
            }
            else {
                //System.out.println("max: "+panel[maxI] + " min: " + panel[minI]);
                panel[maxI] = 0;
                panel[minI] = 0;
                //Sort array
                double result = 0.0;
                for(int j = 0; j< 6;j++) {
                    result += panel[j];
                }
                result = result/4;
                BigDecimal dec = new BigDecimal(result);
                System.out.println(dec);
            }
           
        }
    }
}
