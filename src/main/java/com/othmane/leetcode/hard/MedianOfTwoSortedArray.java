package com.othmane.leetcode.hard;

// 4 . Median Of Two Sorted Arrays
/*
Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
The overall run time complexity should be O(log (m+n)).
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MedianOfTwoSortedArray {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0) {
            if (nums2.length % 2 == 1) {
                return nums2[nums2.length / 2];
            } else {
                var dd = Double.valueOf(nums2[nums2.length / 2 - 1]);
                var dc = Double.valueOf(nums2[nums2.length / 2]);
                var res = (dd + dc) / 2;
                return res;
            }
        }
        if (nums2.length == 0) {
            if (nums1.length % 2 == 1) {
                return nums1[nums1.length / 2];
            } else {
                var dd = Double.valueOf(nums1[nums1.length / 2 - 1]);
                var dc = Double.valueOf(nums1[nums1.length / 2]);
                var res = (dd + dc) / 2;
                return res;
            }
        }
        var l = new ArrayList<Integer>();
        var max = Math.max(nums1.length, nums2.length);
        for (int i = 0; i < max; i++) {
            if (i < nums1.length) {
                l.add(nums1[i]);
            }
            if (i < nums2.length) {
                l.add(nums2[i]);
            }
        }
        Collections.sort(l);
        if (l.size() % 2 == 1) {
            return l.get(l.size() / 2);
        } else {
            var dd = Double.valueOf(l.get(l.size() / 2 - 1));
            var dc = Double.valueOf(l.get(l.size() / 2));
            var res = (dd + dc) / 2;
            return res;
        }
    }


    public static void main(String... args) {
        var l = IntStream.iterate(0, i -> i + 10).limit(1000).boxed().collect(Collectors.toList());
        System.out.println(l);

    }
}



