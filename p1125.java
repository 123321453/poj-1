
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
Stockbroker Grapevine
Time Limit: 1000MS		Memory Limit: 10000K
Total Submissions: 22026		Accepted: 12029
Description

Stockbrokers are known to overreact to rumours. You have been contracted to develop a method of spreading disinformation amongst the stockbrokers to give your employer the tactical edge in the stock market. For maximum effect, you have to spread the rumours in the fastest possible way. 

Unfortunately for you, stockbrokers only trust information coming from their "Trusted sources" This means you have to take into account the structure of their contacts when starting a rumour. It takes a certain amount of time for a specific stockbroker to pass the rumour on to each of his colleagues. Your task will be to write a program that tells you which stockbroker to choose as your starting point for the rumour, as well as the time it will take for the rumour to spread throughout the stockbroker community. This duration is measured as the time needed for the last person to receive the information.
Input

Your program will input data for different sets of stockbrokers. Each set starts with a line with the number of stockbrokers. Following this is a line for each stockbroker which contains the number of people who they have contact with, who these people are, and the time taken for them to pass the message to each person. The format of each stockbroker line is as follows: The line starts with the number of contacts (n), followed by n pairs of integers, one pair for each contact. Each pair lists first a number referring to the contact (e.g. a '1' means person number one in the set), followed by the time in minutes taken to pass a message to that person. There are no special punctuation symbols or spacing rules. 

Each person is numbered 1 through to the number of stockbrokers. The time taken to pass the message on will be between 1 and 10 minutes (inclusive), and the number of contacts will range between 0 and one less than the number of stockbrokers. The number of stockbrokers will range from 1 to 100. The input is terminated by a set of stockbrokers containing 0 (zero) people. 

Output

For each set of data, your program must output a single line containing the person who results in the fastest message transmission, and how long before the last person will receive any given message after you give it to this person, measured in integer minutes. 
It is possible that your program will receive a network of connections that excludes some persons, i.e. some people may be unreachable. If your program detects such a broken network, simply output the message "disjoint". Note that the time taken to pass the message from person A to person B is not necessarily the same as the time taken to pass it from B to A, if such transmission is possible at all.
Sample Input

3
2 2 4 3 5
2 1 2 3 6
2 1 2 2 2
5
3 4 4 2 8 5 3
1 5 8
4 1 6 4 10 2 7 5 2
0
2 2 5 1 5
0
Sample Output

3 2
3 10
Source

Southern African 2001
 */
public class p1125 {
    private static int[][] person;
    private static int min( int a, int b) {
        if(a < b)
            return a;
        else
            return b;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        person = new int[101][101];
        while(in.hasNext()) {
            int num = in.nextInt();
            if(num == 0)
                break;
            int i,j;
            for(i = 1; i <= num; i++) {
                for(j = 1; j <= num; j++) {
                    if(i == j) 
                        person[i][j] = 0;
                    else
                        person[i][j] = 10000;
                }
            }
            int input1,input2;
            for(i = 1; i <= num; i++) {
                int N = in.nextInt();
                for(j = 1; j <= N; j++) {
                    input1 = in.nextInt();
                    input2 = in.nextInt();
                    person[i][input1] = input2;
                }
            }
            for(i = 1; i <= num; i++) {
                for(j = 1; j <= num; j++) {
                    for(int t = 1; t <= num; t++) {
                        person[j][t] = min((person[j][i] + person[i][t]), person[j][t]);
                    }
                }
            }
            int[] maxNum = new int[101];
            boolean disJ = true;
            for(i = 1; i <= num ; i++) {
                for(j = 1; j <= num; j++) {
                    if(person[j][i] != 10000) {
                        //System.out.println("disjoint");
                        //continue;
                        disJ = false;
                    }
                    if(person[i][j] > maxNum[i]) {
                        maxNum[i] = person[i][j];
                    }
                }
            }
            int minN = -1;
            int minD = Integer.MAX_VALUE;

            for(i = 1; i <= num; i++) {
                if(minD > maxNum[i]) {
                    minD = maxNum[i];
                    minN = i;
                }
            }
          // if(!disJ)
                System.out.println(minN+" " + minD);
          // else
            //    System.out.println("disjoint");
        }
    }
}
