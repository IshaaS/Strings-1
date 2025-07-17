// Custom Sort String (https://leetcode.com/problems/custom-sort-string/)

// Time Complexity : O(n+m) length of order+length of s
// Space Complexity :O(1) max 26 characters
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
// store freq of each char in s in a HashMap
// iterate over order and keep adding the fre number of char from order if present in HashMap
// at the end add remaining characters from the hashmap * their frequency.

class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<s.length();i++){
            char c=s.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        StringBuilder result = new StringBuilder();
        for(int i=0;i<order.length();i++){
            char c= order.charAt(i);
            if(map.get(c)!=null){
                int freq=map.get(c);
                for(int j=0;j<freq;j++) result.append(c);
            }
            map.remove(c);
        }
        for(char c: map.keySet()){
            if(map.get(c)!=null){
                int freq=map.get(c);
                for(int j=0;j<freq;j++) result.append(c);
            }
        }
        return result.toString();
    }
}
