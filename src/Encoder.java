import java.io.*;

public class Encoder {
    String path;
    String output;
    int key;

    public Encoder(String path, String output, int key) {
        this.path = path;
        this.output = output;
        this.key = key;
    }

    public void encrypt() {
        try (BufferedReader br = new BufferedReader(new FileReader(path));
             BufferedWriter bw = new BufferedWriter(new FileWriter(output + "encryptResult.txt"))) {
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
        System.out.println("Шифрование завершено");
    }

    public void reversEncrypt() {
        key = -key;
        try (BufferedReader br = new BufferedReader(new FileReader(path));
             BufferedWriter bw = new BufferedWriter(new FileWriter(output + "encryptResult.txt"))) {
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
                        if (array[i] == Constants.REVERSE_ALPHABET[j]) {
                            if (j + key > length) {
                                int temp = length - j;
                                if (temp > key) {
                                    array[i] = Constants.REVERSE_ALPHABET[(key + temp) - 1];
                                    break;
                                } else {
                                    array[i] = Constants.REVERSE_ALPHABET[(key - temp) - 1];
                                    break;
                                }
                            } else {
                                array[i] = Constants.REVERSE_ALPHABET[(j + key)];
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
        System.out.println("Шифрование завершено");
    }

}
