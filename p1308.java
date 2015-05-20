
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
Is It A Tree?
Time Limit: 1000MS		Memory Limit: 10000K
Total Submissions: 16529		Accepted: 5661
Description

A tree is a well-known data structure that is either empty (null, void, nothing) or is a set of one or more nodes connected by directed edges between nodes satisfying the following properties. 

There is exactly one node, called the root, to which no directed edges point. 
Every node except the root has exactly one edge pointing to it. 
There is a unique sequence of directed edges from the root to each node. 
For example, consider the illustrations below, in which nodes are represented by circles and edges are represented by lines with arrowheads. The first two of these are trees, but the last is not. 


In this problem you will be given several descriptions of collections of nodes connected by directed edges. For each of these you are to determine if the collection satisfies the definition of a tree or not.
Input

The input will consist of a sequence of descriptions (test cases) followed by a pair of negative integers. Each test case will consist of a sequence of edge descriptions followed by a pair of zeroes Each edge description will consist of a pair of integers; the first integer identifies the node from which the edge begins, and the second integer identifies the node to which the edge is directed. Node numbers will always be greater than zero.
Output

For each test case display the line "Case k is a tree." or the line "Case k is not a tree.", where k corresponds to the test case number (they are sequentially numbered starting with 1).
Sample Input

6 8  5 3  5 2  6 4
5 6  0 0

8 1  7 3  6 2  8 9  7 5
7 4  7 8  7 6  0 0

3 8  6 8  6 4
5 3  5 6  5 2  0 0
-1 -1
Sample Output

Case 1 is a tree.
Case 2 is a tree.
Case 3 is not a tree.
Source

North Central North America 1997
 */
public class p1308 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean isStop = false;
        int j = 1;
        while(!isStop) {
            boolean flag = false;  
            HashMap<Integer,Integer> tab = new HashMap();
            ArrayList<Integer> list =  new ArrayList();
            int nodeCnt = 0;
            int cnt = 0;
            while(in.hasNext()) {
                int start = in.nextInt();
                int end = in.nextInt();
                if(start == 0 & end == 0) {
                    if(nodeCnt == 0 ) 
                        cnt = 1;
                    break;
                }            
                else if(start == -1 & end == -1) {
                    isStop = true;
                    break;
                }
                else {
                    nodeCnt++;
                    if(tab.containsKey(end)) {
                        tab.put(end, tab.get(end)+1);
                    }
                    else {
                        tab.put(end, 1);
                    }
                    if(!list.contains(start)) {
                        list.add(start);
                    }
                }
            }
            if(isStop) {
                break;
            }
            else {                
                for(int i = 0; i < list.size() ; i++) {
                    if(!tab.containsKey(list.get(i))) 
                        cnt++;
                }
                for(Iterator k = tab.keySet().iterator(); k.hasNext();) {
                    int tmp = tab.get(k.next());
                    if(tmp > 1) {
                        flag = true;
                        break;
                    }
                }
                if(flag || cnt != 1)
                    System.out.printf("Case %d is not a tree.\n", j++);
                else
                    System.out.printf("Case %d is a tree.\n", j++);
                
            }
            
        }
    }
}
