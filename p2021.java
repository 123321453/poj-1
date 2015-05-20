
import java.util.HashMap;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
Relative Relatives
Time Limit: 1000MS		Memory Limit: 30000K
Total Submissions: 3301		Accepted: 1436
Description

Today is Ted's 100th birthday. A few weeks ago, you were selected by the family to contact all of Ted's descendants and organize a surprise party. To make this task easier, you created an age-prioritized list of everyone descended from Ted. Descendants of the same age are listed in dictionary order. 

The only materials you had to aid you were birth certificates. Oddly enough, these birth certificates were not dated. They simply listed the father's name, the child's name, and the father's exact age when the baby was born.
Input

Input to this problem will begin with line containing a single integer n indicating the number of data sets. Each data set will be formatted according to the following description. 

A single data set has 2 components: 
Descendant Count - A line containing a single integer X (where 0 < X < 100) indicating the number of Ted's descendants. 
Birth Certificate List - Data for X birth certificates, with one certificate's data per line. Each certificate's data will be of the format "FNAME CNAME FAGE" where: 
FNAME is the father's name. 
CNAME is the child's name. 
FAGE is the integer age of the father on the date of CNAMEs birth.

Note: 
Names are unique identifiers of individuals and contain no embedded white space. 
All of Ted's descendants share Ted's birthday. Therefore, the age difference between any two is an integer number of years. (For those of you that are really picky, assume they were all born at the exact same hour, minute, second, etc... of their birth year.) 
You have a birth certificate for all of Ted's descendants (a complete collection).
Output

For each data set, there will be X+1 lines of output. The first will read, "DATASET Y", where Y is 1 for the first data set, 2 for the second, etc. The subsequent X lines constitute your age-prioritized list of Ted's descendants along with their ages using the format "NAME AGE". Descendants of the same age will be listed in dictionary order.
Sample Input

2
1
Ted Bill 25
4
Ray James 40
James Beelzebub 17
Ray Mark 75
Ted Ray 20
Sample Output

DATASET 1
Bill 75
DATASET 2
Ray 80
James 40
Beelzebub 23
Mark 5
Source

South Central USA 2004
 */
public class p2021 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i = 1; i <= n; i++) {
            int t = in.nextInt();
            int[] tab = new int[t];
            HashMap<String,String> rel = new HashMap();
            HashMap<String,Integer> name = new HashMap();
            HashMap<String,Integer> real_age = new HashMap();
            real_age.put("Ted", 100);
            String start;
            int min = Integer.MAX_VALUE;
            for(int j = 0; j < t; j++) {
                String father = in.next();
                String son = in.next();
                int age = in.nextInt();
                rel.put(son, father);
                name.put(son, age);
                
                if(father.equals("Ted")) {
                    if(age < min) {
                        start = son;
                        min = age;
                    }
                }
                
            }
            
            
            
        }
    }
}
