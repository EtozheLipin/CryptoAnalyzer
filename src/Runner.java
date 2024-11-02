import java.util.Scanner;

public class Runner {
    public static boolean isAlive = true;
    public static String userInput;
    public static String userOutput;
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
                    userInput = scanner.nextLine();
                    System.out.println("Введите путь вывода");
                    userOutput = scanner.nextLine();
                    System.out.println("Введите ключ");
                    userKey = scanner.nextLine();
                    application.EncoderStart(userInput, userOutput, userKey);
                    isAlive = false;
                    break;
                case "2":
                    System.out.println("Введите путь к файлу");
                    userInput = scanner.nextLine();
                    System.out.println("Введите путь вывода");
                    userOutput = scanner.nextLine();
                    System.out.println("Введите ключ");
                    userKey = scanner.nextLine();
                    application.DecryptorStart(userInput, userOutput, userKey);
                    isAlive = false;
                    break;
                case "3":
                    System.out.println("Введите путь к файлу");
                    userInput = scanner.nextLine();
                    System.out.println("Введите путь вывода");
                    userOutput = scanner.nextLine();
                    application.BruteForceStart(userInput, userOutput);
                    isAlive = false;
                    break;
                case "4":
                    System.out.println("Завершение работы");
                    isAlive = false;
            }
        }
    }
}
