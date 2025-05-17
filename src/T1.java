import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UserManagerApp {
    private Map<String, String> users = new HashMap<>();
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        new UserManagerApp().run();
    }

    private void run() {
        while (true) {
            System.out.println("\nМеню:");
            System.out.println("1. Додати нового користувача");
            System.out.println("2. Видалити існуючого користувача");
            System.out.println("3. Перевірити чи існує користувача");
            System.out.println("4. Змінити логін існуючого користувача");
            System.out.println("5. Змінити пароль існуючого користувача");
            System.out.println("6. Вихід");
            System.out.print("Виберіть опцію: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1": addUser(); break;
                case "2": removeUser(); break;
                case "3": checkUser(); break;
                case "4": changeLogin(); break;
                case "5": changePassword(); break;
                case "6": System.out.println("Вихід..."); return;
                default: System.out.println("Невірний вибір.");
            }
        }
    }

    private void addUser() {
        System.out.print("Введіть логін: ");
        String login = scanner.nextLine();
        if (users.containsKey(login)) {
            System.out.println("Користувач з таким логіном вже існує.");
            return;
        }
        System.out.print("Введіть пароль: ");
        String pass = scanner.nextLine();
        users.put(login, pass);
        System.out.println("Користувача додано.");
    }

    private void removeUser() {
        System.out.print("Введіть логін для видалення: ");
        String login = scanner.nextLine();
        if (users.remove(login) != null) {
            System.out.println("Користувача видалено.");
        } else {
            System.out.println("Користувача не знайдено.");
        }
    }

    private void checkUser() {
        System.out.print("Введіть логін для перевірки: ");
        String login = scanner.nextLine();
        if (users.containsKey(login)) {
            System.out.println("Користувач існує.");
        } else {
            System.out.println("Користувача не знайдено.");
        }
    }

    private void changeLogin() {
        System.out.print("Введіть старий логін: ");
        String oldLogin = scanner.nextLine();
        if (!users.containsKey(oldLogin)) {
            System.out.println("Користувача не знайдено.");
            return;
        }
        System.out.print("Введіть новий логін: ");
        String newLogin = scanner.nextLine();
        if (users.containsKey(newLogin)) {
            System.out.println("Такий логін вже зайнятий.");
            return;
        }
        String pass = users.remove(oldLogin);
        users.put(newLogin, pass);
        System.out.println("Логін змінено.");
    }

    private void changePassword() {
        System.out.print("Введіть логін: ");
        String login = scanner.nextLine();
        if (!users.containsKey(login)) {
            System.out.println("Користувача не знайдено.");
            return;
        }
        System.out.print("Введіть новий пароль: ");
        String newPass = scanner.nextLine();
        users.put(login, newPass);
        System.out.println("Пароль змінено.");
    }
}
