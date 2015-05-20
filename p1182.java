
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
食物链
Time Limit: 1000MS		Memory Limit: 10000K
Total Submissions: 32372		Accepted: 9439
Description

动物王国中有三类动物A,B,C，这三类动物的食物链构成了有趣的环形。A吃B， B吃C，C吃A。 
现有N个动物，以1－N编号。每个动物都是A,B,C中的一种，但是我们并不知道它到底是哪一种。 
有人用两种说法对这N个动物所构成的食物链关系进行描述： 
第一种说法是"1 X Y"，表示X和Y是同类。 
第二种说法是"2 X Y"，表示X吃Y。 
此人对N个动物，用上述两种说法，一句接一句地说出K句话，这K句话有的是真的，有的是假的。当一句话满足下列三条之一时，这句话就是假话，否则就是真话。 
1）	当前的话与前面的某些真的话冲突，就是假话； 
2）	当前的话中X或Y比N大，就是假话； 
3）	当前的话表示X吃X，就是假话。 
你的任务是根据给定的N（1 <= N <= 50,000）和K句话（0 <= K <= 100,000），输出假话的总数。 
Input

第一行是两个整数N和K，以一个空格分隔。 
以下K行每行是三个正整数 D，X，Y，两数之间用一个空格隔开，其中D表示说法的种类。 
若D=1，则表示X和Y是同类。 
若D=2，则表示X吃Y。
Output

只有一个整数，表示假话的数目。
Sample Input

100 7
1 101 1 
2 1 2
2 2 3 
2 3 3 
1 1 3 
2 3 1 
1 5 5
Sample Output

3
Source

Noi 01
* 
* 
* 本人用并查集解的，推导相互之间的关系时废了很长时间。以下这个小技巧或许可以帮助大家少走一点弯路

kind[a]=0表示a与父节点属于同一类。kind[a]=1表示a吃父节点。kind[a]=2表示父节点吃a。 （后二种情况下的赋值可以改变，但对后续有点小影响）

1.有一种关系b是a父节点，c是b父节点，  a与c的关系可以表示为 (kind[a]+kind[b])%3    （延续性，适用于多个节点的延续，如3个节点根据二次计算即可完成）

2.b是a的父节点，表示为kind[a].  若父子节点相互反转，即a是b的父节点，kind[b]=(3-kind[a])%3  （反转性）

根据延续性和反转性可计算任何两个节点之间的关系，以下是几个例子：

现在讨论并查集中用到关系的3中情况：
(i):find中的更新，x的父节点是y，y的父节点为根节点，将关系更新为x的父节点为根节点，表示为：kind[x]=(kind[x]+kind[y])%3;
(ii)并查集中的合并。  假设x的父节点是xx  y的父节点是yy  x和y的关系为d。
若将xx的父节点更新为yy，则 kind[xx]=kind[x]的反转（即xx的父节点为x）+d（x的父节点为y）+kind[y]（y的父节点为yy），
简化为kind[xx]=(3-kind[x]+d+kind[y])%3.
(iii)并查集中判断x，y是否冲突
x和y的父节点都为同一个根节点，知道kind[x],kind[y],d（表示x和y的关系）
  3-kind[x](x的反转，根节点->x)+d（x->y）+kind[y](y->根节点)  根据延续性这个式子表示为  根节点->根节点的关系  即 （3-kind[x]+d+kind[y])%3==0
 * key is when D is 1, means X and Y same, so rank[Y] = 0(based on X)
 * when D = 2, rank[Y](w) = 1;
 */
public class p1182 {
    private static final int Max = 50005;
    private static int[] p ;
    private static int[] rank ;
    
    public static void  init(int N) {
        p = new int[N+1];
        rank = new int[N+1];
        for(int i = 1 ; i <= N; i++) {
            p[i] = i;
            rank[i] = 0;
        }
    }
    public static int findP(int i) {
        int tmp = p[i];
        if(i != tmp) {
            p[i] = findP(tmp);
            rank[i] = (rank[tmp] + rank[i]) %3;
        }
        return p[i];
    }
    
    public static void union(int X, int Y, int D) {
        int pX = findP(X);
        int pY = findP(Y);
        p[pY] = pX;
        rank[pY] = ( rank[X] - rank[Y] +D + 3)%3;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int K = in.nextInt();
        init(N);
        int cnt = 0;
        for(int i = 0; i < K; i++) {
            int D = in.nextInt();
            int X = in.nextInt();
            int Y = in.nextInt();
            if(X > N || Y > N) {
                cnt++;
                continue;
            }
            else if ( X == Y && D == 2) {
                cnt++;
                continue;
            }
            else {
                int pX = findP(X);
                int pY = findP(Y);
                if(D == 1) {
                    if(pX == pY && rank[X] != rank[Y]) {
                        cnt++;
                        continue;
                    }
                    else {
                        union(X,Y, 0);
                    }
                }
                else {
                    if(pX == pY && (rank[X] +1 )%3 != rank[Y]) {
                        cnt++;
                        continue;
                    }
                    else {
                        union(X,Y,1);
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}
