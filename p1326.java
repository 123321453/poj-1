
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
Mileage Bank
Time Limit: 1000MS		Memory Limit: 10000K
Total Submissions: 12421		Accepted: 5182
Description

Mileage program of ACM (Airline of Charming Merlion) is really nice for the travelers flying frequently. Once you complete a flight with ACM, you can earn ACMPerk miles in your ACM Mileage Bank depended on mileage you actual fly. In addition, you can use the ACMPerk mileage in your Mileage Bank to exchange free flight ticket of ACM in future. 



The following table helps you calculate how many ACMPerk miles you can earn when you fly on ACM. 

When you fly ACM		 Class Code	          You'll earn

 

First Class			 F		 Actual mileage + 100% mileage Bonus

 

Business Class		   	 B		 Actual mileage + 50% mileage Bonus

 

Economy Class			 Y

1-500 miles					 500 miles

500+ miles					 Actual mileage

It's shown that your ACMPerk mileage consists of two parts. One is your actual flight mileage (the minimum ACMPerk mileage for Economy Class for one flight is 500 miles), the other is the mileage bonus (its accuracy is up to 1 mile) when you fly in Business Class and First Class. For example, you can earn 1329 ACMPerk miles, 1994 ACMPerk miles and 2658 ACMPerk miles for Y, B or F class respectively for the fly from Beijing to Tokyo (the actual mileage between Beijing and Tokyo is 1329 miles). When you fly from Shanghai to Wuhan, you can earn ACMPerk 500 miles for economy class and ACMPerk 650 miles for business class (the actual mileage between Shanghai and Wuhan is 433 miles). 



Your task is to help ACM build a program for automatic calculation of ACMPerk mileage. 
Input

The input file contains several data cases. Each case has many flight records, each per line. The flight record is in the following format: 

OriginalCity DistanceCity ActualMiles ClassCode 

Each case ends with a line of one zero. 

A line of one # presents the end of the input file. 
Output

Output the summary of ACMPerk mileages for each test case, one per line.
Sample Input

Beijing Tokyo 1329 F
Shanghai Wuhan 433 Y
0
#
Sample Output

3158
Hint

When calculate bonus ,be sure you rounded x.5 up to x+1
Source

Beijing 2002
 */
public class p1326 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int result = 0;
        while(in.hasNext()){
            String orgC = in.next();
            if(orgC.equals("#"))
                break;
            else if(orgC.equals("0")){
                System.out.println((int)Math.round((double)result));
                result = 0;
            }
            else {
                String disC = in.next();
                int mile = in.nextInt();
                String cal = in.next();
                if(cal.equals("F")){
                    result += mile*2;
                }
                else if(cal.equals("B")){
                    if(mile%2 == 0)
                        result += (mile + mile/2);
                    else
                        result += (mile + mile/2 + 1);
                }
                else {
                    if(mile <= 500)
                        result += 500;
                    else
                        result += mile;
                }
            }
        }
    }
}
