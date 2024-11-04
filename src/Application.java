import java.nio.file.Files;
import java.nio.file.Path;

public class Application {

    public void EncoderStart(String path, String output, String key) {
        int legalKey;
        try {
            legalKey = Integer.parseInt(key);
        } catch (NumberFormatException e) {
            throw new RuntimeException("Неверный ключ");
        }

        Path legalPath = Path.of(path);
        boolean pathExist = Files.exists(legalPath);
        if (!pathExist || Files.isDirectory(legalPath)) {
            throw new RuntimeException("Файл не найден!");
        }

        if (legalKey == 0) {
            System.out.println("Ключ не может быть равным 0");
            return;
        }

        Encoder encoder = new Encoder(path, output, legalKey);
        if (legalKey > 0) {
            encoder.encrypt();
        } else {
            encoder.reversEncrypt();
        }
    }

    public void DecryptorStart(String path, String output, String key) {
        int legalKey;
        try {
            legalKey = Integer.parseInt(key);
        } catch (NumberFormatException e) {
            throw new RuntimeException("Неверный ключ");
        }

        Path legalPath = Path.of(path);
        boolean pathExist = Files.exists(legalPath);
        if (!pathExist || Files.isDirectory(legalPath)) {
            throw new RuntimeException("Файл не найден!");
        }

        if (legalKey == 0) {
            System.out.println("Ключ не может быть равным 0");
            return;
        }

        Decryptor decryptor = new Decryptor(path, output, legalKey);
        if (legalKey > 0) {
            decryptor.decipher();
        } else {
            decryptor.reverseDecipher();
        }
    }

    public void BruteForceStart(String path, String output) {
        Path legalPath = Path.of(path);
        boolean pathExist = Files.exists(legalPath);
        if (!pathExist || Files.isDirectory(legalPath)) {
            throw new RuntimeException("Файл не найден!");
        }
        if (!Files.isDirectory(Path.of(output))) {
            throw new RuntimeException("Файл вывода не директория");
        }

        BruteForce bruteForce = new BruteForce(path, output);
        bruteForce.hack();
    }
}
