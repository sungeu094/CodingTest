package level2;

public class level2_68936_recursion {
    private static boolean extractSmallBoard(int[][] board, int[][] smallBoard, int startRow, int startCol) {
        boolean notReduction = false;
        int firstValue = board[startRow][startCol];
        System.out.println("첫번째 value : " + firstValue);
        for (int i = 0; i < smallBoard.length; i++) {
            for (int j = 0; j < smallBoard.length; j++) {
                smallBoard[i][j] = board[startRow + i][startCol + j];
                if (board[startRow + i][startCol + j] != firstValue) {
                    notReduction = true;
                }
            }
        }
        return notReduction;
    }

    private static int[][] SmallBoard(int[][] board, int[][] smallBoard, int startRow, int startCol) {

        for (int i = 0; i < smallBoard.length; i++) {
            for (int j = 0; j < smallBoard.length; j++) {
                smallBoard[i][j] = board[startRow + i][startCol + j];
            }
        }

        return smallBoard;
    }

    private static int[] repeat(int[][] board, int countZero, int countOne) {
        int divSize = board.length / 2;
        int[][] smallBoard = new int[divSize][divSize];
        System.err.println("countZero + " + countZero);
        if (!extractSmallBoard(board, smallBoard, 0, 0)) {
            if (board[0][0] == 0) {
                countZero -= ((int) Math.pow(divSize, 2) - 1);
                System.out.println("삭제 0 : " + countZero);

            } else {
                countOne -= ((int) Math.pow(divSize, 2) - 1);
            }

        } else {
            smallBoard = SmallBoard(board, smallBoard, 0, 0);
            int[] result = repeat(smallBoard, countZero, countOne);
            countZero = result[0];
            countOne = result[1];
            System.out.println("0 축소값 : " + countZero + " 1 축소값 : " + countOne);
        }

        if (!extractSmallBoard(board, smallBoard, 0, divSize)) {
            if (board[0][divSize] == 0) {
                countZero -= ((int) Math.pow(divSize, 2) - 1);
            } else {
                countOne -= ((int) Math.pow(divSize, 2) - 1);
            }
        } else {
            smallBoard = SmallBoard(board, smallBoard, 0, divSize);
            int[] result = repeat(smallBoard, countZero, countOne);
            countZero = result[0];
            countOne = result[1];
            System.out.println("0 축소값 : " + countZero + " 1 축소값 : " + countOne);
        }

        if (!extractSmallBoard(board, smallBoard, divSize, 0)) {
            if (board[divSize][0] == 0) {
                countZero -= ((int) Math.pow(divSize, 2) - 1);
            } else {
                countOne -= ((int) Math.pow(divSize, 2) - 1);
            }
        } else {
            smallBoard = SmallBoard(board, smallBoard, divSize, 0);
            int[] result = repeat(smallBoard, countZero, countOne);
            countZero = result[0];
            countOne = result[1];
            System.out.println("0 축소값 : " + countZero + " 1 축소값 : " + countOne);

        }

        if (!extractSmallBoard(board, smallBoard, divSize, divSize)) {
            if (board[divSize][divSize] == 0) {
                countZero -= ((int) Math.pow(divSize, 2) - 1);
            } else {
                countOne -= ((int) Math.pow(divSize, 2) - 1);
            }
        } else {
            smallBoard = SmallBoard(board, smallBoard, divSize, divSize);
            int[] result = repeat(smallBoard, countZero, countOne);
            countZero = result[0];
            countOne = result[1];
            System.out.println("0 축소값 : " + countZero + " 1 축소값 : " + countOne);

        }

        return new int[] { countZero, countOne };
    }

    private static int countNum(int[][] board) {
        int countZero = 0;
        for (int[] boardRow : board) {
            for (int boardNum : boardRow) {
                if (boardNum == 0) {
                    countZero++;
                }
            }
        }

        return countZero;
    }

    public static void main(String[] args) {
        // 일단 숫자는 총 4n^2개를 가지고 있음.
        int[][] entireArr = { { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 } };

        int entireSize = entireArr.length;
        int countZero = countNum(entireArr);
        int last[];
        if (countZero == (int) Math.pow(entireSize, 2)) {
            last = new int[] { 1, 0 };
        } else if (countZero == 0) {
            last = new int[] { 0, 1 };
        } else {
            int countOne = (int) Math.pow(entireSize, 2) - countZero;
            last = repeat(entireArr, countZero, countOne);
        }
        System.out.println("countZero : " + last[0] + " countOne : " + last[1]);
    }
}
