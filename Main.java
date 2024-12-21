import java.util.*;
/**
 * Main class for processing text and finding sentences with common words.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введіть текст для аналізу:");
        String input = scanner.nextLine();

        if (input.trim().isEmpty()) {
            System.err.println("Помилка: Ви не ввели жодного тексту.");
            return;
        }

        if (input.matches("^[^a-zA-Zа-яА-Яіїєґ]+$")) {
            System.err.println("Помилка: Текст повинен містити хоча б одне слово, а не лише цифри чи символи.");
            return;
        }

        input = input.replaceAll("[\t\s]+", " "); // Замінити табуляції та пробіли на один пробіл

        try {
            Text text = new Text(input);
            System.out.println("Оброблений текст:");
            System.out.println(text);

            int maxSentenceCount = Sentence.findMaxSentencesWithCommonWords(text);
            System.out.println("Максимальна кількість речень із спільними словами: " + maxSentenceCount);

        } catch (Exception e) {
            System.err.println("Сталася помилка: " + e.getMessage());
        }
    }

}