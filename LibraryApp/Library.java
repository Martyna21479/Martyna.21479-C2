package LibraryApp;



import java.util.ArrayList;
import java.util.List;

/**
 * Klasa reprezentująca bibliotekę.
 */
public class Library {
    private List<Book> books;

    /**
     * Konstruktor tworzący nową bibliotekę.
     */
    public Library() {
        books = new ArrayList<>();
    }

    /**
     * Dodaje książkę do kolekcji biblioteki.
     *
     * @param book książka do dodania
     */
    public void addBook(Book book) {
        books.add(book);
    }

    /**
     * Usuwa książkę z kolekcji biblioteki.
     *
     * @param book książka do usunięcia
     */
    public void removeBook(Book book) {
        books.remove(book);
    }

    /**
     * Wyszukuje książki po tytule.
     *
     * @param title tytuł książki
     * @return lista znalezionych książek o podanym tytule
     */
    public List<Book> searchBooksByTitle(String title) {
        List<Book> foundBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }

    /**
     * Wyszukuje książki po autorze.
     *
     * @param author autor książki
     * @return lista znalezionych książek napisanych przez podanego autora
     */
    public List<Book> searchBooksByAuthor(String author) {
        List<Book> foundBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }

    /**
     * Wypożycza książkę o podanym numerze ISBN.
     *
     * @param isbn numer ISBN książki
     * @return true, jeśli wypożyczenie powiodło się; false, jeśli książka jest niedostępna lub nie istnieje
     */
    public boolean borrowBook(String isbn) {
        for (Book book : books) {
            if (book.getISBN().equals(isbn) && book.isAvailable()) {
                book.setAvailable(false);
                return true;
            }
        }
        return false;
    }

    /**
     * Zwraca wypożyczoną książkę o podanym numerze ISBN.
     *
     * @param isbn numer ISBN książki
     * @return true, jeśli zwracanie powiodło się; false, jeśli książka nie jest wypożyczona lub nie istnieje
     */
    public boolean returnBook(String isbn) {
        for (Book book : books) {
            if (book.getISBN().equals(isbn) && !book.isAvailable()) {
                book.setAvailable(true);
                return true;
            }
        }
        return false;
    }
}

    
}
