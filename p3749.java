
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
破译密码
Time Limit: 1000MS		Memory Limit: 65536K
Total Submissions: 6726		Accepted: 4198
Description

据说最早的密码来自于罗马的凯撒大帝。消息加密的办法是：对消息原文中的每个字母，分别用该字母之后的第5个字母替换（例如：消息原文中的每个字母A都分别替换成字母F）。而你要获得消息原文，也就是要将这个过程反过来。 

密码字母：A B C D E F G H I J K L M N O P Q R S T U V W X Y Z M 
原文字母：V W X Y Z A B C D E F G H I J K L M N O P Q R S T U 

注意：只有字母会发生替换，其他非字母的字符不变，并且消息原文的所有字母都是大写的。
Input

最多不超过100个数据集组成，每个数据集之间不会有空行，每个数据集由3部分组成: 

起始行：START
密码消息：由1到200个字符组成一行，表示凯撒发出的一条消息.
结束行：END


在最后一个数据集之后，是另一行：ENDOFINPUT
Output

每个数据集对应一行，是凯撒的原始消息。
Sample Input

START
NS BFW, JAJSYX TK NRUTWYFSHJ FWJ YMJ WJXZQY TK YWNANFQ HFZXJX
END
START
N BTZQI WFYMJW GJ KNWXY NS F QNYYQJ NGJWNFS ANQQFLJ YMFS XJHTSI NS WTRJ
END
START
IFSLJW PSTBX KZQQ BJQQ YMFY HFJXFW NX RTWJ IFSLJWTZX YMFS MJ
END
ENDOFINPUT
Sample Output

IN WAR, EVENTS OF IMPORTANCE ARE THE RESULT OF TRIVIAL CAUSES
I WOULD RATHER BE FIRST IN A LITTLE IBERIAN VILLAGE THAN SECOND IN ROME
DANGER KNOWS FULL WELL THAT CAESAR IS MORE DANGEROUS THAN HE
 */
public class p3749 {
    public static char translate(char c) {
        if(c >= 'F' && c <= 'Z')
            return (char)(c-5);
        if(c >= 'A' && c <= 'E') {
            return (char)(c+21);
        }
        else {
            return c;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            String sLine = in.nextLine();
            if(sLine.equals("ENDOFINPUT")){
                break;
            }
            String code = in.nextLine();
            char[] tmpTab = code.toCharArray();
            for(int i = 0; i < tmpTab.length;i++){
                System.out.print(translate(tmpTab[i]));
            }
            System.out.println();
            String eLine = in.nextLine();
            if(eLine.equals("END")) {
                continue;
            }
        }
    }
    
}
