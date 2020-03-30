# LeetCode238

* Author：Wangshu Zhang
* Version：2020-03-29

# Problem: Product of Array Except Self

### Code
```Java
// Java Version
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] res = new int[n];
        left[0] = 1;
        int product = 1;
        for (int i = 1; i < n; i++) {
            left[i] = product * nums[i - 1];
            product = left[i];
        }
        right[n - 1] = 1;
        product = 1;
        for (int i = n - 2; i >= 0; i--) {
            right[i] = product * nums[i + 1];
            product = right[i];
        }
        for (int i = 0; i < n; i ++) {
            res[i] = left[i] * right[i];
        }
        return res;
    }
}
```

```Java
// C++ Version
class Solution {
public:
    vector<int> productExceptSelf(vector<int>& nums) {
        vector<int>answer(nums.size(),1);
        for(int i = 1; i < nums.size(); i++){
            answer[i] = answer[i-1]*nums[i-1];
        }
        int back_product = 1;
        for(int i = nums.size()-2; i >= 0; i--){
            back_product *= nums[i+1];
            answer[i] *= back_product;
        }
        return answer;
    }
};
```
