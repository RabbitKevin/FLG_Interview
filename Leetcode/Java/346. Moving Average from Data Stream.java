public class MovingAverage {
    int[] buffer;
    int index;
    boolean isFull;
    int sum;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        buffer = new int[size];
        index = 0;
        isFull = false;
        sum = 0;
    }

    public double next(int val) {
        sum-=buffer[index];
        buffer[index] = val;
        sum+=buffer[index];
        index++;
        if(index == buffer.length) {
            isFull = true;
            index = 0;
        }
        return isFull?(double)sum/buffer.length:(double)sum/index;
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
