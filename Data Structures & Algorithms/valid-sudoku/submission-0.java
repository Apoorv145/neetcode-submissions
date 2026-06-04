class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        for (char[] row : board) {
            HashSet<Character> rowSet = new HashSet<>();
            for (char c : row) {
                if (c != '.' && !rowSet.add(c)) return false;
            }
        }

        for (int col = 0; col < 9; col++) {
            HashSet<Character> colSet = new HashSet<>();
            for (int row = 0; row < 9; row++) {
                char c = board[row][col];
                if (c != '.' && !colSet.add(c)) return false;
            }
        }

        for (int boxRow = 0; boxRow < 3; boxRow++) {
            for (int boxCol = 0; boxCol < 3; boxCol++) {
                HashSet<Character> boxSet = new HashSet<>();
                for (int r = 0; r < 3; r++) {
                    for (int c = 0; c < 3; c++) {
                        char val = board[boxRow*3 + r][boxCol*3 + c];
                        if (val != '.' && !boxSet.add(val)) return false;
                    }
                }
            }
        }

        return true;
    }
}
