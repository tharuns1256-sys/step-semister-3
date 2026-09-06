class BookStock {

    private int copiesTotal;
    private int copiesAvailable;

    BookStock(int copiesTotal) {

        this.copiesTotal = copiesTotal;
        this.copiesAvailable = copiesTotal;
    }

    void checkOut() {

        if (copiesAvailable > 0) {
            copiesAvailable--;
        }
    }

    void checkIn() {

        if (copiesAvailable < copiesTotal) {
            copiesAvailable++;
        }
    }

    int getCopiesAvailable() {
        return copiesAvailable;
    }
}

public class BookStockDemo {

    public static void main(String[] args) {

        BookStock book = new BookStock(3);

        book.checkOut();
        book.checkOut();
        book.checkOut();
        book.checkOut();

        System.out.println(
            book.getCopiesAvailable()
        );

        book.checkIn();
        book.checkIn();
        book.checkIn();
        book.checkIn();

        System.out.println(
            book.getCopiesAvailable()
        );
    }
}