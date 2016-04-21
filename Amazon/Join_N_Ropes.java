import java.util.List;
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        List<Integer> ropes = new ArrayList<>(Arrays.asList(1,2,3,4));
        int sum = minCostOfJoinRopes(ropes);
        System.out.println("Min cost : "+sum);
    }
    public static int minCostOfJoinRopes(List<Integer> ropes) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(ropes);
        //----------------------------------------------//
        int sum = 0;
        for(int i = 0; i < ropes.size()-1; ++i) {
            int one = pq.poll();
            int two = pq.poll();
            int tmp = one+two;
            sum+=tmp;
            pq.add(tmp);
        }
        return sum;
    }
}
