// Longest Substring Without Repeating Characters(https://leetcode.com/problems/longest-substring-without-repeating-characters/)

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : np


// Your code here along with comments explaining your approach
// store characters in a set, once repatation found
//move the start till first occurance _1 index of the character
//keep track of max length

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start =0;
        int end =0;
        int max=0;
        Set<Character> set = new HashSet<>();
        while(end<s.length()){
            if(set.contains(s.charAt(end))){
                while(s.charAt(start)!=s.charAt(end)) {
                    set.remove(s.charAt(start));
                    start++;
                }
                start++;
                set.remove(s.charAt(end));
            }
            max=Math.max(max,end-start+1);
            set.add(s.charAt(end));
            end++;
        }
        return max;
    }
}

//hashmap

// Your code here along with comments explaining your approach
// store the index of every character, when we find the same character again, and its index is greater that start
// make start =index+1
//keep track of max length

class Solution {
    public int lengthOfLongestSubstring(String s) {
       int i=0;
        Map<Character, Integer> map = new HashMap<>();
        int start=0;
        int max=0;
        while(i<s.length()){
            Character ch= s.charAt(i);
            if(map.containsKey(ch) && map.get(ch) >= start) start = map.get(ch) + 1;
            map.put(ch, i);
            max = Math.max(max, i - start + 1);
            i++;
        }
        return max;
    }
}