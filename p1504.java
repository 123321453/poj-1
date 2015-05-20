
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 Adding Reversed Numbers
Time Limit: 1000MS		Memory Limit: 10000K
Total Submissions: 12417		Accepted: 6870
Description

The Antique Comedians of Malidinesia prefer comedies to tragedies. Unfortunately, most of the ancient plays are tragedies. Therefore the dramatic advisor of ACM has decided to transfigure some tragedies into comedies. Obviously, this work is very hard because the basic sense of the play must be kept intact, although all the things change to their opposites. For example the numbers: if any number appears in the tragedy, it must be converted to its reversed form before being accepted into the comedy play. 

Reversed number is a number written in arabic numerals but the order of digits is reversed. The first digit becomes last and vice versa. For example, if the main hero had 1245 strawberries in the tragedy, he has 5421 of them now. Note that all the leading zeros are omitted. That means if the number ends with a zero, the zero is lost by reversing (e.g. 1200 gives 21). Also note that the reversed number never has any trailing zeros. 

ACM needs to calculate with reversed numbers. Your task is to add two reversed numbers and output their reversed sum. Of course, the result is not unique because any particular number is a reversed form of several numbers (e.g. 21 could be 12, 120 or 1200 before reversing). Thus we must assume that no zeros were lost by reversing (e.g. assume that the original number was 12).
Input

The input consists of N cases. The first line of the input contains only positive integer N. Then follow the cases. Each case consists of exactly one line with two positive integers separated by space. These are the reversed numbers you are to add.
Output

For each case, print exactly one line containing only one integer - the reversed sum of two reversed numbers. Omit any leading zeros in the output.
Sample Input

3
24 1
4358 754
305 794
Sample Output

34
1998
1
 */

public class p1504 {
    public static int reverse(String n){
        StringBuffer tmp = new StringBuffer();
        for(int i = n.length()-1; i >= 0 ; i--) {
            tmp.append(n.charAt(i));
        }
        return Integer.valueOf(new String(tmp));
        //return 0;
    }
    
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        //String input;
        //String[] arr;
       // int a,b,sum;
        String a,b;
        int sum;
        for(int i = 0; i < num; i++) {
            //arr = in.nextLine().split("\\s+");
            
            //sum = reverse(a) + reverse(b);
            //System.out.println(reverse(sum));
            a = in.next();
            b = in.next();
            sum = reverse(a) + reverse(b);
            System.out.println(reverse(String.valueOf(sum)));
            //System.out.println(sum);
            
        }
    }
    
}
