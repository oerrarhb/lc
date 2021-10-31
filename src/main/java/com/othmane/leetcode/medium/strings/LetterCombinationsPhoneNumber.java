package com.othmane.leetcode.medium.strings;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
17. Letter Combinations of a Phone Number

Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 */
public class LetterCombinationsPhoneNumber {

    private final Map<Integer, List<String>> map = new HashMap<>();

    public void fillMap() {
        map.put(2, List.of("a", "b", "c"));
        map.put(3, List.of("d", "e", "f"));
        map.put(4, List.of("g", "h", "i"));
        map.put(5, List.of("j", "k", "l"));
        map.put(6, List.of("m", "n", "o"));
        map.put(7, List.of("p", "q", "r", "s"));
        map.put(8, List.of("t", "u", "v"));
        map.put(9, List.of("w", "x", "y", "z"));
    }


    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() > 4 || digits.contains("1") || digits.contains("0") || !digits.chars().allMatch(Character::isDigit)) {
            return null;
        } else {
            fillMap();
            if (digits.length() == 1) {
                return map.get(Integer.valueOf(digits));
            } else {
                if(digits.isBlank() || digits.length()==0)
                {
                    return new ArrayList<>();
                }
                if (digits.length() == 2) {
                    var l1 = new ArrayList<>(map.get(Integer.valueOf((String.valueOf(digits.charAt(0))))));
                    var l2 = new ArrayList<>(map.get(Integer.valueOf((String.valueOf(digits.charAt(1))))));
                    var result = new ArrayList<String>();
                    for (String si : l1) {
                        for (String sj : l2) {
                            result.add(si + sj);
                        }
                    }
                    return result;

                } else if (digits.length() == 3) {
                    var l3 = new ArrayList<>(map.get(Integer.valueOf((String.valueOf(digits.charAt(2))))));
                    var result1 = letterCombinations(digits.substring(0, 2));
                    var result2 = new ArrayList<String>();
                    for (String si : result1) {
                        for (String sj : l3) {
                            result2.add(si + sj);
                        }
                    }
                    return result2;
                } else {
                    var l4 = new ArrayList<>(map.get(Integer.valueOf((String.valueOf(digits.charAt(3))))));
                    var result1 = letterCombinations(digits.substring(0, 3));
                    var result2 = new ArrayList<String>();
                    for (String si : result1) {
                        for (String sj : l4) {
                            result2.add(si + sj);
                        }
                    }
                    return result2;
                }
            }
        }
    }

    public static void main(String... args) {
        var list2 = List.of("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf");
        System.out.println(list2.size());
        var list3 = List.of("adg", "adh", "adi", "aeg", "aeh", "aei", "afg", "afh", "afi", "bdg", "bdh", "bdi", "beg", "beh", "bei", "bfg", "bfh", "bfi", "cdg", "cdh", "cdi", "ceg", "ceh", "cei", "cfg", "cfh", "cfi");
        System.out.println(list3.size());
        var list4 = List.of("adgj", "adgk", "adgl", "adhj", "adhk", "adhl", "adij", "adik", "adil", "aegj", "aegk", "aegl", "aehj", "aehk", "aehl", "aeij", "aeik", "aeil", "afgj", "afgk", "afgl", "afhj", "afhk", "afhl", "afij", "afik", "afil", "bdgj", "bdgk", "bdgl", "bdhj", "bdhk", "bdhl", "bdij", "bdik", "bdil", "begj", "begk", "begl", "behj", "behk", "behl", "beij", "beik", "beil", "bfgj", "bfgk", "bfgl", "bfhj", "bfhk", "bfhl", "bfij", "bfik", "bfil", "cdgj", "cdgk", "cdgl", "cdhj", "cdhk", "cdhl", "cdij", "cdik", "cdil", "cegj", "cegk", "cegl", "cehj", "cehk", "cehl", "ceij", "ceik", "ceil", "cfgj", "cfgk", "cfgl", "cfhj", "cfhk", "cfhl", "cfij", "cfik", "cfil");
        System.out.println(list4.size());
        var list5 = List.of("aap", "aaq", "aar", "aas", "abp", "abq", "abr", "abs", "acp", "acq", "acr", "acs", "bap", "baq", "bar", "bas", "bbp", "bbq", "bbr", "bbs", "bcp", "bcq", "bcr", "bcs", "cap", "caq", "car", "cas", "cbp", "cbq", "cbr", "cbs", "ccp", "ccq", "ccr", "ccs");
        System.out.println(Integer.valueOf(String.valueOf("123".charAt(0))));

        System.out.println(new LetterCombinationsPhoneNumber().letterCombinations("727").size());
        System.out.println(list5.size());
    }


}
