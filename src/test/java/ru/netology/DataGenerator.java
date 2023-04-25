package ru.netology;

import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class DataGenerator {
    private DataGenerator() {

    }

    public static String generateDate(int shift) {
        return LocalDate.now().plusDays(shift).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    public static String generateCity() {
        var cities = new String[]{"Москва", "Санкт-Петербург", "Воронеж", "Тула", "Саратов", "Уфа",
                "Нижний Новгород", "Казань", "Краснодар", "Самара", "Волгоград", "Ярославль", "Пермь"};
        return cities[new Random().nextInt(cities.length)];
    }

    public static String generateName(String local) {
        var faker = new Faker(new Locale(local));
        return faker.name().lastName() + " " + faker.name().firstName();
    }

    public static String generatePhone(String local) {
        var faker = new Faker(new Locale(local));
        return faker.phoneNumber().phoneNumber();
    }

    public static class Registration {
        private Registration() {

        }

        public static  UserInfo generateUser(String local) {
            return new UserInfo(generateCity(), generateName(local), generatePhone(local));
        }
    }
@Value
    public static class UserInfo{
        String city;
        String name;
        String phone;
}

}
