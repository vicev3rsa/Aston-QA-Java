package Lesson13_ex1;
import java.util.HashMap;
        import java.util.HashSet;
        import java.util.Map;
        import java.util.Set;

public class UniqueWords {

    public static void main(String[] args) {

        String[] words = {"apple", "orange", "banana", "apple", "kiwi", "banana", "grape", "kiwi", "apple", "orange", "peach", "grape", "lemon", "lime", "apple", "peach", "banana", "kiwi", "grape", "peach"};
        // Для хранения уникальных слов
        Set<String> uniqueWords = new HashSet<>();

        // Для подсчета частоты встречаемости каждого слова
        Map<String, Integer> wordCount = new HashMap<>();

        // Проходимся по массиву слов
        for (String word : words) {

            // Добавляем слово в множество уникальных слов
            uniqueWords.add(word);

            // Если слово уже есть в карте, увеличиваем его счетчик
            if (wordCount.containsKey(word)) {
                wordCount.put(word, wordCount.get(word) + 1);
            } else {

                // Иначе добавляем слово в карту с начальным значением 1
                wordCount.put(word, 1);
            }
        }

        // Выводим список уникальных слов
        System.out.println("Unique words:");
        for (String word : uniqueWords) {
            System.out.println(word);
        }

        // Выводим частоту встречаемости каждого слова
        System.out.println("\nWord counts:");
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}


