package com.company;/* IMPORTANT: Multiple classes and nested static classes are supported */


//* uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class BishuSoldiers {
  public static void main(String args[] ) throws Exception {
    /* Sample code to perform I/O:
     * Use either of these methods for input
     */
    //BufferedReader
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // String name = br.readLine();                // Reading input from STDIN
    // System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

    // //Scanner
    // Scanner s = new Scanner(System.in);
    // String name = s.nextLine();                 // Reading input from STDIN
    // System.out.println("Hi, " + name + ".");    // Writing output to STDOUT



    int n = Integer.parseInt(br.readLine());
    int[] soldiersPower = new int[n];
    String[] soldiersPowerStr = br.readLine().split(" ");
    for(int i = 0; i < soldiersPowerStr.length; i++){
      soldiersPower[i] = Integer.parseInt(soldiersPowerStr[i]);
    }
    // for(int i = 0; i < n; i++){
    //     System.out.println(soldiersPower[i]);
    // }
    int numOfRounds = Integer.parseInt(br.readLine());

    for(int i = 0; i < numOfRounds; i++) {
      int bishuPower = Integer.parseInt(br.readLine());
      int index = binarySearch(bishuPower, soldiersPower);
      int acc = 0;
      for(int j = 0; j <= index; j ++) {
        acc+=soldiersPower[j];
      }
      System.out.println(soldiersPower[index] + " " + acc);
    }

  }

  public static int binarySearch(int bishuPower, int[] soldiersPower) {
    int good = -1;
    int bad = soldiersPower.length;
    while(bad-good > 1) {
      int mid = (good+ bad) >> 1;
      if(soldiersPower[mid] <= bishuPower) {
        good = mid;
      } else {
        bad = mid;
      }
    }
    return good;

  }
}