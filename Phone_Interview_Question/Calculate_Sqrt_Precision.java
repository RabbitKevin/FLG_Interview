class Solution {
  public static void main(String[] args) {
    int x = 5;
    float result = help(0, (float)x, (float)0.0001, (float)x);
    System.out.println(result);
  }
  public static float help(float left, float right, float range, float num) {
    if(right - left < range) return (right+left) / 2;
    float mid = left+(right-left)/2;
    float sum = mid*mid;
    if(sum == num) return mid;
    if(sum < num) return help(mid, right, range, num);
    else return help(left, mid, range, num);
  }
}
