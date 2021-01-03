package SongKeeper;


import java.util.Scanner;

public class SongKeeper {
    public static void main(String[] args) {
        String result;
        Responder.readFile();
        Scanner scanner = new Scanner(System.in);

        Writer.helloMessage();
        Writer.menu();

        do{
            Responder.MainCases(result = scanner.nextLine());
        } while (!result.equals("8"));
    }
}
