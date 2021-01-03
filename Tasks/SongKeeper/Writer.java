package SongKeeper;

public class Writer {
    public static void helloMessage(){
        System.out.println("Добро пожаловать в \"Song Keeper\"!\n");
    }
    public static void menu(){
        System.out.println("Сделайте выбор:\n");
        System.out.println(
                        "1. Показать список\n" +
                        "2. Добавить запись\n" +
                        "3. Редактировать запись\n" +
                        "4. Удалить запись\n" +
                        "5. Сортировка и вывод списка по исполнителю\n" +
                        "6. Сортировка и вывод списка по названию\n" +
                        "7. Создать новый файл\n" +
                        "8. Завершить работу с программмой\n");
    }
}
