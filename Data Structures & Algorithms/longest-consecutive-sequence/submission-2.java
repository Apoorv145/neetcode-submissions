class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        int longestlength = 0;

        // Step 1: populate the map FIRST, before any expansion
        for (int num : nums) {
            map.put(num, false);
        }

        // Step 2: now expand from each number
        for (int num : map.keySet()) {
            if (map.get(num) == true) {
                continue; // already part of a counted streak
            }

            int currentlength = 1;
            map.put(num, true);

            int nextnum = num + 1;
            while (map.containsKey(nextnum) && map.get(nextnum) == false) {
                currentlength++;
                map.put(nextnum, true);
                nextnum++;
            }

            int prevnum = num - 1;
            while (map.containsKey(prevnum) && map.get(prevnum) == false) {
                currentlength++;
                map.put(prevnum, true);
                prevnum--;
            }

            longestlength = Math.max(currentlength, longestlength);
        }

        return longestlength;
    }
}