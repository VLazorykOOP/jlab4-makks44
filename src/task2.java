import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class task2 {
    public static void main(String[] args) {
        // вказуємо шлях до теки з файлами
        File folder = new File("C:/Users/User/Desktop/Система Моделювання");
        // створюємо мапу для зберігання результатів
        HashMap<String, Integer> wordCountMap = new HashMap<>();

        // перебираємо файли в теку
        for (File file : folder.listFiles()) {
            if (file.isFile()) { // перевіряємо, що це файл, а не тека
                int wordCount = 0; // лічильник слів
                try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        line = line.trim(); // видаляємо пробіли з початку та кінця рядка
                        if (!line.isEmpty()) { // якщо рядок не порожній
                            String[] words = line.split("\\s+"); // розділяємо рядок на слова
                            wordCount += words.length; // додаємо кількість слів до лічильника
                        }
                    }
                    wordCountMap.put(file.getName(), wordCount); // зберігаємо кількість слів для файлу в мапу
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        // виводимо результати на екран
        for (String fileName : wordCountMap.keySet()) {
            int wordCount = wordCountMap.get(fileName);
            System.out.println(fileName + " - " + wordCount + " слів");
        }
    }
}
