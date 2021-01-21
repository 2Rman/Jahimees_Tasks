package Guess;

import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;

public class Messager {

    private static Scanner playerAnswers = new Scanner(System.in);
    private static int range;
    private static int attempts;
    private static Random randomiser = new Random();

    static void helloMessage(){
        System.out.println("Добро пожаловать!\n" +
                "Сыграем в игру \"Угадай число\"\n" +
                "Все просто: я загадываю число, ты пробуешь угадать\n");
    }

    static void configs(){
        System.out.println("В каком диапазоне чисел загадать число?");
        range = playerAnswers.nextInt();
        System.out.println("Со скольки попыток попробуешь угадать?");
        attempts = playerAnswers.nextInt();
        System.out.println("А теперь угадывай!");
    }

    static void core(){
        int answer;
        int numberForGuess = randomiser.nextInt(range)+1;

        do{
            attempts--;
            answer = playerAnswers.nextInt();
            if (answer > numberForGuess)
            {
                System.out.println("Нет. Мое число меньше...\n" +
                        "У тебя осталось " + attempts + " попыток!");
            }
            else if (answer < numberForGuess)
            {
                System.out.println("Нет. Мое число больше...\n" +
                        "У тебя осталось " + attempts + " попыток!");
            } else System.out.println("Верно! Поздравляю, ты победил!");
        } while (answer != numberForGuess && attempts != 0);

        if (attempts == 0) System.out.println("К сожалению, все попытки были тщетны и ты проиграл!" +
                "Мое число было " + numberForGuess + "!");
    }

    static boolean replay(){
        System.out.println("Сыграем еще раз?\n1. Да\n2. Нет");
        return playerAnswers.nextInt() == 1;
    }
}
