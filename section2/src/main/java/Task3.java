import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/*
💡- Заполнить массив из 20 элементов случайными целыми значениями в диапазоне от 1 до 15

💡- Вывести на экран содержимое массива

💡- Вывести на экран значения, которые встречаются в массиве больше одного раза, в формате, вида:
"число '3' встречается 2 раза";
"число '5' встречается 3 раза" и т.д.
*/
public class Task3 {
    public static void main(String[] args) {
        int[] array = new int[20];
        Random random = new Random();

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(15) + 1;
        }

        System.out.println(Arrays.toString(array));

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : array) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println("Число '" + entry.getKey() + "' встречается " + entry.getValue() + " раза");
            }
        }
    }
}
