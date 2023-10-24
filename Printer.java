import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class PhoneBook {
    private static HashMap<String, ArrayList<Integer>> phoneBook = new HashMap<>();

    public void add(String name, Integer phoneNum) {

        // Введите свое решение ниже
        var phones = phoneBook.get(name);
        if (phones==null) {
          phones = new ArrayList<>();
          phones.add(phoneNum);
          phoneBook.put(name, phones);
        } else {
          phones.add(phoneNum);
          phoneBook.put(name, phones);
        }

    }

    public ArrayList<Integer> find(String name) {
    // Введите свое решение ниже
        return phoneBook.getOrDefault(name, new ArrayList<>());
    }

    public static HashMap<String, ArrayList<Integer>> getPhoneBook() {
    // Введите свое решение ниже
        return phoneBook;
    }

    public static String getAll() {
        StringBuilder stringBuilder = new StringBuilder();
        List<Map.Entry<String, ArrayList<Integer>>> entries = new ArrayList<>(phoneBook.entrySet());
        entries.sort((entry1, entry2) -> Integer.compare(entry2.getValue().size(), entry1.getValue().size()));
        for (Map.Entry<String, ArrayList<Integer>> entry : entries) {
            ArrayList<Integer> phoneNumbers = entry.getValue();
            stringBuilder.append(entry.getKey());
            stringBuilder.append(" : ");
            stringBuilder.append(phoneNumbers);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
// Не удаляйте этот класс - он нужен для 

public class Printer {
    public static void main(String[] args) {
        String name1;
        String name2;
        String name3;
        int phone1;
        int phone2;
        int phone3;

        if (args.length == 0) {
            name1 = "Ivanov";
            name2 = "Petrov";
            name3 = "Ivanov";
            phone1 = 123456;
            phone2 = 654321;
            phone3 = 654521;
        } else {
            name1 = args[0];
            name2 = args[1];
            name3 = args[2];
            phone1 = Integer.parseInt(args[3]);
            phone2 = Integer.parseInt(args[4]);
            phone3 = Integer.parseInt(args[5]);
        }

        PhoneBook myPhoneBook = new PhoneBook();
        myPhoneBook.add(name1, phone1);
        myPhoneBook.add(name2, phone2);
        myPhoneBook.add(name3, phone3);

        System.out.println(PhoneBook.getAll());
    }
}