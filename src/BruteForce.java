import java.io.*;

public class BruteForce {
    String path;

    public BruteForce(String path) {
        this.path = path;
    }

    public void hack() {
        int key = 1;
        while (key < 45) {

            try (BufferedReader br = new BufferedReader(new FileReader(path));
                 BufferedWriter bw = new BufferedWriter(new FileWriter(
                         "C:\\Users\\user\\Desktop\\Мои Проги\\com.javarush.lipin.cryptoanalyzer\\src\\HackOutput\\output" + key + ".txt"))) {
                char[] array;
                int length = Constants.ALPHABET.length - 1;
                String line;

                while ((line = br.readLine()) != null) {
                    line = line.toLowerCase();
                    array = line.toCharArray();

                    if (key % 45 == 0) {
                        System.out.println("Ключ не может быть кратным 45");
                        return;
                    }
                    while (key > Constants.ALPHABET.length) {
                        key = key - Constants.ALPHABET.length;
                    }

                    for (int i = 0; i < line.length(); i++) {
                        for (int j = 0; j < Constants.ALPHABET.length; j++) {
                            if (array[i] == Constants.ALPHABET[j]) {
                                if (j + key > length) {
                                    int temp = length - j;
                                    if (temp > key) {
                                        array[i] = Constants.ALPHABET[(key + temp) - 1];
                                        break;
                                    } else {
                                        array[i] = Constants.ALPHABET[(key - temp) - 1];
                                        break;
                                    }
                                } else {
                                    array[i] = Constants.ALPHABET[(j + key)];
                                    break;
                                }
                            }
                        }
                    }
                    bw.write(array);
                    bw.write("\n");
                }
            } catch (IOException e) {
                System.out.println("Во время шифрования что-то пошло не так!");
                throw new RuntimeException(e);
            }
            key++;
        }
        System.out.println("Взлом завершон");
    }

}
