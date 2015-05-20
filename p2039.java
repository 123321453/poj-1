
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
To and Fro
Time Limit: 1000MS		Memory Limit: 30000K
Total Submissions: 7828		Accepted: 5215
Description

Mo and Larry have devised a way of encrypting messages. They first decide secretly on the number of columns and write the message (letters only) down the columns, padding with extra random letters so as to make a rectangular array of letters. For example, if the message is "There’s no place like home on a snowy night" and there are five columns, Mo would write down 
t o i o y

h p k n n

e l e a i

r a h s g

e c o n h

s e m o t

n l e w x

Note that Mo includes only letters and writes them all in lower case. In this example, Mo used the character "x" to pad the message out to make a rectangle, although he could have used any letter. 

Mo then sends the message to Larry by writing the letters in each row, alternating left-to-right and right-to-left. So, the above would be encrypted as 

toioynnkpheleaigshareconhtomesnlewx 

Your job is to recover for Larry the original message (along with any extra padding letters) from the encrypted one. 
Input

There will be multiple input sets. Input for each set will consist of two lines. The first line will contain an integer in the range 2. . . 20 indicating the number of columns used. The next line is a string of up to 200 lower case letters. The last input set is followed by a line containing a single 0, indicating end of input.
Output

Each input set should generate one line of output, giving the original plaintext message, with no spaces.
Sample Input

5
toioynnkpheleaigshareconhtomesnlewx
3
ttyohhieneesiaabss
0
Sample Output

theresnoplacelikehomeonasnowynightx
thisistheeasyoneab
Source

East Central North America 2004
 */
public class p2039 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int N = in.nextInt();
            if(N == 0)
                break;
            String tmp = in.next();
            char[][] tab = new char[tmp.length()/N][N];
            for(int i = 0 ; i < tmp.length()/N; i++) {
                for(int j = 0; j < N ; j++) {
                    if(i%2 == 0)
                        tab[i][j] = tmp.charAt(i*N+j);
                    else
                        tab[i][j] = tmp.charAt(i*N+N-j-1);
                    //System.out.print(tab[i][j]+" ");
                }
                //System.out.println();
            }
           // System.out.println();
            StringBuffer res = new StringBuffer();
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < tmp.length()/N; j++) {
                 //   System.out.print(tab[j][i]+" ");
                    res.append(tab[j][i]);
                }
               // System.out.println();
            }
            //String output = new String(res);
            System.out.println(res);
        }
    }
}
