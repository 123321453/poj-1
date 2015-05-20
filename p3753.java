
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
根据关键字进行字符串拷贝
Time Limit: 1000MS		Memory Limit: 65536K
Total Submissions: 4541		Accepted: 1000
Description

把源字符串拷贝到目的字符串，如果指定关键字，则以该关键字结束(不包括关键字本身)，如果拷贝失败，则得到空串。 
具体要求：实现如下函数原型SafeStrcpy2KeyWord()，并在代码中调用该函数实现上述功能。该函数的实现要考虑各种可能的参数取值，以确保程序不出现崩溃。 


int SafeStrcpy2KeyWord(char* pDestBuffer,	//拷贝的目的地地址

		       char* pSourceString,	//拷贝的源地址

		       int nDestBufferSize,	//拷贝的目的地缓冲区长度

		       char* szKeyWord);	//指定关键字符串

返回值：所拷贝的字符串长度。如果拷贝失败，则返回0。
Input

输入包含多组数据，以EOF结束 
每组数据第一行为不含空格的源字符串，长度小于256；接下来的一行或多行都是关键字串（长度小于16），一直到END结束。“NULL”表示关键字串为空，此时输出的拷贝后的长度应为0，拷贝后的字符串为空串（也用”NULL”表示，见下文）。
Output

对于每组数据输出拷贝的长度和拷贝后的目的字符串，以空格分隔。如果该目的字符串为空，则用”NULL”表示。
Sample Input

/home/tony/work_server/1/rtest/relayer.out
/
/t
/1/r
.
NULL
END
Sample Output

0 NULL
5 /home
22 /home/tony/work_server
38 /home/tony/work_server/1/rtest/relayer
0 NULL
Source
 */
public class p3753 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            String tmp = in.nextLine();
            while(true) {
                String tmp1 = in.nextLine();
                if(tmp1.equals("END")) {
                    break;
                }
                boolean flag = true;
                int index = -1;
                for(int i = 0; i < tmp.length() ; i++) {
                    if(!flag) {
                        index = i-1;
                        break;
                    }
                    for(int j = i; j < i+ tmp1.length() ; j++) {
                        if(tmp.charAt(j) != tmp1.charAt(j-i)) {
                            flag = true;
                            break;
                        }
                        else {
                            flag = false;
                            continue;
                        }
                    }
                    
                }
                StringBuffer ne = new StringBuffer();
                for(int i = 0; i < index; i++) {
                    ne.append(tmp.charAt(i));
                }
                String res = ne.toString();
                if(tmp1.equals("NULL")) {
                    System.out.println("0 NULL");
                }
                else if (tmp1.isEmpty() || tmp1.equals("") || !tmp.contains(tmp1)) {
                    System.out.println(tmp.length()+" "+tmp);
                    continue;
                }
                else if(res.length() == 0) {
                    System.out.println("0 NULL");
                }
                else {
                    System.out.println(res.length()+" "+ne);
                }
            }
        }
    }
}
