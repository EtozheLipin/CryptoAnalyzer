import java.util.Scanner;

public class Runner {
    public static boolean isAlive = true;
    public static String userPath;
    public static String userKey;

    public static void main(String[] args) {
        Application application = new Application();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Добро пожаловать в Криптоанализатор!");
        System.out.println("Выберете пункт меню:");
        System.out.println("1 - Шифровка");
        System.out.println("2 - Расшифровка");
        System.out.println("3 - Взлом");
        System.out.println("4 - Выход");

        while (isAlive) {
            switch (scanner.nextLine()) {
                case "1":
                    System.out.println("Введите путь к файлу");
                    userPath = scanner.nextLine();
                    System.out.println("Введите ключ");
                    userKey = scanner.nextLine();
                    application.EncoderStart(userPath, userKey);
                    isAlive = false;
                    break;
                case "2":
                    System.out.println("Введите путь к файлу");
                    userPath = scanner.nextLine();
                    System.out.println("Введите ключ");
                    userKey = scanner.nextLine();
                    application.DecryptorStart(userPath, userKey);
                    isAlive = false;
                    break;
                case "3":
                    System.out.println("Введите путь к файлу");
                    userPath = scanner.nextLine();
                    application.BruteForceStart(userPath);
                    isAlive = false;
                    break;
                case "4":
                    System.out.println("Завершение работы");
                    isAlive = false;
            }
        }
    }
}
