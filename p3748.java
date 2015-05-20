
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 * 位操作 Time Limit: 1000MS	Memory Limit: 65536K Total Submissions: 7880	Accepted:
 * 3106 Description
 *
 * 假设你工作在一个32位的机器上，你需要将某一个外设寄存器的第X位设置成0(最低位为第0位，最高位为第31位)，将第Y位开始的连续三位设置成110（从高位到低位的顺序），而其他位保持不变。对给定的寄存器值R，及X，Y，编程计算更改后的寄存器值R。
 * Input
 *
 * 仅一行，包括R,X,Y，以逗号","分隔，R为16进制表示的32位整数，X,Y在0-31之间且Y>=3，(Y-X)的绝对值>=3，保证两次置位不会重合
 * Output
 *
 * 更改后的寄存器值R（16进制输出） Sample Input
 *
 * 12345678,0,3 Sample Output
 *
 * 1234567c Source
 */
public class p3748 {

    public static StringBuffer tranform(String tmp) {
        char[] tab = tmp.toCharArray();
        StringBuffer ret = new StringBuffer();
        for (int i = 0; i < tab.length; i++) {
            switch (tab[i]) {
                case '0':
                    ret.append("0000");
                    break;
                case '1':
                    ret.append("0001");
                    break;
                case '2':
                    ret.append("0010");
                    break;
                case '3':
                    ret.append("0011");
                    break;
                case '4':
                    ret.append("0100");
                    break;
                case '5':
                    ret.append("0101");
                    break;
                case '6':
                    ret.append("0110");
                    break;
                case '7':
                    ret.append("0111");
                    break;
                case '8':
                    ret.append("1000");
                    break;
                case '9':
                    ret.append("1001");
                    break;
                case 'a':
                    ret.append("1010");
                    break;
                case 'b':
                    ret.append("1011");
                    break;
                case 'c':
                    ret.append("1100");
                    break;
                case 'd':
                    ret.append("1101");
                    break;
                case 'e':
                    ret.append("1110");
                    break;
                case 'f':
                    ret.append("1111");
                    break;
                default:
                    break;
            }

        }
        return ret;
    }
    //bit-wise ops
    //Integer.toHexString
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] tmp = in.nextLine().split(",");
        int val = Integer.parseInt(tmp[0],16);
        
        int X = Integer.parseInt(tmp[1]);
        int Y = Integer.parseInt(tmp[2]);
       // System.out.println(Integer.valueOf(0x1 << X) +" " + Integer.valueOf(~(0x1 << X)));
        val = val & ~(0x1 << X);
        val = val & ~(0x1 << (Y-2));
        val = val | (0x1 << (Y-1));
        val = val | (0x1 << (Y));
        //int y1 = 1 << Y;
        //int y2 = 1 << (Y-1);
        //int y3 = 0 << (Y-2);
        //int x1 = 0 << X;
        //System.out.println(val+" "+y1+" "+y2+" "+y3+" "+ x1);
        //val = val & x1 & y1 & y2 & y3;
        System.out.println(Integer.toHexString(val));
    }
}
