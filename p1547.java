
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 Clay Bully
Time Limit: 1000MS		Memory Limit: 10000K
Total Submissions: 7746		Accepted: 4352
Description

Ms. Terry is a pre-school art teacher who likes to have her students work with clay. One of her assignments is to form a lump of clay into a block and then measure the dimensions of the block. However, in every class, there is always one child who insists on taking some clay from some other child. Since Ms. Terry always gives every child in a class the same amount of clay to begin with, you can write a program that helps Ms. Terry find the bully and victim after she measures each child's finished block.
Input

There are one or more classes of students, followed by a final line containing only the value -1. Each class starts with a line containing an integer, n, which is the number of students in the class, followed by n lines of student information. Each line of student information consists of three positive integers, representing the dimensions of the clay block, followed by the student's first name. There can never be more than 9 students nor less than 2 students in any class. Each student's name is at most 8 characters. Ms. Terry always gives each student at most 250 cubic units of clay. There is exactly one bully and one victim in each class.
Output

For each class print a single line exactly as shown in the sample output.
Sample Input

3
10 10 2 Jill
5 3 10 Will
5 5 10 Bill
4
2 4 10 Cam
4 3 7 Sam
8 11 1 Graham
6 2 7 Pam
-1
Sample Output

Bill took clay from Will.
Graham took clay from Cam.
Source

Mid-Central USA 2003
 */
public class p1547 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            int num = in.nextInt();
            if(num == -1)
                break;
            String[] name = new String[num];
            int[] vol = new int[num];
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            int maxID = -1;
            int minID = -1;
            for(int i=0; i < num;i++){
                vol[i] = in.nextInt()*in.nextInt()*in.nextInt();
                if(min > vol[i]) {
                    min = vol[i];
                    minID = i;
                }
                if(max < vol[i]) {
                    max = vol[i];
                    maxID = i;
                }
                name[i] = in.next();
            }
            System.out.printf("%s took clay from %s.\n",name[maxID],name[minID]);
        }
    }
}
