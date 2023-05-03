import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class task1 {
    public static void main(String[] args) {
        // створюємо об'єкт Scanner для зчитування введення користувача
        Scanner scanner = new Scanner(System.in);

        // отримуємо ім'я файлу від користувача
        System.out.print("Введіть ім'я файлу для читання: ");
        String fileName = scanner.nextLine();

        // зчитуємо рядки з файлу та вилучаємо порожні рядки
        ArrayList<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    lines.add(line);
                }
            }
        } catch (IOException e) {
            System.err.println("Помилка читання файлу: " + e.getMessage());
            return;
        }

        // вилучаємо символи, які не є маленькими латинськими літерами
        ArrayList<String> filteredLines = new ArrayList<>();
        for (String line : lines) {
            String filteredLine = line.replaceAll("[^a-z]", "");
            if (!filteredLine.isEmpty()) {
                filteredLines.add(filteredLine);
            }
        }

        // сортуємо відфільтровані рядки та записуємо їх до файлу
        System.out.print("Введіть ім'я файлу для запису: ");
        String outputFileName = scanner.nextLine();
        try (FileWriter writer = new FileWriter(outputFileName)) {
            Collections.sort(filteredLines);
            for (String line : filteredLines) {
                writer.write(line + "\n");
            }
            System.out.println("Результати успішно записані у файл " + outputFileName);
        } catch (IOException e) {
            System.err.println("Помилка запису до файлу: " + e.getMessage());
            return;
        }
    }
}
