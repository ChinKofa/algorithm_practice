package com.james.LongestSubstringWithoutRepeatingCharacters3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

class Solution1 {
    public int lengthOfLongestSubstring(String s) {
        return helper(s);
    }

    private int helper(String s) {
        if (s == null || s == "") {
            return 0;
        }
        String newS = "";
        int length = s.length();
        int max = 0;
        for (int i = 0; i < length; i++) {
            String c = String.valueOf(s.charAt(i));
            int newSLen = newS.length();
            boolean flag = newSLen >= 1 && newS.contains(c);
            if (flag) {
                max = Math.max(newSLen, max);
                int duIndex = newS.indexOf(c);
                newS = newS.substring(duIndex+1);
                newS += c;
            } else{
                newS += s.charAt(i);
            }

            if(!flag && i == length - 1){
                max = Math.max(newS.length(), max);
            }
        }
        return max;
    }

    private int helper1(String s){
        if(s == null || s == "") {
            return 0;
        }

        List<Character> charList = new ArrayList<>(10);
        int len = s.length();
        int max = 0;
        for(int i = 0; i < len; i++){
            char c = s.charAt(i);
            if(charList.contains(c)){
                while(charList.get(0) != c){
                    charList.remove(0);
                }
                charList.remove(0);
            }
            charList.add(c);
            max = Math.max(max, charList.size());
        }
        return max;
    }

    public static void main(String[] args) {
        Solution1 s = new Solution1();
        int a = s.helper1("abcabcbb");
        System.out.println(a);
    }
}