public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> result = new ArrayList<>();
        Set<Integer> nums = new HashSet<>();
        for(int num : nums1) {
            nums.add(num);
        }
        //--------------------------------//
        for(int num : nums2) {
            if(nums.contains(num)) {
                result.add(num);
                nums.remove(num);
            }
        }
        int[] intersection = new int[result.size()];
        for(int i = 0; i < result.size(); ++i) {
            intersection[i] = result.get(i);
        }
        return intersection;
    }
}
