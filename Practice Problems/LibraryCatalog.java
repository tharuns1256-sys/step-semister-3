class Book {
    String isbn;
    String title;

    Book(String isbn, String title) {
        this.isbn = isbn;
        this.title = title;
    }
}

public class LibraryCatalog {

    public static String findBook(Book[] catalog, String targetIsbn) {
        int low = 0;
        int high = catalog.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            int result = catalog[mid].isbn.compareTo(targetIsbn);

            if (result == 0) {
                return catalog[mid].title;
            } else if (result < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return "Not Found";
    }

    public static void main(String[] args) {

        Book[] catalog = {
            new Book("0001112223", "Java Basics"),
            new Book("0002223334", "Data Structures"),
            new Book("0003334445", "Classic Mythology"),
            new Book("0004445556", "Algorithms")
        };

        System.out.println(findBook(catalog, "0003334445"));
        System.out.println(findBook(catalog, "0009998887"));
    }
}