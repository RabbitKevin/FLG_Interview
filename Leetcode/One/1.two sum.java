class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        int[] res = new int[2];
        for(int i = 0; i < nums.length; ++i) {
            int tmp = target-nums[i];
            if(hashMap.containsKey(tmp)) {
                res[0] = hashMap.get(tmp);
                res[1] = i;
                return res;
            }
            hashMap.put(nums[i], i);
        }
        return res;
    }
}
