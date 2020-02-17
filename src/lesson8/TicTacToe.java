package lesson8;

import java.util.Random;

public class TicTacToe {
    private char[][] field;
    private int fieldSize = 3;
    private int stepsCount = 0;
    private boolean gameIsOver = false;
    private int stepsMax = fieldSize * fieldSize;
    private int lengthForWin = 3;
    private boolean isFinish = false;

    public TicTacToe() {

        this.field = new char[fieldSize][fieldSize];
        initGame();

    }

    public void initGame() {
        stepsCount = 0;
        /**
         * Заполняем поле символами которые обозначают пустую клетку
         **/
        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                field[i][j] = '*';
            }
        }
    }

    public void moveComputer() {
        boolean done = false;
        int row, col = 1;
        Random random = new Random();

        if (isFinish) return;

        while (!done) {
            row = random.nextInt(fieldSize);
            col = random.nextInt(fieldSize);

            //System.out.println("col:"+col+"; row:"+row);
            done = setMove('O', row, col);
        }
    }

    public boolean setMove(char val, int row, int col) {
        if (this.field[row][col] == '*') {
            this.field[row][col] = val;
            stepsCount++;

            //  Проверка на завершение
            updateFinish();
            return true;
        }
        return false;
    }

    public boolean checkWin() {
        char val = '*';
        int valcnt = 0;
        for (int i = 0; i < fieldSize; i++) {

            //  Проходим строки
            val = '*';
            valcnt = 0;
            for (int j = 0; j < fieldSize; j++) {
                //System.out.println("row=" + i + ";col=" + j);
                if (field[i][j] == '*') {
                    val = '*';
                    valcnt = 0;
                    continue;
                }

                if (field[i][j] == val) {
                    valcnt++;
                } else {
                    val = field[i][j];
                    valcnt = 1;
                }

                if (valcnt == lengthForWin) {
                    return true;
                }
            }

            // Проходим столбцы
            valcnt = 0;
            val = '*';
            for (int j = 0; j < fieldSize; j++) {

                if (field[j][i] == '*') {
                    val = '*';
                    valcnt = 0;
                    continue;
                }

                if (field[j][i] == val) {
                    valcnt++;
                } else {
                    val = field[j][i];
                    valcnt = 1;
                }

                if (valcnt == lengthForWin) {
                    return true;
                }
            }


            // Есть ли смысл заходить на проверку диагоналей
            if (i < lengthForWin - 1) {
                continue;
            }

            // Проходим диагонали */
            val = '*';
            valcnt = 0;

            for (int j = 0; j <= i; j++) {
                // System.out.println("x=" + j + ";y=" + (i - j));

                if (field[j][i - j] == '*') {
                    val = '*';
                    valcnt = 0;
                    continue;
                }

                if (field[j][i - j] == val) {
                    valcnt++;
                } else {
                    val = field[j][i - j];
                    valcnt = 1;
                }

                if (valcnt == lengthForWin) {
                    return true;
                }
            }

            // Проходим диагонали /*
            val = '*';
            valcnt = 0;

            for (int j = 0; j <= i; j++) {
                // System.out.println("i=" + (fieldSize - 1 - j) + ";j=" + (fieldSize - 1 - i + j));

                if (field[fieldSize - 1 - j][fieldSize - 1 - i + j] == '*') {
                    val = '*';
                    valcnt = 0;
                    continue;
                }

                if (field[fieldSize - 1 - j][fieldSize - 1 - i + j] == val) {
                    valcnt++;
                } else {
                    val = field[fieldSize - 1 - j][fieldSize - 1 - i + j];
                    valcnt = 1;
                }

                if (valcnt == lengthForWin) {
                    return true;
                }
            }


            // Проходим диагональ \*
            val = '*';
            valcnt = 0;

            for (int j = 0; j <= i; j++) {
                // System.out.println("x=" + j + ";y=" + (i - j));
                if (field[j][fieldSize - 1 - i + j] == '*') {
                    val = '*';
                    valcnt = 0;
                    continue;
                }

                if (field[j][fieldSize - 1 - i + j] == val) {
                    valcnt++;
                } else {
                    val = field[j][fieldSize - 1 - i + j];
                    valcnt = 1;
                }

                if (valcnt == lengthForWin) {
                    return true;
                }
            }

            // Проходим диагонали *\
            val = '*';
            valcnt = 0;

            for (int j = 0; j <= i; j++) {
                //System.out.println("x=" + (fieldSize - 1 - i + j) + ";y=" + j);
                if (field[fieldSize - 1 - i + j][j] == '*') {
                    val = '*';
                    valcnt = 0;
                    continue;
                }

                if (field[fieldSize - 1 - i + j][j] == val) {
                    valcnt++;
                } else {
                    val = field[fieldSize - 1 - i + j][j];
                    valcnt = 1;
                }

                if (valcnt == lengthForWin) {
                    return true;
                }
            }

        }
        return false;
    }


    public void showField() {
        StringBuilder field = new StringBuilder();
        StringBuilder header = new StringBuilder();
        for (int i = 0; i < fieldSize; i++) {
            if (i == 0) {
                header.append(" ").append("|1|");
            } else {
                header.append(i + 1).append("|");
            }
            field.append(i + 1).append("|");
            for (int j = 0; j < fieldSize; j++) {
                field.append(this.field[i][j]).append("|");
            }
            field.append("\n");
        }
        System.out.println(header + "\n" + field);
        //System.out.println(Arrays.deepToString(this.field).replace("], ", "]\n"));
    }


    public char getFieldValue(int x, int y) {
        return field[x][y];
    }

    private void updateFinish() {
        isFinish = checkWin();
        if (isFinish) {
            return;
        }

        if (stepsCount == stepsMax) {
            isFinish = true;
        }

    }

    public boolean getFinish() {
        return isFinish;
    }


    //    boolean gameIsOver = ticTacToe.checkWin();
//        if (gameIsOver) {
//        System.out.println("Вы победили!");
//    }
//        if (stepsCount == stepsMax) {
//        gameIsOver = true;
//        System.out.println("Ничья!");
//    }

}
