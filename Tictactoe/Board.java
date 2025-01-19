public class Board {
    private String[][] grid;
    private int size;

    public Board(int size) {
        this.size = size;
        grid = new String[size][size];
        int cellNumber = 1;

        
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = String.valueOf(cellNumber++);
            }
        }
    }

    public void displayBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(" " + grid[i][j] + " ");
                if (j < size - 1) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (i < size - 1) {
                System.out.println("---".repeat(size).substring(0, size * 3 - 1));
            }
        }
    }

    public boolean isValidMove(int cell) {
        String cellStr = String.valueOf(cell);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (grid[i][j].equals(cellStr)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void updateCell(int cell, char symbol) {
        String cellStr = String.valueOf(cell);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (grid[i][j].equals(cellStr)) {
                    grid[i][j] = String.valueOf(symbol);
                    return;
                }
            }
        }
    }

    public boolean isWinningMove(int cell, char symbol) {
        String symbolStr = String.valueOf(symbol);

        for (int i = 0; i < size; i++) {
            // Check row
            if (allMatch(grid[i], symbolStr)) return true;

            // Check column
            String[] column = new String[size];
            for (int j = 0; j < size; j++) {
                column[j] = grid[j][i];
            }
            if (allMatch(column, symbolStr)) return true;
        }

        // Check diagonals
        String[] diagonal1 = new String[size];
        String[] diagonal2 = new String[size];
        for (int i = 0; i < size; i++) {
            diagonal1[i] = grid[i][i];
            diagonal2[i] = grid[i][size - i - 1];
        }
        return allMatch(diagonal1, symbolStr) || allMatch(diagonal2, symbolStr);
    }

    private boolean allMatch(String[] array, String symbol) {
        for (String s : array) {
            if (!s.equals(symbol)) return false;
        }
        return true;
    }

    public boolean isFull() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (grid[i][j].matches("\\d+")) {
                    return false;
                }
            }
        }
        return true;
    }

    public int getSize() {
        return size;
    }
    public boolean isCellEmpty(int cell) {
        int row = (cell - 1) / size;
        int col = (cell - 1) % size;
        return grid[row][col].equals(" ");
    }
}
