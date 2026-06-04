class Solution {
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        char[] pal = s.toCharArray();
        for (int i = 0, j = pal.length - 1; i < pal.length; i++, j--) {
            if (i >= j) return true;
            if (pal[i] != pal[j]) {
                return false;
            }
        }
        return true;
    }
}