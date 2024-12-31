import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        Collections.addAll(persons,
                new Person("Иван", "Иванов", 31),
                new Person("Мария", "Петрова", 15),
                new Person("Алексей", "Смирнов", 47),
                new Person("Иван", "Иванов", 31)
        );

        // toString()
        persons.forEach(System.out::println);

        // equals
        System.out.println(persons.get(0).equals(persons.get(1)));
        System.out.println(persons.get(0).equals(persons.get(3)));

        // сериализация
        Gson gson = new Gson();
        String json = gson.toJson(persons);
        System.out.println(json);

        // десериализация
        Type type = new TypeToken<ArrayList<Person>>() {}.getType();
        List<Person> personsFromJson = gson.fromJson(json, type);
        personsFromJson.forEach(System.out::println);
    }
}
