package CheckPassword;

import java.io.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CheckPassword {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String path = "d:\\ENGINEERING\\JAVA\\JahiTasks\\Tasks\\CheckPassword\\pass.txt";

        System.out.println("Пароль:");
        String password = scanner.nextLine();

        File file = new File(path);
        if (file.exists()){
            try {
                FileReader fr = new FileReader(file);
                BufferedReader reader = new BufferedReader(fr);

                String line = reader.readLine();

                if (password.equals(line)) {
                    System.out.println("Пароль подтвержден!");
                } else System.out.println("Не удалось подтвердить пароль.");

            } catch (FileNotFoundException ex){
                Logger.getLogger(CheckPassword.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex){
                Logger.getLogger(CheckPassword.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
