import java.util.ArrayList;
import java.util.List;
/*
  Given a array of prime number e.g [3,7,11]
  Generate N smallest prime number using those prime number as factor
*/
class Solution{
  public static void main(String[] args) {
    int[] primes = {3,7,13};//5 13,17
    List<Integer> result = new ArrayList<>();
    int n = 6;
    help(n, result, primes, primes[0]);
    System.out.println("Generated result");
    for(int num : result) {
      System.out.print(num+" ");
    }
    System.out.println();
  }
  public static void help(int n, List<Integer> result, int[] primes, int num) {
    for(int i = 0; i < n; ++i) {
      int tmp = -1;
      int val = Integer.MAX_VALUE;
      for(int j = 0; j < primes.length; ++j) {
        if(primes[j] < val) {
          tmp = j;
          val = primes[j];
        }
      }
      result.add(val);
      primes[tmp]*=num;
    }
  }
}
