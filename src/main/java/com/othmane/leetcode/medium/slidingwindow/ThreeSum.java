package com.othmane.leetcode.medium.slidingwindow;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/*
16. 3Sum Closest
Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.
Return the sum of the three integers.
You may assume that each input would have exactly one solution.
*/
public class ThreeSum {
    public int threeSumClosestOld(int[] nums, int target) {
        Arrays.sort(nums);
        var diff = Integer.MAX_VALUE;
        var result = 0;
        for (var i = 0; i < nums.length - 2; i++) {
            for (var j = i + 1; j < nums.length - 1; j++) {
                var sum = nums[i] + nums[j] + nums[j + 1];

                diff = Math.min(diff, Math.abs(sum - target));
                if (diff == Math.abs(sum - target)) {
                    result = sum;
                }
                System.out.println(sum);
                System.out.println(diff);
                System.out.println(result);
                System.out.println("=========================");


            }
        }
        return result;
    }

    public int threeSumClosest(int[] nums, int target) {
        var result = nums[0] + nums[1] + nums[nums.length - 1];
        Arrays.sort(nums);
        for (var i = 0; i < nums.length; i++) {
            var start = i + 1;
            var end = nums.length - 1;
            while (start < end) {
                var currentSum = nums[i] + nums[start] + nums[end];
                if (currentSum < target) {
                    start++;
                } else {
                    end--;
                }
                if (Math.abs(target - currentSum) < Math.abs(target - result)) {
                    result = currentSum;
                }
            }
        }
        return result;
    }


    public void generateRandom() {
        Integer[] randArray = new Integer[1000];
        var h = 1000;
        var l = -1000;
        var random = new Random();
        for (int i = 0; i < 1000; i++) {
            //randArray[i] = (int) (Math.random() * 1000);
            randArray[i] = (int) random.nextInt(h - l + 1) + l;
        }
        var list = Arrays.asList(randArray);
        System.out.println(list);
    }

    public static void main(String... args) {
        /*var target = 13;
        var nums = new int[5];
        nums[0] = 1;
        nums[1] = 2;
        nums[2] = 3;
        nums[3] = 9;
        nums[4] = 10;
        System.out.println(thriples(nums, target));
        System.out.println(sum);
        System.out.println(diff);

*/
        new ThreeSum().generateRandom();

    }

    public List<List<Integer>> couples(int[] nums) {
        if (nums.length == 2) {
            var list = new ArrayList<Integer>();
            list.add(nums[0]);
            list.add(nums[1]);
            var listOfLists = new ArrayList<List<Integer>>();
            listOfLists.add(list);
            return listOfLists;
        } else {
            var numsCopy = Arrays.copyOf(nums, nums.length - 1);
            var res = couples(numsCopy);
            for (Integer i : numsCopy) {
                res.add(List.of(i, nums[nums.length - 1]));
            }
            return res;
        }
    }

    static int sum = 0;
    static int diff = Integer.MAX_VALUE;


    public static List<List<Integer>> thriples(int[] nums, int target) {
        if (nums.length == 3) {
            var list = new ArrayList<Integer>();
            list.add(nums[0]);
            list.add(nums[1]);
            list.add(nums[2]);
            var listOfLists = new ArrayList<List<Integer>>();
            listOfLists.add(list);
            return listOfLists;
        } else {
            var numsCopy = Arrays.copyOf(nums, nums.length - 1);
            var res = thriples(numsCopy, target);
            var result = new ArrayList<>(res);
            for (List<Integer> li : res) {
                int absii = Math.abs(-target + li.get(0) + li.get(1) + li.get(2));
                diff = Math.min(diff, absii);
                if (diff == absii) {
                    sum = li.get(0) + li.get(1) + li.get(2);
                }
                var lii = new ArrayList<>(li);
                lii.set(0, nums[nums.length - 1]);
                result.add(lii);
                int absjj = Math.abs(-target + lii.get(0) + lii.get(1) + lii.get(2));
                diff = Math.min(diff, absjj);
                if (diff == absjj) {
                    sum = lii.get(0) + lii.get(1) + lii.get(2);
                }
                var lij = new ArrayList<>(li);
                lij.set(1, nums[nums.length - 1]);
                result.add(lij);
                int abskk = Math.abs(-target + lij.get(0) + lij.get(1) + lij.get(2));
                diff = Math.min(diff, abskk);
                if (diff == abskk) {
                    sum = lij.get(0) + lij.get(1) + lij.get(2);
                }
                var lik = new ArrayList<>(li);
                lik.set(2, nums[nums.length - 1]);
                result.add(lik);
                diff = Math.min(diff, Math.abs(-target + lik.get(0) + lik.get(1) + lik.get(2)));
                if (diff == Math.abs(-target + lik.get(0) + lik.get(1) + lik.get(2))) {
                    sum = lik.get(0) + lik.get(1) + lik.get(2);
                }
            }
            return result;
        }
    }

    public int sum(List<Integer> l, int i) {
        return l.get(0) + l.get(1) + i;
    }


}
