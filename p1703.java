
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
Find them, Catch them
Time Limit: 1000MS		Memory Limit: 10000K
Total Submissions: 23131		Accepted: 6915
Description

The police office in Tadu City decides to say ends to the chaos, as launch actions to root up the TWO gangs in the city, Gang Dragon and Gang Snake. However, the police first needs to identify which gang a criminal belongs to. The present question is, given two criminals; do they belong to a same clan? You must give your judgment based on incomplete information. (Since the gangsters are always acting secretly.) 

Assume N (N <= 10^5) criminals are currently in Tadu City, numbered from 1 to N. And of course, at least one of them belongs to Gang Dragon, and the same for Gang Snake. You will be given M (M <= 10^5) messages in sequence, which are in the following two kinds: 

1. D [a] [b] 
where [a] and [b] are the numbers of two criminals, and they belong to different gangs. 

2. A [a] [b] 
where [a] and [b] are the numbers of two criminals. This requires you to decide whether a and b belong to a same gang. 
Input

The first line of the input contains a single integer T (1 <= T <= 20), the number of test cases. Then T cases follow. Each test case begins with a line with two integers N and M, followed by M lines each containing one message as described above.
Output

For each message "A [a] [b]" in each case, your program should give the judgment based on the information got before. The answers might be one of "In the same gang.", "In different gangs." and "Not sure yet."
Sample Input

1
5 5
A 1 2
D 1 2
A 1 2
D 2 4
A 1 4
Sample Output

Not sure yet.
In different gangs.
In the same gang.
Source

POJ Monthly--2004.07.18
 */
public class p1703 {
    private static int[][] root = new int[100009][2]; 
    public static void init(int N) {
        //root = new int[N+1][2];
        for(int i = 1; i <= N; i++ ) {
            root[i][0] = i;
            root[i][1] = 0;
        }
    }
    
    public static int findP(int i) {
        if(i == root[i][0])
            return i;
        if(i != root[i][0]) {
            root[i][0] = findP(root[i][0]);
        }
        return root[i][0];
    }
    
    public static void union(int x, int y) {
        //int pX = findP(x);
        //int pY = findP(y);
        if(findP(x) == findP(y) || x == y)
            return;
        root[findP(x)][0] = root[findP(y)][0];
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        //Scanner in = new Scanner(System.in);
        //int T = in.nextInt();
        int T = Integer.parseInt(in.readLine());
        for(int i = 0 ; i < T ; i++) {
            String[] ss = in.readLine().split("\\s+");
            int N = Integer.parseInt(ss[0]);
            init(N);
            int M = Integer.parseInt(ss[1]);
            for(int j = 0 ; j < M ; j++) {
                ss = in.readLine().split("\\s+");
                String C = ss[0];
                int a = Integer.parseInt(ss[1]);
                int b = Integer.parseInt(ss[2]);
                if(C.equals("A")) {
                    if(a == b || findP(root[a][0]) == findP(root[b][0]))
                        System.out.println("In the same gang.");
                    else if(findP(root[a][1]) == findP(root[b][0]))
                        System.out.println("In different gangs.");
                    else
                        System.out.println("Not sure yet.");
                }
                if(C.equals("D")) {
                    int d = root[a][1];
                    int e = root[b][1];
                    if(d != 0)
                        union(b,d);
                    root[a][1] = b;
                    if(e != 0)
                        union(a,e);
                    root[b][1] = a;
                    //union(root[a][0], root[b][1]);
                    //union(root[a][1], root[b][0]);
                } 
                    
            }
        }
    }
}
