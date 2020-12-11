package ThreadCounter;

public class TreadCount {
    public static void main(String[] args) {


        int threadAll = 0;
        int threadDay = 50;

        for (int i = 0; i <= 90; i++) {
            if ((i % 7 == 0) && (threadDay > 30 )){
                threadDay -= 5;
            }
            threadAll += threadDay;
        }

        System.out.println("Ответ: 0 см Потому что Саша не подшивается))) Шутка... довольно дурацкая)");
        System.out.println("Саша истратил бы " + threadAll + " см ниток.");
    }
}