
import java.util.HashMap;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
Election
Time Limit: 1000MS		Memory Limit: 65536K
Total Submissions: 3505		Accepted: 1668
Description

Canada has a multi-party system of government. Each candidate is generally associated with a party, and the party whose candidates win the most ridings generally forms the government. Some candidates run as independents, meaning they are not associated with any party. Your job is to count the votes for a particular riding and to determine the party with which the winning candidate is associated.
Input

The first line of input contains a positive integer n satisfying 2 <= n <= 20, the number of candidates in the riding. n pairs of lines follow: the first line in each pair is the name of the candidate, up to 80 characters; the second line is the name of the party, up to 80 characters, or the word "independent" if the candidate has no party. No candidate name is repeated and no party name is repeated in the input. No lines contain leading or trailing blanks. 
The next line contains a positive integer m <= 10000, and is followed by m lines each indicating the name of a candidate for which a ballot is cast. Any names not in the list of candidates should be ignored. 
Output

Output consists of a single line containing one of: 
The name of the party with whom the winning candidate is associated, if there is a winning candidate and that candidate is associated with a party. 
The word "independent" if there is a winning candidate and that candidate is not associated with a party. 
The word "tie" if there is no winner; that is, if no candidate receives more votes than every other candidate.
Sample Input

3
Marilyn Manson
Rhinoceros
Jane Doe
Family Coalition
John Smith
independent
6
John Smith
Marilyn Manson
Marilyn Manson
Jane Doe
John Smith
Marilyn Manson
Sample Output

Rhinoceros
Source

Waterloo local 1999.06.19
 */
public class p2643 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = Integer.valueOf(in.nextLine());
        HashMap<String,String> tab = new HashMap();
        for(int i = 0; i < N ; i++)
            tab.put(in.nextLine(), in.nextLine());
        int num = Integer.valueOf(in.nextLine());
        HashMap<String,Integer> cnt = new HashMap();
        int max = Integer.MIN_VALUE;
        //int prevMax = Integer.MIN_VALUE;
        boolean flag = false;
        String name = new String(new char[81]);
        for(int i = 0; i < num ; i++) {
            String tmp = in.nextLine();
            if(cnt.containsKey(tmp))
                cnt.put(tmp, cnt.get(tmp)+1);
            else
                cnt.put(tmp, 1);
            int cn = cnt.get(tmp);
            if(cn > max) {
                max = cn;
                name = tmp;
               // prevMax = max;
                flag = false;
            }
            else {
                if(cn == max) {
                    flag = true;
                  //  prevMax = cn;
                }
            }
        }
        if(flag) {
            System.out.println("tie");            
        }
        else {
            System.out.println(tab.get(name));            
        }
    }
}
