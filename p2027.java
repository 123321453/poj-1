
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
No Brainer
Time Limit: 1000MS		Memory Limit: 30000K
Total Submissions: 21031		Accepted: 13866
Description

Zombies love to eat brains. Yum.
Input

The first line contains a single integer n indicating the number of data sets. 

The following n lines each represent a data set. Each data set will be formatted according to the following description: 

A single data set consists of a line "X Y", where X is the number of brains the zombie eats and Y is the number of brains the zombie requires to stay alive. 
Output

For each data set, there will be exactly one line of output. This line will be "MMM BRAINS" if the number of brains the zombie eats is greater than or equal to the number of brains the zombie requires to stay alive. Otherwise, the line will be "NO BRAINS".
Sample Input

3
4 5
3 3
4 3
Sample Output

NO BRAINS
MMM BRAINS
MMM BRAINS
 */
public class p2027 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        String[] arr;
        int x,y;
        for(int i = 0; i < n; i++){
            arr = in.nextLine().split("\\s+");
            x = Integer.parseInt(arr[0]);
            y = Integer.parseInt(arr[1]);
            if(x < y)
                System.out.println("NO BRAINS");
            else
                System.out.println("MMM BRAINS");
        }
    }
    
}
