/*
    Deque
*/
public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0 || k == 0) return new int[0];
        Deque<Integer> deque = new LinkedList<>();
        int[] result = new int[nums.length-k+1];
        for(int i = 0; i < nums.length; ++i) {
            //---remove head----//
            while(deque.size() > 0 && (deque.getFirst()+k == i)) deque.pollFirst();
            while(deque.size() > 0 && (nums[i] > nums[deque.getLast()])) deque.pollLast();
            deque.add(i);
            if(i >= k-1) result[i-k+1] = nums[deque.getFirst()];
        }
        return result;
    }
}

/*
    native approach
*/
public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int max = 0; //maximum of k elements in window
        int len = nums.length ;
        int [] result;
        if(len == 1|| k==0){
            return nums;
        }
        len = len- k +1; // loop will execute 'len' times.

        result = new int[len];

        for(int i =0; i < len ; i++){
            if(i==0){
                max = getMax(nums,i,i+k-1);  //linear search to get maximum of k values
            }
            else{
                if(max == nums[i-1]){   //check whether the last number is max or not
                    max =  getMax(nums,i,i+k-1); // get the new Max number
                }
                else if( max < nums[i+k-1]){ // whether previous max is less than the new kth number
                    max = nums[i+k-1];
                }
            }
            result[i]=max;
        }

        return result;
    }

    private static int getMax(int[] nums, int i, int w) {
        int max = nums[i];

        for(int j = i+1; j<= w ; j++){
            if(max < nums[j])
                max = nums[j];
        }
        return max;
    }
}
