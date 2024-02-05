import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/*
💡- Ввести с консоли дату в формата: 31.12.2020, сохранить ее в переменной класса Date (преобразовав введенную строку с использованием SimpleDateFormat)

💡- Увеличить дату на 45 дней и вывести на экран

💡- Сдвинуть дату на начало года и вывести на экран

💡- Увеличить дату на 10 рабочих дней (считаем субботы и воскресенья выходными) и вывести на экран

💡- Ввести с консоли вторую дату в том же формате и сохранить ее в другой переменной класса Date

💡- Посчитать количество рабочих дней (субботы и воскресенья - выходные) между первой и второй датами введенными с консоли и вывести на экран
*/
public class Task5 {
    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите первую дату: ");
        String firstInput = scanner.nextLine();
        Date firstDate = parseStringToDate(firstInput);

        Date processDate = addDays(firstDate, 45);
        System.out.println("Увеличено на 45 дней: " + processDate);

        processDate = resetDate(processDate);
        System.out.println("Сброшено к дате: " + processDate);

        processDate = addWorkDays(processDate, 10);
        System.out.println("Добавлено 10 рабочих дней к дате: " + processDate);

        System.out.println("Введите вторую дату: ");
        String secondInput = scanner.nextLine();
        Date secondDate = parseStringToDate(secondInput);

        int workDays = getAmountOfWorkDaysBetweenDates(firstDate, secondDate);
        System.out.println("Всего рабочих дней между датами: " + workDays);
    }

    public static Date parseStringToDate(String input) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
        return simpleDateFormat.parse(input);
    }

    public static Date addDays(Date date, int days) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_YEAR, days);
        return calendar.getTime();
    }

    public static Date resetDate(Date date) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_YEAR, 1);
        return calendar.getTime();
    }

    public static Date addWorkDays(Date date, int workDays) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);

        while (workDays > 0) {
            calendar.add(Calendar.DAY_OF_YEAR, 1);

            if (calendar.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY &&
                    calendar.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
                workDays--;
            }
        }
        return calendar.getTime();
    }

    public static int getAmountOfWorkDaysBetweenDates(Date startDate, Date endDate) {
        Calendar firstCalendar = new GregorianCalendar();
        Calendar secondCalendar = new GregorianCalendar();

        firstCalendar.setTime(startDate);
        secondCalendar.setTime(endDate);

        int workDaysCounter = 0;

        while (firstCalendar.before(secondCalendar)) {
            firstCalendar.add(Calendar.DAY_OF_YEAR, 1);

            if (firstCalendar.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY &&
                    firstCalendar.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
                workDaysCounter++;
            }
        }
        return workDaysCounter;
    }
}
