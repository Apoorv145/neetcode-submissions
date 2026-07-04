

public class Solution {

    // ─────────────────────────────────────────────────────
    // LEETCODE #1 — TWO SUM
    // Given: int[] nums, int target
    // Return: indices of two numbers that add up to target
    // URL: https://leetcode.com/problems/two-sum/
    // Time: O(n) | Space: O(n)
    // ─────────────────────────────────────────────────────
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }

            map.put(nums[i], i);
        }

        return new int[]{};
    }


    // ─────────────────────────────────────────────────────
    // LEETCODE #15 — THREE SUM
    // Given: int[] nums
    // Return: all unique triplets that sum to zero
    // URL: https://leetcode.com/problems/3sum/
    // Time: O(n²) | Space: O(1) extra
    // ─────────────────────────────────────────────────────
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }
}