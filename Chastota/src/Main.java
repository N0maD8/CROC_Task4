import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        /**
         * Подсчет частоты появления символа.
         * @author: Назаров Максим
         */
        String inputFileName = "C:\\Users\\ASER\\Desktop\\Chastota\\src\\input.txt";
        String outputFileName = "C:\\Users\\ASER\\Desktop\\Chastota\\src\\output.txt";

        try {
            // Чтение файла input.txt
            BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
            String line;
            StringBuilder text = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                text.append(line);
            }

            // Подсчет частоты появления каждого символа
            Map<Character, Integer> frequencyCounter = new HashMap<>();
            for (char c : text.toString().toCharArray()) {
                if (c != ' ' && c != '\n') { // Исключение пробелов и переводов строк
                    frequencyCounter.put(c, frequencyCounter.getOrDefault(c, 0) + 1);
                }
            }

            // Сортировка результатов по частоте
            List<Map.Entry<Character, Integer>> sortedEntries = new ArrayList<>(frequencyCounter.entrySet());
            Collections.sort(sortedEntries, (e1, e2) -> e2.getValue().compareTo(e1.getValue()));

            // Запись результатов в файл output.txt
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName));

            for (Map.Entry<Character, Integer> entry : sortedEntries) {
                writer.write(entry.getKey() + "=" + entry.getValue() + "\n");
            }

            reader.close();
            writer.close();

            System.out.println("Результаты успешно записаны в файл " + outputFileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
