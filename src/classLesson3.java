/*
1. Написать программу, которая загадывает случайное число от 0 до 9, и пользователю
дается 3 попытки угадать это число. При каждой попытке компьютер должен сообщить больше
ли указанное пользователем число чем загаданное, или меньше. После победы или проигрыша
выводится запрос – «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).

 */


import java.util.Random;
import java.util.Scanner;

public class classLesson3 {
    public static Scanner sc = new Scanner(System.in);

public void start(){
    int nextGame = 1;

    while (nextGame==1) {
        ugadaika();
        System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
        nextGame = getNumberFromScanner(0,1);
    }
}


    public void ugadaika() {
        int userNum = 0;
        Random random = new Random();
        int rightNum = random.nextInt(9);

        System.out.println("Загадано число от 0 до 9. Попробуйте угадать. Дается три попытки.");
        for (byte i = 1; i <= 3; i++) {
            System.out.println("Попытка " + i + ". Введите число:");
            userNum = getNumberFromScanner(0, 9);
            if (userNum == rightNum) {
                System.out.println("Поздравляю! Вы угадали!");
                break;
            }

            if (userNum < rightNum) {
                System.out.println("Ваше число меньше, чем загаданное.");
            } else {
                System.out.println("Ваше число больше, чем загаданное.");
            }

        }

        if (userNum != rightNum) {
            System.out.println("К сожалению Вы проиграли.");
        }


    }

    public static int getNumberFromScanner(int min, int max) {
        int x;
        do {
            x = sc.nextInt();
        } while (x < min || x > max);
        return x;
    }
}
