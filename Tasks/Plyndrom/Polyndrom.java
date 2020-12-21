package Plyndrom;
import java.util.Scanner;

public class Polyndrom {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String variable;

        System.out.println("Введите текст для проверки на полиндром:");

        variable = scanner.nextLine();
        int decrem;
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
        else System.out.println("Выражение не является полиндромом.");
    }
}
