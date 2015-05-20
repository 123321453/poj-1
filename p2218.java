
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
Does This Make Me Look Fat?
Time Limit: 1000MS		Memory Limit: 65536K
Total Submissions: 2229		Accepted: 1001
Description

As the host of a popular daytime television talk show, you are working through the details of an upcoming episode on dieting. Your guest is the controversial Dr. Kevorkian, who has recently invented his own weight-loss plan, "Do You Want To Diet?" that guarantees to reduce your body weight by 1 pound every day. 

You have a number of dieters scheduled to be on the show who have all been using Dr. Kevorkian?s new plan. You want to make the episode more dramatic by introducing your guests in decreasing order of their weights on the day of the show. The problem is that the forms you had them fill out only requested the following information: Name, Days on the diet, Weight at start of diet. Hopefully you can dredge up those long-forgotten math skills before the filming time tonight!
Input

Input to this problem will consist of a (non-empty) series of up to 100 data sets. Each data set will be formatted according to the following description, and there will be no blank lines separating data sets. 

A single data set has 3 components: 
Start line - A single line, "START" 
Dieter list - A series of 1 to 10 (inclusive) single lines consisting of three fields, with each field separated from the others by a single space: 
Name - The dieter?s first name. This will be a text string containing 1 to 20 (inclusive) alphanumeric characters (no spaces). 
Days On Diet - The number of days the dieter has been on the "Do You Want To Diet" as of the day of the talk show. This will be a non-zero positive integer strictly less than 1000. 
Starting Weight - The weight, in pounds, of the dieter just before starting the diet. This will be a non-zero positive integer strictly less than 10,000.

End line - A single line, "END"

Here are some facts that may be useful: 
All dieters lost exactly 1 pound every day they were on the diet, as advertised. 
Nobody stayed on the diet long enough to weigh less than 1 pound at the time of the show. 
All dieters in a given input set will have different weights on the day of the show. 
All dieters in a given input set will have different names.

Output

For each input data set, there will be exactly one output set, and there will be exactly one blank line separating output sets. 

A single output set consists of a series of lines, each containing the Name of one of the dieters from the Dieter list. The list will be sorted in descending order according to weight at the time of the TV show. All dieters must be listed.
Sample Input

START
Joe 10 110
END
START
James 100 150
Laura 100 140
Hershey 100 130
END
START
Hershey0 1 5
Hershey2 1 3
Hershey1 1 4
Hershey3 1 2
END
Sample Output

Joe

James
Laura
Hershey

Hershey0
Hershey1
Hershey2
Hershey3
Source

South Central USA 2001
 */
public class p2218 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            String start = in.next();
            //ArrayList<String> name = new ArrayList();
            ArrayList<Integer> weight = new ArrayList();
            HashMap<Integer,String> tab = new HashMap();
            while(true) {
                String name1 = in.next();
                if(name1.equals("END"))
                    break;
                int day = in.nextInt();
                int startW = in.nextInt();
                //name.add(name1);
                if(startW-day >= 1)
                    weight.add(startW-day);
                else
                    weight.add(1);
                tab.put(startW-day, name1);                
            }
            Object[] ls = weight.toArray();
            //ls = (int[])ls;
            Arrays.sort(ls);
            for(int i = ls.length-1; i >= 0; i--) {
                System.out.println(tab.get(ls[i]));
            }
            System.out.println();
            
        }
    }
}
