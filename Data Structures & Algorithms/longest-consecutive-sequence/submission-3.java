class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int longestLength = 0;

        for (int num : set) {
            // Only start counting if 'num' is the beginning of a sequence
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentLength = 1;

                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    currentLength++;
                }

                longestLength = Math.max(longestLength, currentLength);
            }
        }

        return longestLength;
    }
}