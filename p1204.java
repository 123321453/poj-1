/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
Word Puzzles
Time Limit: 5000MS		Memory Limit: 65536K
Total Submissions: 7742		Accepted: 2925		Special Judge
Description

Word puzzles are usually simple and very entertaining for all ages. They are so entertaining that Pizza-Hut company started using table covers with word puzzles printed on them, possibly with the intent to minimise their client's perception of any possible delay in bringing them their order. 

Even though word puzzles may be entertaining to solve by hand, they may become boring when they get very large. Computers do not yet get bored in solving tasks, therefore we thought you could devise a program to speedup (hopefully!) solution finding in such puzzles. 

The following figure illustrates the PizzaHut puzzle. The names of the pizzas to be found in the puzzle are: MARGARITA, ALEMA, BARBECUE, TROPICAL, SUPREMA, LOUISIANA, CHEESEHAM, EUROPA, HAVAIANA, CAMPONESA. 


Your task is to produce a program that given the word puzzle and words to be found in the puzzle, determines, for each word, the position of the first letter and its orientation in the puzzle. 

You can assume that the left upper corner of the puzzle is the origin, (0,0). Furthemore, the orientation of the word is marked clockwise starting with letter A for north (note: there are 8 possible directions in total). 
Input

The first line of input consists of three positive numbers, the number of lines, 0 < L <= 1000, the number of columns, 0 < C <= 1000, and the number of words to be found, 0 < W <= 1000. The following L input lines, each one of size C characters, contain the word puzzle. Then at last the W words are input one per line.
Output

Your program should output, for each word (using the same order as the words were input) a triplet defining the coordinates, line and column, where the first letter of the word appears, followed by a letter indicating the orientation of the word according to the rules define above. Each value in the triplet must be separated by one space only.
Sample Input

20 20 10
QWSPILAATIRAGRAMYKEI
AGTRCLQAXLPOIJLFVBUQ
TQTKAZXVMRWALEMAPKCW
LIEACNKAZXKPOTPIZCEO
FGKLSTCBTROPICALBLBC
JEWHJEEWSMLPOEKORORA
LUPQWRNJOAAGJKMUSJAE
KRQEIOLOAOQPRTVILCBZ
QOPUCAJSPPOUTMTSLPSF
LPOUYTRFGMMLKIUISXSW
WAHCPOIYTGAKLMNAHBVA
EIAKHPLBGSMCLOGNGJML
LDTIKENVCSWQAZUAOEAL
HOPLPGEJKMNUTIIORMNC
LOIUFTGSQACAXMOPBEIO
QOASDHOPEPNBUYUYOBXB
IONIAELOJHSWASMOUTRK
HPOIYTJPLNAQWDRIBITG
LPOINUYMRTEMPTMLMNBO
PAFCOPLHAVAIANALBPFS
MARGARITA
ALEMA
BARBECUE
TROPICAL
SUPREMA
LOUISIANA
CHEESEHAM
EUROPA
HAVAIANA
CAMPONESA
Sample Output

0 15 G
2 11 C
7 18 A
4 8 C
16 13 B
4 15 E
10 3 D
5 1 E
19 7 C
11 11 H
Source

Southwestern Europe 2002
 */
public class p1204 {
    public static void main(String[] args) {
        
    }
}
