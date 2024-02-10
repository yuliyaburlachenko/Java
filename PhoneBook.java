//Реализуйте структуру телефонной книги с помощью HashMap.
//Программа также должна учитывать, что в во входной структуре
// будут повторяющиеся имена с разными телефонами, их необходимо считать,
// как одного человека с разными телефонами. Вывод должен быть отсортирован
// по убыванию числа телефонов.

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class PhoneBook {

    static public void main(String[] args) {
        
        import org.jetbrains.annotations.NotNull;



class PersonCount implements Comparable<PersonCount> {
    private final String name;
    private Integer count;

    PersonCount(String name, Integer count) {
        this.name = name;
        this.count = count;
    }

    public String getName() {
        return name;
    }


    @Override
    public int compareTo(@NotNull PersonCount o) {
        return -count.compareTo(o.count);
    }
}

class PhoneBook {
    private static HashMap<String, ArrayList<Integer>> phoneBook = new HashMap<>();

    public void add(String name, Integer phoneNum) {

        if (phoneBook.containsKey(name)) {
            phoneBook.get(name).add(phoneNum);
        } else {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(phoneNum);
            phoneBook.put(name, list);
        }

    }

    public ArrayList<Integer> find(String name) {
        ArrayList<Integer> list = new ArrayList<>();
        if (phoneBook.containsKey(name)) {
            list = phoneBook.get(name);
        }
        return list;
    }

    public static HashMap<String, ArrayList<Integer>> getPhoneBook() {
        return phoneBook;
    }

    public static void printPhoneBook() {
        ArrayList<PersonCount> persons = new ArrayList<>();
        for (String name : phoneBook.keySet()) {
            ArrayList<Integer> list = phoneBook.get(name);
            persons.add(new PersonCount(name, list.size()));
        }
        Collections.sort(persons);
        for (PersonCount p : persons) {
            System.out.println(p.getName() + " Phone numbers: " + phoneBook.get(p.getName()));
        }
    }
}

public class PhoneBookNew {
    public static void main(String[] args) {
        PhoneBook myPhoneBook = new PhoneBook();
        ;
        myPhoneBook.add("Ivanov", 1223445);
        myPhoneBook.add("Ivanov", 4536363);
        myPhoneBook.add("Ivanov", 4536963);
        myPhoneBook.add("Petrov", 5454556);
        myPhoneBook.add("Petrov", 2345233);
        myPhoneBook.add("Sidorov", 8329923);
        myPhoneBook.add("Sidorov", 8329323);
        myPhoneBook.add("Sidorov", 1233434);

        System.out.println(myPhoneBook.find("Petrov"));
        System.out.println(PhoneBook.getPhoneBook());
        System.out.println(myPhoneBook.find("Me"));
        PhoneBook.printPhoneBook();
    }
}
    }

}