package com.company.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

  public int[] twoSum(int[] nums, int target) {
    int[] res = {-1, -1};
    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[i] + nums[j] == target) {
          res[0] = i;
          res[1] = j;
          return res;
        }
      }
    }
    return res;
  }

  public int[] twoSumHash(int[] nums, int target) {
    int[] res = {-1, -1};
    Map map = new HashMap<Integer, Integer>();
    for (int i = 0; i < nums.length; i++) {
      if (map.containsKey(target-nums[i]))
        return new int[] {(int)map.get(target-nums[i]), i};
      map.put(nums[i], i);
    }
    return res;
  }
}
