import java.nio.file.Files;
import java.nio.file.Path;

public class Application {

    public void EncoderStart(String path, String key) {
        int legalKey;
        try {
            legalKey = Integer.parseInt(key);
        } catch (NumberFormatException e) {
            throw new RuntimeException("Введенный ключ не число");
        }

        Path legalPath = Path.of(path);
        boolean pathExist = Files.exists(legalPath);
        if (!pathExist) {
            throw new RuntimeException("Файл не найден!");
        }

        Encoder encoder = new Encoder(path, legalKey);
        encoder.encrypt();
    }

    public void DecryptorStart(String path, String key) {
        int legalKey;
        try {
            legalKey = Integer.parseInt(key);
        } catch (NumberFormatException e) {
            throw new RuntimeException("Введенный ключ не число");
        }

        Path legalPath = Path.of(path);
        boolean pathExist = Files.exists(legalPath);
        if (!pathExist) {
            throw new RuntimeException("Файл не найден!");
        }

        Decryptor decryptor = new Decryptor(path, legalKey);
        decryptor.decipher();
    }

    public void BruteForceStart(String path) {
        Path legalPath = Path.of(path);
        boolean pathExist = Files.exists(legalPath);
        if (!pathExist) {
            throw new RuntimeException("Файл не найден!");
        }

        BruteForce bruteForce = new BruteForce(path);
        bruteForce.hack();
    }
}
