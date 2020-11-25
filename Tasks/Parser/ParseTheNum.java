/* This programm parses any number whith a whitespace
*  Used 11 lines instead of 10, cuz textual part */

package Parser;

import java.util.Scanner;

public class ParseTheNum {

    public static void main(String[] args) {

        System.out.println("Веедите любое ЦЕЛОЕ число (арабскими символами)");
        Scanner input = new Scanner(System.in);
        String numeric;
        boolean result = false;

        do {
            numeric = input.nextLine();
            if (numeric.matches("-?\\d+(\\.\\d+)?")){
                result = numeric.matches("-?\\d+(\\.\\d+)?");
            }
        } while (!result);

        for (int i = 0; i < numeric.length(); i++) {
            System.out.print("Результат разделения:\n" + numeric.charAt(i) + " ");
        }
    }
}

/*      ПОПЫТКА НЕУВЕНЧАВШАЯСЯ УСПЕХОМ
        (ПОДУМАЛ, ЧТО ЭТО ТОЖЕ ПОЛЕЗНО БУДЕТ СКИНУТЬ ДЛЯ КРИТИКИ В МОЮ СТОРОНУ)


        String numeric;
        char[] numList = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
        int error = 0;

        Scanner input = new Scanner(System.in);

        do {
            numeric = input.nextLine();
            int[] comparer = new int[numeric.length()];
            for (int i = 0; i < numeric.length(); i++) {
                if ((comparer[i] = Arrays.binarySearch(numList, numeric.charAt(i))) > 0)
                    error = comparer[i];
                System.out.println(error);
            }
        }while (error > 0);

        for (int i = 0; i < numeric.length(); i++) {
            System.out.print(numeric.charAt(i) + " ");
        }
    }
}*/

/*return str.matches("-?\\d+(\\.\\d+)?")*/


