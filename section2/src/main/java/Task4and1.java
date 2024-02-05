import java.util.Scanner;

/*
💡- Ввести с консоли строку, сохранить ее в строковой переменной

💡- Ввести с консоли подстроку, сохранить ее во второй строковой переменной

💡- Подсчитать сколько раз подстрока встречается в строке и вывести это значение на экран.
*/
public class Task4and1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String one = scanner.nextLine();

        String two = scanner.nextLine();

        int counter = 0;

        int index = 0;

        while (index != -1) {
            index = one.indexOf(two, index);

            if (index != -1) {
                counter++;
                index+=two.length();
            }
        }

        System.out.println(one.indexOf(two));
    }

}
