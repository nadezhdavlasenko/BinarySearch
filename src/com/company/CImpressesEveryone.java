package com.company;

// https://www.hackerearth.com/practice/algorithms/searching/binary-search/practice-problems/algorithm/c-impresses-everyone/description/

import java.util.stream.Collectors;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class CImpressesEveryone {

  public static void main(String args[]) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    List<Integer> stones = Arrays.asList(br.readLine().split(" ")).stream()
        .map(it -> Integer.valueOf(it)).collect(Collectors.toList());
    int[] sums = new int[n];
    sums[n - 1] = stones.get(n - 1);
    for (int i = n - 2; i >= 0; i--) {
      sums[i] = sums[i + 1] + stones.get(i);
    }
    int q = Integer.parseInt(br.readLine());
    for (int i = 0; i < q; i++) {
      int x = Integer.parseInt(br.readLine());
      int good = -1;
      int bad = n;

      while (bad - good > 1) {
        int mid = bad / 2 + good / 2;
        if (sums[mid] >= x) {
          good = mid;
        } else {
          bad = mid;
        }
      }
      if (good % 2 == 0) {
        System.out.println("A");
      } else {
        System.out.println("B");
      }
    }

  }
}
