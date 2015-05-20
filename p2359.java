
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
Questions
Time Limit: 1000MS		Memory Limit: 65536K
Total Submissions: 1161		Accepted: 416
Description

Holding a collegiate programming contest is a very exhausting work. There is a well-known proverb that one fool can ask so many questions that a hundred clever men will not answer. And during a collegiate programming contest questions are asked by one hundred clever people. 

The jury of the Third Urals Collegiate Programming Contest being clever enough has found a simple way to make its work easier. We have invented a simple algorithm that will help us answer ALL your numerous questions! Moreover, this algorithm guarantees that the same questions will have the same answers (this would be hardly possible, if we would undertook such a task ourselves). According to this algorithm a member of the jury starts to delete characters of the question in the following order: 
Starting from the first character he or she counts out N-1 characters (spaces, punctuation marks etc. are considered to be characters too) and deletes the Nth character. 
If a string ends the count continues from the beginning of the string. 
After deleting a character the count restarts from the character that would be the (N+1)-st in the previous count. 
If the last remaining character is a question-mark ("?") then the answer to the question is "Yes". If it is a space then the answer is "No". Any other character will lead to "No comments" answer.

You should help the jury and write a program that will do a hard work of answering your questions tomorrow. The number N is secret and will not be announced even after the end of the contest. Your program should use N=1999. 

For example, taking a string "Is it a good question?" (its length is 22) the characters will be counted in the following way: "Is it a good question?Is it ... quest" and "i" will be deleted. Then the count restarts from "on?Is it..." etc., until "s" will be left (thus the answer is "No comments", as usual).
Input

The input is a question, that is any text file containing at least one character (end of line is not a character). Each character of the input (excepting the ends of lines) is a part of the question. 
The size of the input file is not more than 30000.
Output

The answer.
Sample Input

Sample input #1
Does the jury of this programming contest use the
algorithm described in this problem to answer my questions?

Sample input #2
At least, will anybody READ my question?

Sample input #3
This is
UNFAIR!
Sample Output

Sample output #1
Yes

Sample output #2
No

Sample output #3
No comments

Hint

there are no spaces in the sample inputs except for those between words in one line. Thus the first question contain 108 characters, the second — 40 and the third — 14.
Source

Ural Collegiate Programming Contest 1999,trial tour
 */
public class p2359 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int j = 1;
        ArrayList<Character> tab = new ArrayList();
        while(in.hasNext()) {
            char[] tmp = in.nextLine().toCharArray();
            for(int i = 0; i < tmp.length; i++)
                tab.add(tmp[i]); 
        }
        int N = 1999;
        
    }
}
