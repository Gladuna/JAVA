import java.util.*;

public class PhoneBook {
    public static void main(String[] args) {
        // Создаем телефонную книгу
        Map<String, List<String>> phoneBook = new HashMap<>();

        // Добавляем записи
        addContact(phoneBook, "Иванов", "123-456-789");
        addContact(phoneBook, "Петров", "987-654-321");
        addContact(phoneBook, "Сидоров", "111-222-333");
        addContact(phoneBook, "Иванов", "555-666-777");
        addContact(phoneBook, "Петров", "888-999-000");
        addContact(phoneBook, "Сидоров", "444-333-222");

        // Выводим отсортированный список
        printSortedPhoneBook(phoneBook);
    }

    // Метод для добавления контакта в телефонную книгу
    private static void addContact(Map<String, List<String>> phoneBook, String name, String phoneNumber) {
        // Если имя уже присутствует в книге, добавляем новый телефон в список
        phoneBook.computeIfAbsent(name, k -> new ArrayList<>()).add(phoneNumber);
    }

    // Метод для вывода телефонной книги в отсортированном порядке
    private static void printSortedPhoneBook(Map<String, List<String>> phoneBook) {
        // Создаем список записей (имя, количество телефонов)
        List<Map.Entry<String, List<String>>> entries = new ArrayList<>(phoneBook.entrySet());

        // Сортируем список по убыванию количества телефонов
        entries.sort((entry1, entry2) -> Integer.compare(entry2.getValue().size(), entry1.getValue().size()));

        // Выводим отсортированный список
        for (Map.Entry<String, List<String>> entry : entries) {
            String name = entry.getKey();
            List<String> phoneNumbers = entry.getValue();
            System.out.println(name + ": " + phoneNumbers.size() + " телефон(ов) - " + phoneNumbers);
        }
    }
}
