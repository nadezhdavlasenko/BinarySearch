package com.company;

public class Main {

  public static void main(String[] args) {
    System.out.println(Multiply.multiply(9.0, 13.0));
    System.out.println(new Solution().firstBadVersion(2126753390));
    // write your code here
  }
}

class Multiply {

  public static Double multiply(Double a, Double b) {
    return a * b;
  }
}

class VersionControl {

  boolean isBadVersion(int version) {
    return version >= 1702766719;
  }
}

class Solution extends VersionControl {

    public int firstBadVersion(int n) {
        long good = 0;
        long bad = n;
        while (good < bad) {
            int mid = (int) ((bad + good) / 2);
            if (isBadVersion(mid)) {
                if (bad == mid) return (int) bad;
                bad = mid;
            } else {
                if (good == mid) return (int) bad;
                good = mid;
            }
        }
        return (int) bad;
    }
}