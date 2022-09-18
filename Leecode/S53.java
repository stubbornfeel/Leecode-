package Leecode;

public class S53 {
    public static int maxSubArray(int[] nums) {
        int ans = nums[0];
        int sum = 0;
        for (int a : nums) {
            if (sum > 0) {
                sum += a;
            } else {
                sum = a;
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}
