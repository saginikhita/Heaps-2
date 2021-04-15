// Time Complexity : The time complexity is O(n) where n is the length of the array
// Space Complexity : Te space complexity is O(n) where n is the length of the array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer,Integer> map = new HashMap<>();
        Map<Integer,List<Integer>> freq = new HashMap<>();

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        //create number and its frequency map
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
            max = Math.max(max,map.get(num));
            min = Math.min(min,map.get(num));
        }

        // create frequency and its corresponding numbers map
        for(int key:map.keySet()){
            List<Integer> li = freq.getOrDefault(map.get(key),new ArrayList<>());
            li.add(key);
            freq.put(map.get(key),li);
        }

        int[] output = new int[k];
        int idx = 0;

        // get the top k numbers from the frequency map
        while(k != 0){
            if(freq.containsKey(max)){
                for(int each:freq.get(max)){
                    output[idx++] = each;
                    k--;
                }
            }
            max--;
        }
        return output;
    }
}