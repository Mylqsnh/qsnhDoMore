package algorithm.array;

import java.util.*;

public class RandomizedSet_380 {

    public static void main(String[] args) {
        RandomizedSet_380 randomizedSet = new RandomizedSet_380();
        System.out.println(randomizedSet.insert(0));
        System.out.println(randomizedSet.insert(1));
        System.out.println(randomizedSet.remove(0));
        System.out.println(randomizedSet.insert(2));
        System.out.println(randomizedSet.remove(1));
        System.out.println(randomizedSet.getRandom());
    }

    List<Integer> nums;
    Map<Integer, Integer> index;

    public RandomizedSet_380() {
        nums = new ArrayList<>();
        index = new HashMap<>();
    }

    public boolean insert(int val) {
        if (index.containsKey(val)) {
            return false;
        }

        nums.add(val);
        index.put(val, nums.size() - 1);
        return true;
    }

    public boolean remove(int val) {
        if (!index.containsKey(val)) {
            return false;
        }

        Integer i = index.get(val);
        index.put(nums.get(nums.size() - 1), i);
        Collections.swap(nums, i, nums.size() - 1);
        nums.remove(nums.size() - 1);
        index.remove(val);

        return true;
    }

    public int getRandom() {
        return nums.get((int) (Math.random() * nums.size()));
    }

}
