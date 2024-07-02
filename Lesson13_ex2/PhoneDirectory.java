package Lesson13_ex2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneDirectory {

    // HashMap для хранения фамилий и списка телефонных номеров
    private final Map<String, List<String>> directory;

    // Конструктор инициализирует HashMap
    public PhoneDirectory() {
        this.directory = new HashMap<>();
    }

    // Метод для добавления записи в телефонный справочник
    public void add(String surname, String phoneNumber) {

        // Если фамилия уже существует в справочнике
        if (directory.containsKey(surname)) {
            directory.get(surname).add(phoneNumber);
        } else {

            // Иначе создаем новый список для фамилии и добавляем номер
            List<String> phoneNumbers = new ArrayList<>();
            phoneNumbers.add(phoneNumber);
            directory.put(surname, phoneNumbers);
        }
    }

    // Метод для получения номеров телефонов по фамилии
    public List<String> get(String surname) {
        return directory.get(surname);
    }

    public static void main(String[] args) {
        PhoneDirectory phoneDirectory = new PhoneDirectory();

        // Добавляем записи в справочник
        phoneDirectory.add("Ivanov", "+79811111111");
        phoneDirectory.add("Petrov", "+79112222222");
        phoneDirectory.add("Ivanov", "+79013333333");
        phoneDirectory.add("Koroleva", "+79214444444");

        // Ищем номера по фамилии
        System.out.println("Ivanov: " + phoneDirectory.get("Ivanov"));
        System.out.println("Petrov: " + phoneDirectory.get("Petrov"));
        System.out.println("Koroleva: " + phoneDirectory.get("Koroleva"));
        System.out.println("Noexistov: " + phoneDirectory.get("Noexistov")); // Не существует в справочнике
    }
}