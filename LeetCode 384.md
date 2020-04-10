# LeetCode384

* Author：Wangshu Zhang
* Version：2020-04-09

# Problem: Shuffle an Array

# References about random shuffling an array:
https://www.programcreek.com/2012/02/java-method-to-shuffle-an-int-array-with-random-order/
https://www.journaldev.com/32661/shuffle-array-java

### Code
```Java
class Solution {
    private int[] original_array;

    public Solution(int[] nums) {
        original_array = new int[nums.length];
        System.arraycopy(nums, 0, original_array, 0, nums.length);
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return original_array;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] shuffled_array = new int[original_array.length];
        System.arraycopy(original_array, 0, shuffled_array, 0, original_array.length);

        Random random = new Random();
        for (int i = 0; i < shuffled_array.length; i ++) {
            int j = random.nextInt(shuffled_array.length);
            int temp = shuffled_array[i];
            shuffled_array[i] = shuffled_array[j];
            shuffled_array[j] = temp;
        }
        return shuffled_array;
    }
}
/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
```

```Java
// A simpler solution
class Solution {
    private int[] original_array;
    Random random;

    public Solution(int[] nums) {
        original_array = nums.clone();
        random = new Random();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return original_array;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] shuffled_array = original_array.clone();

        for (int i = 0; i < shuffled_array.length; i ++) {
            int j = random.nextInt(shuffled_array.length);
            int temp = shuffled_array[i];
            shuffled_array[i] = shuffled_array[j];
            shuffled_array[j] = temp;
        }
        return shuffled_array;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
```
