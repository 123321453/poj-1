
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
宇航员
Time Limit: 2000MS		Memory Limit: 30000K
Total Submissions: 3716		Accepted: 1610
Description

问题描述： 
　　宇航员在太空中迷失了方向，在他的起始位置现在建立一个虚拟xyz坐标系，称为绝对坐标系，宇航员正面的方向为x轴正方向，头顶方向为z轴正方向，则宇航员的初始状态如下图所示： 


现对六个方向分别标号，x，y，z正方向分别为0，1，2，负方向分别为3，4，5；称它们为绝对方向。宇航员在宇宙中只沿着与绝对坐标系xyz轴平行的方向行走，但是他不知道自己当前绝对坐标和自己面向的绝对方向。 

任务描述： 
　　请根据宇航员对自己在相对方向上移动的描述确定宇航员最终的绝对坐标和面向的绝对方向。对在相对方向上移动的描述及意义如下： 
forward x 　向前走x米。 
back x　先转向后，再走x米。 
left x 先转向左，再走x米。 
right x 先转向右，再走x米。 
up x 先面向上，再走x米。 
down x 先面向下，再走x米。 
其中向上和向下如下图所示： 

Input

第一行一个正整数m，表示测试数据的组数。每组测试数据第一行是一个正整数n(1<=n<=10000)表示宇航员行走的次数，下面n行每行输入一次相对行走，格式如上所述，其中( 1 <= x <= 10000 为正整数)。
Output

对于每组输入数据输出一行，x y z p, 中间用空格隔开，x y z是宇航员的位置的绝对坐标，p是宇航员面向的绝对方向编号（0<=p <=5）。
Sample Input

1
6
left 10
right 11
up 12
down 13
forward 14
back 15
Sample Output

23 -10 12 3
Source

qinlu@POJ
 */
public class p1835 {
    private static int step,x,y,z,left,right,up,down,back,forward;
    public static void move(int dir, int reach) {
        if (dir == 0) {
            x += reach;
        }
        if (dir == 1) {
            y += reach;
        }
        if (dir == 2) {
            z += reach;
        }
        if (dir == 3) {
            x -= reach;
        }
        if (dir == 4) {
            y -= reach;
        }
        if (dir == 5) {
            z -= reach;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int temp;
        int num = in.nextInt();
        
        for(int i = 0; i < num; i++) {
            int N = in.nextInt();
            x = 0;
            y = 0;
            z = 0;
            forward = 0;
            left = 4;
            right = 1;
            up = 2;
            down = 5;
            back = 3;
            for(int j = 0; j < N; j++) {
                String dir = in.next();
                step = in.nextInt();
                if(dir.equals("forward")) {
                    move(forward,step);
                }
                if(dir.equals("back")) {
                    move(back,step);
                    temp = back;
                    back = forward;
                    forward = temp;
                    temp = left;
                    left = right;
                    right = temp;
                }
                if(dir.equals("left")) {
                    move(left,step);
                    temp= forward;
                    forward = left;
                    left = back;
                    back = right;
                    right = temp;
                }
                if(dir.equals("right")) {
                    move(right, step);
                    temp = forward;
                    forward = right;
                    right = back;
                    back = left;
                    left = temp;
                }
                if(dir.equals("up")) {
                    
                    move(up, step);
                    temp = forward;
                    forward = up;
                    up = back;
                    back = down;
                    down = temp;
                }
                if(dir.equals("down")) {
                    
                    move(down, step);
                    temp = forward;
                    forward = down;
                    down = back;
                    back = up;
                    up = temp;
                }
            }
            System.out.println(x+" "+y+" "+z+" "+forward);
        }
    }
}
