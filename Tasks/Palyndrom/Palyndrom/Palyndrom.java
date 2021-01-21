package Palyndrom;
import java.util.Scanner;

public class Palyndrom {

    public static void main(String[] args) {

        //ПОСМОТРЕЛ УРОК ПРО StringBuilder...;

        Scanner scanner = new Scanner(System.in);
        String variable;

        System.out.println("Введите текст для проверки на палиндром:");
        variable = scanner.nextLine();

        StringBuilder builder = new StringBuilder();
        builder.append(variable);

        String variableRev = builder.toString();
        String variableFov = builder.reverse().toString();

        if (variableFov.equals(variableRev)){
            System.out.println("Это палиндром");
        } else {System.out.println("Выражение не является палиндромом");}
    }
}

        //А это старая, но тоже стабильно работающая версия

        /*int decrem;
        boolean result;

        result = false;

        System.out.println(variable.length());

        if(variable.length() == 2){decrem = 0;}
        else if ((variable.length()) % 2 == 0){decrem = 1;}
        else decrem = 0;

        for (int i = 0; i < (variable.length()-decrem)/2; i++){
            if (variable.charAt(i) != variable.charAt((variable.length()-1)-i)){
                result = false;
                break;
            } else result = true;
        }

        if (result) System.out.println("Это полиндром.");
        else System.out.println("Выражение не является полиндромом.");*/

