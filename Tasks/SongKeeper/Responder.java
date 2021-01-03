package SongKeeper;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.IntStream;

class Responder {

    private static final String path = "d:\\ENGINEERING\\JAVA\\JahiTasks\\Tasks\\SongKeeper\\SongList.txt";
    private static ArrayList<String[]> songLine;
    private static final Scanner respondScanner = new Scanner(System.in);
    private static File file = new File(path);
    private static final String[] answers = new String[]{"1","2","3","4","5","6","7","8",""};
    private static File newFile;

    //Загрузка файла перед началом работы------------------------------------------------------------------------------
    public static void readFile(){

        String line;
        songLine = new ArrayList<>();

        if(file.exists()){
            try{
                FileReader fr = new FileReader(file);
                BufferedReader reader = new BufferedReader(fr);

                do{
                    line = reader.readLine();
                    songLine.add(line.split(":"));
                } while (line!=null);

                reader.close();
                fr.close();
            } catch (FileNotFoundException ex){
            } catch (IOException ex){
            } catch (NullPointerException ex){
            }
        }
    }

    //Обработка ответа пользователя------------------------------------------------------------------------------------
    public static void MainCases(String answer){
        for (String example:answers){
            if(answer.equals(example)){
                switch (answer){
                    case "1" -> showList(songLine);
                    case "2" -> addLine();
                    case "3" -> changeLine();
                    case "4" -> deleteLine();
                    case "5" -> sortLines(0);
                    case "6" -> sortLines(1);
                    case "7" -> newFile();
                    case "8" -> endTime();
                    case "" -> Writer.menu();
                }
            }
        }
    }

    //1. Вывести список, считанный из файла----------------------------------------------------------------------------
    private static void showList(ArrayList<String[]> toShow){
        int i = 1;
        System.out.println("Вывожу записи");
        for (String[] liner:toShow){
            System.out.println(i + ". " + liner[0] + " - " + liner[1] + " (" + liner[2] + ")");
            i++;
        }
    }

    //2. Добавить запись в файл----------------------------------------------------------------------------------------
    private static void addLine(){
        String[] newNote = new String[3];

        System.out.println("Добавляем запись в файл\nВведите исполнителя:");
        newNote[0] = respondScanner.nextLine();
        System.out.println("Введите название трека:");
        newNote[1] = respondScanner.nextLine();
        System.out.println("Введите жанр композиции:");
        newNote[2] = respondScanner.nextLine();

        songLine.add(newNote);
        showList(songLine);
    }

    //3. Редактирование записи в файле---------------------------------------------------------------------------------
    private static void changeLine(){
        int c = checker("редактирования");

        if(c <= songLine.size()){
            System.out.println("Редактируем запись:\n" +
            c + ". " + songLine.get(c-1)[0] + " - " +
            songLine.get(c-1)[1] + " (" + songLine.get(c-1)[2] + ")\n");
        }

        System.out.println("Введите новое имя исполнителя:");
        songLine.get(c-1)[0] = respondScanner.nextLine();
        System.out.println("Введите новое название трека:");
        songLine.get(c-1)[1] = respondScanner.nextLine();
        System.out.println("ведите новое название жанра композиции:");
        songLine.get(c-1)[2] = respondScanner.nextLine();

        System.out.println("Обновленная запись:\n" +
                c + ". " + songLine.get(c-1)[0] + " - " +
                songLine.get(c-1)[1] + " (" + songLine.get(c-1)[2] + ")\n");
    }

    //4. Удаление записи из файла--------------------------------------------------------------------------------------
    private static void deleteLine(){
        int c = checker("удаления");

        songLine.remove(c-1);
        showList(songLine);
    }

    //5-6. Сортировка и вывод списка по исполнителю или названию (по выбору пользователя)------------------------------
    private static void sortLines(int number){
        ArrayList<String[]> sortedSongLine = new ArrayList<>();
        ArrayList<String> points = new ArrayList<>();

        for (String[] line:songLine){
            points.add(line[number]);
        }
        Collections.sort(points);
        IntStream.range(0, points.size()).forEach(i->{
            for (String[] line:songLine){
                if (points.get(i).equals(line[number])){
                    sortedSongLine.add(line);
                }
            }
        });
        showList(sortedSongLine);
    }

    //7. Создание и редактирование нового файла------------------------------------------------------------------------
    private static void newFile(){
        String newPath = file.getParent();
        System.out.println(newPath);
        String answer;
        String newFileName;

        System.out.println("Введите имя нового файла");

        newFileName = respondScanner.nextLine();
        newFile = new File(newPath + "\\" + newFileName + ".txt");
        try{
            newFile.createNewFile();
        }catch (IOException ex) {
        }
        System.out.println("Файл создан\nНачать редактирование созданного файла?\n1. Да\n2. Нет\n");
        do{
            answer = respondScanner.nextLine();
            if((Integer.parseInt(answer)>2 || Integer.parseInt(answer)<1)){
                System.out.println("Введите 1 или 2");
            }
        } while ((Integer.parseInt(answer)>2 || Integer.parseInt(answer)<1));
        switch (answer) {
            case "1" -> {
                endTime();
                songLine.clear();
                System.out.println("Редактируем новый файл. Старый файл сохранен.");
                file = newFile;
            }
            case "2" -> System.out.println("Новый файл остается пустым. Продолжаем редактировать исходный файл");
        }
    }

    //8. Сохранение файла перед выходом из программы-------------------------------------------------------------------
    private static void endTime(){

        try{
            FileWriter fw;
            fw = new FileWriter(file);

            BufferedWriter writer = new BufferedWriter(fw);

            for (String[] line:songLine){
                writer.write(line[0] + ":" + line[1] + ":" + line[2] + "\n");
            }
            writer.close();
            fw.close();
        } catch (IOException ex){
        }
    }

    //Метод для ффода и проверки вводимого номера записи для удаления или изменения------------------------------------
    private static int checker(String action){
        int c;
        String answer;
        do{
            System.out.println("Введите номер записи для " + action);
            answer = respondScanner.nextLine();
            c = Integer.parseInt(answer);
            if (c > songLine.size()){
                System.out.println("Такого номера нет в списке!");
            }
        } while (c > songLine.size());
        return c;
    }
}
