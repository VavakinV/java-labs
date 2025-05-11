import users.*;

public class Main {
    public static void main(String[] args) {
        Guest[] guests = new Guest[10];
        int count = 0;

        Guest[] allGuests = {
                new Admin("admin1", "pass123"),
                new Admin("admin2", "pass456"),
                new User("user1", "Иванов", "Менеджер"),
                new User("user2", "Петров", "Аналитик"),
                new Admin("admin1", "pass789"), // повтор логина
                new User("user3", "Сидоров", "Разработчик"),
                new User("user1", "Козлов", "Тестировщик"), // повтор логина
                new Admin("admin3", "pass000"),
                new User("user4", "Смирнов", "Дизайнер"),
                new Admin("admin4", "pass111")
        };

        for (Guest guest : allGuests) {
            boolean isUnique = true;
            for (int i = 0; i < count; i++) {
                if (guest.equals(guests[i])) {
                    System.out.println("Обнаружен повторяющийся логин: " + guest.getLogin());
                    isUnique = false;
                    break;
                }
            }
            if (isUnique) {
                guests[count++] = guest;
            }
        }

        System.out.println("\nУникальные гости в массиве:");
        for (int i = 0; i < count; i++) {
            System.out.println(guests[i]);
        }
    }
}