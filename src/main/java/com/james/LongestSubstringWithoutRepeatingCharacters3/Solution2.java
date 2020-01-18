package com.james.LongestSubstringWithoutRepeatingCharacters3;

import java.util.ArrayList;
import java.util.List;

class Solution2 {
    public int lengthOfLongestSubstring(String s) {

        if(s == null || s == ""){
            return 0;
        }
        int max = 0;
        boolean[] checked = new boolean[256];
        int len = s.length();
        int j = 0;
        for(int i = 0; i < len; i++){
            char c = s.charAt(i);
            while(checked[c]){
                char c1 = s.charAt(j);
                checked[c1] = false;
                j++;
            }
            checked[c] = true;
            max = Math.max(max, i - j + 1);
        }

        return max;
    }

    public static void main(String[] args) {
        Math.round(-1.5);

        List l = new ArrayList<>();
        l.add(1);
    }

}