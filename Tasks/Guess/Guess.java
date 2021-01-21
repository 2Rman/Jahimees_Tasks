package Guess;

public class Guess {
    public static void main(String[] args) {

        Messager.helloMessage();
        do{
            Messager.configs();
            Messager.core();
        } while(Messager.replay());
    }
}
