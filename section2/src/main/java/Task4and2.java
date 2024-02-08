import java.util.Scanner;

/*
💡- Ввести строку

💡- Заменить в строке все слова "кака" и "бяка" на "вырезано цензурой"
*/
public class Task4and2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String in = scanner.nextLine();

        String placeholder = "вырезано цензурой";

        String output = in.toLowerCase().replaceAll("(кака|бяка)", placeholder);

        System.out.println(output);
    }
}
