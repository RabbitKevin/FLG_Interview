public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        if(k == 0 || nums.length == 0) return result;
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            if(!map.containsKey(num)) map.put(num, 1);
            else map.put(num, map.get(num)+1);
        }
        List<Integer>[] frequency = new List[nums.length+1];
        for(int key : map.keySet()) {
            int val = map.get(key);
            if(frequency[val] == null) {
                List<Integer> tmp =new ArrayList<>();
                tmp.add(key);
                frequency[val] = tmp;
            }
            else frequency[val].add(key);
        }
        int size = 0;
        for(int i = nums.length; i >= 0 && size < k; --i) {
            if(frequency[i] == null) continue;
            int amount = Math.min(k-size, frequency[i].size());
            List<Integer> list = frequency[i];
            for(int j = 0; j < amount; ++j) {
                result.add(list.get(j));
            }
            size+=amount;
        }
        //--------------------------//
        return result;
    }
}
