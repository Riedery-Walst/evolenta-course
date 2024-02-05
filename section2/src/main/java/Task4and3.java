import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/*
💡- Ввести строку с датой формата: 31.12.2020

💡- Преобразовать строку даты в формат: 2020-12-31
*/
public class Task4and3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String strDate = scanner.nextLine();

        DateTimeFormatter originalDatePattern = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        LocalDate toDate = LocalDate.parse(strDate, originalDatePattern);

        System.out.println(toDate);
    }
}