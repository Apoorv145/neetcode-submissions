class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        List<Integer>[] bucket = new List[nums.length + 1];
        for (int key : map.keySet()) {
            int frequency = map.get(key);
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }

        int[] res = new int[k];
        int count = 0;
        for (int pos = bucket.length - 1; pos >= 0 && count < k; pos--) {
            if (bucket[pos] != null) {
                for (Integer integer : bucket[pos]) {
                    res[count++] = integer;
                    if (count == k) break;
                }
            }
        }
        return res;
    }
}