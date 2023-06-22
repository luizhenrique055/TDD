import java.util.ArrayList;
import java.util.List;

public class CamelCase {
    public static List<String> converterCamelCase(String original) {
        List<String> words = new ArrayList<>();

        if (original.isEmpty()) {
            return words;
        }

        if (Character.isDigit(original.charAt(0))) {
            throw new IllegalArgumentException("Inválido -> não deve começar com números");
        }

        if (!original.matches("[a-zA-Z0-9]+")) {
            throw new IllegalArgumentException("Inválido -> caracteres especiais não são permitidos, somente letras e números");
        }

        StringBuilder currentWord = new StringBuilder();
        currentWord.append(original.charAt(0));

        for (int i = 1; i < original.length(); i++) {
            char currentChar = original.charAt(i);

            if (Character.isUpperCase(currentChar)) {
                words.add(currentWord.toString());
                currentWord = new StringBuilder();
            }

            currentWord.append(currentChar);
        }

        words.add(currentWord.toString());
        return words;
    }
}