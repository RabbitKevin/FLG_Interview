public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0;
        List<Integer> result = new ArrayList<>();
        while(i < nums1.length && j < nums2.length) {
            if(nums1[i] < nums2[j]) ++i;
            else if(nums1[i] > nums2[j]) ++j;
            else {
                result.add(nums1[i]);
                while(i+1 < nums1.length && nums1[i+1] == nums1[i]) ++i;
                while(j+1 < nums2.length && nums2[j+1] == nums2[j]) ++j;
                ++i;
                ++j;
            }
        }
        int[] nums = new int[result.size()];
        i = 0;
        for(int num : result) {
            nums[i++] = num;
        }
        return nums;
    }
}
