import java.util.Arrays;

public class Encoder {
    String path;
    int key;

    public Encoder(String path, int key) {
        this.path = path;
        this.key = key;
    }

    public void encrypt() {
        String read = "абвгдеёжз";
        char[] array = read.toCharArray();
        int length = Constants.ALPHABET.length - 1;
        if (key % 44 == 0) {
            System.out.println("Ничего не происходит");
            return;
        }
        while (key > Constants.ALPHABET.length) {
            key = key - Constants.ALPHABET.length;
        }

        for (int i = 0; i < read.length(); i++) {
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

        System.out.println(Arrays.toString(array));
    }
}
