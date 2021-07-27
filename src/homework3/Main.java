package homework3;
import java.util.*;
//1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
// Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем). Посчитать сколько раз встречается каждое слово.
//2. Написать простой класс ТелефонныйСправочник, который хранит в себе список фамилий и телефонных номеров.
// В этот телефонный справочник с помощью метода add() можно добавлять записи. С помощью метода get() искать номер телефона по фамилии.
// Следует учесть, что под одной фамилией может быть несколько телефонов, тогда при запросе такой фамилии должны выводиться все телефоны.
// Желательно как можно меньше добавлять своего, чего нет в задании (т.е. не надо в телефонную запись добавлять еще дополнительные поля (имя, отчество, адрес),
// делать взаимодействие с пользователем через консоль и т.д.).
// Консоль желательно не использовать (в том числе Scanner), тестировать просто из метода main() прописывая add() и get().
public class Main {

    public static void main(String[] args) {
        String[] words = new String[]{"Коробка","Винт","Гайка",
                "Коробка","Винт","Гайка",
                "Коробка","Шайба","Гайка",
                "Ключ","Винт","Гайка",
                "Коробка","Винт","Гайка",};

        Set<String> setWords = new HashSet<>();

        Collections.addAll(setWords, words);

        for(String word : setWords) {
            System.out.println(word);
        }

        Map<String, String> phonebook = new Phonebook();
        ((Phonebook) phonebook).add("Сидоров", "8989595");
        ((Phonebook) phonebook).add("Петров", "2626156");
        ((Phonebook) phonebook).add("Сидоров", "7263121");

        for (Map.Entry<String, String> entry : phonebook.entrySet()) {
            System.out.println("Name =  " + entry.getKey() + " Телефон = " + entry.getValue());
        }

        System.out.println(phonebook.get("Сидоров"));
    }
}

class Phonebook extends TreeMap {

    public void add (String name, String phone){
        if(this.containsKey(name)) {
            this.put(name, this.get(name) + "," + phone);
        } else {
            this.put(name, phone);
        }
    }

}