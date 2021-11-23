package com.othmane.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

// 118 Pascal's Triangle
// Given an integer numRows, return the first numRows of Pascal's triangle.
//Input: numRows = 5
//Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        if (numRows == 1) {
            var list = new ArrayList<Integer>();
            list.add(1);
            var result = new ArrayList<List<Integer>>();
            result.add(list);
            return result;
        } else if (numRows == 2) {
            var l1 = generate(1);
            var l2 = new ArrayList<Integer>();
            l2.add(1);
            l2.add(1);
            l1.add(l2);
            return l1;
        } else {
            var llast = generate(numRows - 1);
            var llasti = llast.get(numRows - 2);
            var llastj = new ArrayList<Integer>();
            llastj.add(1);
            for (int i = 0; i < llasti.size() - 1; i ++) {
                llastj.add(llasti.get(i)+llasti.get(i+1));
            }
            llastj.add(1);
            llast.add(llastj);
            return llast;
        }
    }
}
