import java.nio.file.Path;

public class Constants {
    public static final char[] ALPHABET = {'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з',
            'и', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
            'ъ', 'ы', 'ь', 'э', 'ю', 'я', '.', ',', '«', '»', '"', '-', '\'', ':', ';', '!', '?', ' '};

    public static final char[] REVERSE_ALPHABET = {' ', '?', '!', ';', ':', '\'', '-', '"', '»', '«', ',', '.', 'я', 'ю',
            'э', 'ь', 'ы', 'ъ', 'щ', 'ш', 'ч', 'ц', 'х', 'ф', 'у', 'т', 'с', 'р', 'п', 'о', 'н', 'м', 'л', 'к', 'и',
            'з', 'ж', 'ё', 'е', 'д', 'г', 'в', 'б', 'а'};

    public static final Path output = Path.of("C:\\Users\\user\\Desktop\\Мои Проги\\com.javarush.lipin.cryptoanalyzer\\src\\Result.txt");
}
