
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
Web Navigation
Time Limit: 1000MS		Memory Limit: 10000K
Total Submissions: 24411		Accepted: 10875
Description

Standard web browsers contain features to move backward and forward among the pages recently visited. One way to implement these features is to use two stacks to keep track of the pages that can be reached by moving backward and forward. In this problem, you are asked to implement this. 
The following commands need to be supported: 
BACK: Push the current page on the top of the forward stack. Pop the page from the top of the backward stack, making it the new current page. If the backward stack is empty, the command is ignored. 
FORWARD: Push the current page on the top of the backward stack. Pop the page from the top of the forward stack, making it the new current page. If the forward stack is empty, the command is ignored. 
VISIT : Push the current page on the top of the backward stack, and make the URL specified the new current page. The forward stack is emptied. 
QUIT: Quit the browser. 
Assume that the browser initially loads the web page at the URL http://www.acm.org/
Input

Input is a sequence of commands. The command keywords BACK, FORWARD, VISIT, and QUIT are all in uppercase. URLs have no whitespace and have at most 70 characters. You may assume that no problem instance requires more than 100 elements in each stack at any time. The end of input is indicated by the QUIT command.
Output

For each command other than QUIT, print the URL of the current page after the command is executed if the command is not ignored. Otherwise, print "Ignored". The output for each command should be printed on its own line. No output is produced for the QUIT command.
Sample Input

VISIT http://acm.ashland.edu/
VISIT http://acm.baylor.edu/acmicpc/
BACK
BACK
BACK
FORWARD
VISIT http://www.ibm.com/
BACK
BACK
FORWARD
FORWARD
FORWARD
QUIT
Sample Output

http://acm.ashland.edu/
http://acm.baylor.edu/acmicpc/
http://acm.ashland.edu/
http://www.acm.org/
Ignored
http://acm.ashland.edu/
http://www.ibm.com/
http://acm.ashland.edu/
http://www.acm.org/
http://acm.ashland.edu/
http://www.ibm.com/
Ignored
 */
public class p1028 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StringBuilder current = new StringBuilder(71);
        current.append("http://www.acm.org/");
        List<String> backward = new ArrayList<String>();
        List<String> forward = new ArrayList<String>();
        while(in.hasNext()) {
            String buf = in.nextLine();
            if(buf.equals("QUIT"))
                break;
            String[] intr = buf.split("\\s+");
            boolean flag = false;
            if(intr[0].equals("VISIT") && !flag){
                backward.add(0,current.toString());
                forward.clear();
                current.replace(0, 71, intr[1]);
               // flag = true;
            }
            if(intr[0].equals("BACK") && !flag) {         
                if(!backward.isEmpty()) {
                    forward.add(0,current.toString());
                    current.replace(0, 71, backward.remove(0));
                }
                else {
                    flag = true;
                   // current.replace(0, 70, "Ignored");
                }
                //flag = true;
            }
            if(intr[0].equals("FORWARD") && !flag){
                if(!forward.isEmpty()) {
                    backward.add(0, current.toString());
                    current.replace(0,71,forward.remove(0));
                }
                else {
                    flag = true;
                    // current.replace(0,70,"Ignored");
                }
                //flag = true;
            }
            if(!flag)
                System.out.println(current.toString());
            else 
                System.out.println("Ignored");
        }
        
        
    }
}
