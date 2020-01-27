import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/*
+1. Полностью разобраться с кодом, попробовать переписать с нуля, стараясь не подглядывать в методичку;
+2. Переделать проверку победы, чтобы она не была реализована просто набором условий, например, с использованием циклов.
+3. * Попробовать переписать логику проверки победы, чтобы она работала для поля 5х5 и количества фишек 4. Очень желательно не делать это просто набором условий для каждой из возможных ситуаций;
-4. *** Доработать искусственный интеллект, чтобы он мог блокировать ходы игрока.
 */

public class classLesson4 {
    private char[][] field;
    private int fieldSize = 3;

    public void ticTacToe() {
        /* 1. Спросим у пользователя размер поля (min 3)
        2. Спросим у пользователя длину выигрышной комбинации (мин 3 - размер поля)
        3. Показать поле
        4. Предложить пользователю сделать ход и ввести номер строки и столбца
        5. проверка указанных значений на допустимые величины (число от 1 до размер поля)
        6. Проверяем пусто - ли в ячейке
            - если пусто, то ставим Х в указанную ячейку
            - если не пусто, то возвращаемся на шаг 4
        7. Проверяем на победу или на ничью
        8. Делает ход комп
        9. Делаем 6 и 7 для хода комп
        10. Возвращаемся на 3
        */

        System.out.println("Введите размер поля от 3 до 10");
        this.fieldSize = getNumberFromScanner(3, 10);

        System.out.println("Введите длину серии для победы от 3 до " + this.fieldSize);
        int lengthForWin = getNumberFromScanner(3, this.fieldSize);

        boolean gameIsOver = false;
        int row, col = 0;

        this.field = new char[this.fieldSize][this.fieldSize];
        for (int i = 0; i < this.fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                field[i][j] = '*';
            }

        }

        while (!gameIsOver) {
            showField();

            System.out.println("Введите номер строки");
            row = getNumberFromScanner(1, this.fieldSize);

            System.out.println("Введите номер столбца");
            col = getNumberFromScanner(1, this.fieldSize);

            if (!setMove('X', row, col)) {
                System.out.println("Клетка занята");
                continue;
            }

            gameIsOver = checkWin(lengthForWin);
            if (gameIsOver) {
                showField();
                System.out.println("Вы победили!");
            }

            moveComputer();
            gameIsOver = checkWin(lengthForWin);
            if (gameIsOver) {
                showField();
                System.out.println("Компьютер победил!");
            }

        }
    }

    private void moveComputer() {
        boolean done = false;
        int row, col = 1;
        Random random = new Random();

        while (!done) {
            row = random.nextInt(fieldSize) + 1;
            col = random.nextInt(fieldSize) + 1;

            //System.out.println("col:"+col+"; row:"+row);
            done = setMove('O', row, col);
        }
    }

    private boolean setMove(char val, int row, int col) {
        if (this.field[row - 1][col - 1] == '*') {
            this.field[row - 1][col - 1] = val;
            return true;
        }
        return false;
    }

    private boolean checkWin(int lengthForWin) {
        char val = '*';
        int valcnt = 0;
        for (int i = 0; i < fieldSize; i++) {

            //  Прохдим строки
            val = '*';
            valcnt = 0;
            for (int j = 0; j < fieldSize - 1; j++) {

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
            for (int j = 0; j < fieldSize - 1; j++) {

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


    private void showField() {
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

    private static int getNumberFromScanner(int min, int max) {
        Scanner sc = new Scanner(System.in);
        int x;
        do {
            x = sc.nextInt();
        } while (x < min || x > max);
        return x;
    }

}
