
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
Elementary Additions
Time Limit: 5000MS		Memory Limit: 65536K
Total Submissions: 2357		Accepted: 1315
Description

In today's environment, students rely on calculators and computers to perform simple arithmetic too much. Sadly, it is not uncommon to see university students who cannot do simple arithmetic without electronic aids. Professor Peano has had enough. He has decided to take the matter into his own hands and force his students to become proficient in the most basic arithmetic skill: addition of non-negative integers. Since the students do not have a good foundation in this skill, he decided to go back to the basics and represent non-negative integers with set theory.

The non-negative integers are represented by the following sets:

0 is represented by the empty set {}.
For any number n > 0, n is represented by a set containing the representations of all non-negative integers smaller than n.
For example, the first 4 non-negative integers are represented by:


  0 => {}
  1 => {{}}
  2 => {{},{{}}}
  3 => {{},{{}},{{},{{}}}}

and so on. Notice that the cardinality (size) of the set is exactly the integer it represents. Although the elements of a set are generally unordered, Professor Peano requires that the elements of a set be ordered in increasing cardinality to make the assignments easier to grade. As an added advantage, Professor Peano is sure that there are no calculators or computer programs that can deal with numbers written in this notation.
Not surprisingly, many students cannot cope with this basic task and will fail the course if they do not get help soon. It is up to you, an enterprising computer science student, to help them. You have decided to write a computer program, codenamed Axiomatic Cheating Machine (ACM), to sell to the students and help them perform the additions to pass the course.

Input

The first line of the input contains a positive integer giving the number of cases to follow. For each case, there are two lines of input each containing a non-negative integer represented in set notation. Each line contains only the characters '{', '}', and ','. The sum of the two given integers will be at most 15.
Output

For each test case, output the sum of the two input integers in the set notation described above.
Sample Input

3
{}
{}
{{}}
{{},{{}}}
{{},{{}},{{},{{}}}}
{{}}
Sample Output

{}
{{},{{}},{{},{{}}}}
{{},{{}},{{},{{}}},{{},{{}},{{},{{}}}}}
Source

Rocky Mountain 2007

 */
public class p3445 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        String[] tab = new String[16];
        tab[0] = "{}";
        tab[1] = "{{}}";
        HashMap<String,Integer> tmp =  new HashMap();
        tmp.put(tab[0], 0);
        tmp.put(tab[1], 1);
        for(int i = 2; i <=15; i++) {
            StringBuffer lst =  new StringBuffer();
            lst.append("{");
            for(int j = 0; j <= i-1; j++) {
                lst.append(tab[j]);
                if(j != i-1)
                    lst.append(",");
                else
                    break;
            }
            lst.append("}");
            tab[i] = new String(lst);
            tmp.put(tab[i], i);
        }
        for(int i = 0; i < N; i++) {
            String a = in.next();
            int at = tmp.get(a);
            String b = in.next();
            int bt = tmp.get(b);
            int result = at+bt;
            System.out.println(tab[result]);
        }
    }
}
