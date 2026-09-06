import java.util.Scanner;

public class LibraryISBNValidator {

    // Normalize the code
    static String normalizeCode(String raw) {

        String code = raw.trim();

        if (code.length() < 3) {
            return code;
        }

        String publisherCode = code.substring(0, 3).toUpperCase();
        String remaining = code.substring(3);

        return publisherCode + remaining;
    }

    // Validate and format the code
    static String validateAndFormat(String code) {

        // Check length
        if (code.length() != 13) {
            return "Invalid: wrong length";
        }

        // Check first 3 characters are letters
        for (int i = 0; i < 3; i++) {

            if (!Character.isLetter(code.charAt(i))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }

        // Check remaining 10 characters are digits
        for (int i = 3; i < 13; i++) {

            if (!Character.isDigit(code.charAt(i))) {
                return "Invalid: body must contain only digits";
            }
        }

        String publisherCode = code.substring(0, 3);
        String year = code.substring(3, 7);
        String catalog = code.substring(7, 13);

        StringBuilder result = new StringBuilder();

        result.append("[")
              .append(publisherCode)
              .append("] YEAR: ")
              .append(year)
              .append(" | CATALOG: ")
              .append(catalog);

        return result.toString();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter ISBN code: ");
        String rawCode = sc.nextLine();

        String normalizedCode = normalizeCode(rawCode);

        System.out.println(validateAndFormat(normalizedCode));

        sc.close();
    }
}