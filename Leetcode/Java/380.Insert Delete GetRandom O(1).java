import java.util.Random;

public class RandomizedSet {
    List<Integer> dataSet;
    Map<Integer, Integer> isAdded;
    //Random random;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        dataSet = new ArrayList<>();
        isAdded = new HashMap<>();
        //random = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        boolean isExist = isAdded.containsKey(val);
        if(isExist) return false;
        else {
            isAdded.put(val, dataSet.size());
            dataSet.add(val);
            return true;
        }
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        boolean isExist = isAdded.containsKey(val);
        if(!isExist) return false;
        else {
            int index = isAdded.get(val);//replaced index
            dataSet.set(index, dataSet.get(dataSet.size()-1));//exchange last and replaced one
            isAdded.put(dataSet.get(index), index);//update index track
            dataSet.remove(dataSet.size()-1);//remove last one
            isAdded.remove(val);//remove deleted one
            return true;
        }
    }

    /** Get a random element from the set. */
    public int getRandom() {
        int index = new Random().nextInt(dataSet.size());
        return dataSet.get(index);
    }
}
