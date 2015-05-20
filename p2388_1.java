
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
Who's in the Middle
Time Limit: 1000MS		Memory Limit: 65536K
Total Submissions: 24681		Accepted: 14203
Description

FJ is surveying his herd to find the most average cow. He wants to know how much milk this 'median' cow gives: half of the cows give as much or more than the median; half give as much or less. 

Given an odd number of cows N (1 <= N < 10,000) and their milk output (1..1,000,000), find the median amount of milk given such that at least half the cows give the same amount of milk or more and at least half give the same or less.
Input

* Line 1: A single integer N 

* Lines 2..N+1: Each line contains a single integer that is the milk output of one cow.
Output

* Line 1: A single integer that is the median milk output.
Sample Input

5
2
4
1
3
5
Sample Output

3
* with qsort
 */
import java.io.BufferedInputStream; 
import java.util.Scanner; 
public class p2388_1{ 

    public static void main(String[] args) { 
        Scanner scan = new Scanner(new BufferedInputStream(System.in)); 
        if (scan.hasNext()) { 
            int n = scan.nextInt(); 
            int[] array = new int[n + 1]; 
            for (int i = 0; i < n; i++) { 
                array[i + 1] = scan.nextInt(); 
            } 
            quickSort(array); 
            System.out.println(array[n / 2 + 1]); 

        } 
    } 

    private static int partition(int[] array, int low, int high) { 
        int key = array[low]; 
        while (low < high) {
            while (low < high && array[high] >= key) {
                high--; 
            } 
            array[low] = array[high]; 
            while (low < high && array[low] <= key) {
                low++; 
            } 
            array[high] = array[low];  
        } 
        array[low] = key; 
        return low; 
    } 

    private static void qSort(int[] array, int low, int high) { 
        int pivotloc; 
        if (low < high) {
            pivotloc = partition(array, low, high); 
            qSort(array, low, pivotloc - 1); 
            qSort(array, pivotloc + 1, high); 
        } 
    } 

    public static void quickSort(int[] array) { 
        int n = array.length - 1; 
        qSort(array, 1, n); 
    } 
}
