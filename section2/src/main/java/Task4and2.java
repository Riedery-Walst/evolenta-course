import java.util.Scanner;

/*
💡- Ввести строку

💡- Заменить в строке все слова "кака" и "бяка" на "вырезано цензурой"
*/
public class Task4and2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String in = scanner.nextLine();


        String forbiddenWordOne = "кака";
        String forbiddenWordTwo = "бяка";
        String placeholder = "вырезано цензурой";

        String output = in.replace(forbiddenWordOne, placeholder).replace(forbiddenWordTwo, placeholder);

        System.out.println(output);
    }
}
