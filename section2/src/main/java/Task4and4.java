import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

// 💡- Сделать задание 4.3. с использованием классов Date и SimpleDateFormat и их соответствующих методов.
public class Task4and4 {
    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        String strDate = scanner.nextLine();

        SimpleDateFormat getDateFormatter = new SimpleDateFormat("dd.MM.yyyy");
        SimpleDateFormat setNewDateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        Date newStrDate =  getDateFormatter.parse(strDate);

        System.out.println(setNewDateFormatter.format(newStrDate));
    }
}
