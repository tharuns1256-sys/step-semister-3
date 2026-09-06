class LibraryBook {

    String title;
    String isbn;

    // Constructor with ISBN
    public LibraryBook(String title, String isbn) {
        this.title = title;
        this.isbn = isbn;
    }

    // Constructor without ISBN
    public LibraryBook(String title) {
        this(title, "PENDING");
    }

    void printBook() {
        System.out.println(title + " | " + isbn + " | Catalogued: true");
    }
}

public class LibraryBookDemo {

    public static void main(String[] args) {

        LibraryBook[] books = {
            new LibraryBook("Clean Code", "978-0132350884"),
            new LibraryBook("Untitled Draft"),
            new LibraryBook("1984", "9780451524935"),
            new LibraryBook("Notes")
        };

        for (LibraryBook book : books) {
            book.printBook();
        }
    }
}