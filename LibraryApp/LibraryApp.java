package LibraryApp;


import library.Book;
import library.Library;

import java.util.List;
import java.util.Scanner;

/**
 * Klasa reprezentująca interfejs użytkownika aplikacji zarządzania księgozbiorem.
 */
public class LibraryApp {
    private static Library library;
    private static Scanner scanner;

    /**
     * Metoda main - punkt wejścia do aplikacji.
     *
     * @param args argumenty wiersza poleceń
     */
    public static void main(String[] args) {
        library = new Library();
        scanner = new Scanner(System.in);

        boolean running = true;
        while (running) {
            printMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Pobierz znak nowej linii po wczytaniu liczby

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    removeBook();
                    break;
                case 3:
                    searchBooksByTitle();
                    break;
                case 4:
                    searchBooksByAuthor();
                    break;
                case 5:
                    borrowBook();
                    break;
                case 6:
                    returnBook();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Nieprawidłowy wybór. Wybierz numer opcji z menu.");
            }
        }

        scanner.close();
    }

    /**
     * Wyświetla menu główne aplikacji.
     */
    private static void printMenu() {
        System.out.println("\n=== MENU ===");
        System.out.println("1. Dodaj książkę");
        System.out.println("2. Usuń książkę");
        System.out.println("3. Wyszukaj książki po tytule");
        System.out.println("4. Wyszukaj książki po autorze");
        System.out.println("5. Wypożycz książkę");
        System.out.println("6. Zwróć książkę");
        System.out.println("0. Wyjdź z programu");
        System.out.print("Wybierz opcję: ");
    }

    /**
     * Dodaje książkę do biblioteki.
     */
    private static void addBook() {
        System.out.println("\n=== DODAWANIE KSIĄŻKI ===");
        System.out.print("Podaj tytuł książki: ");
        String title = scanner.nextLine();
        System.out.print("Podaj autora książki: ");
        String author = scanner.nextLine();
        System.out.print("Podaj rok wydania książki: ");
        int year = scanner.nextInt();
        scanner.nextLine(); // Pobierz znak nowej linii po wczytaniu liczby
        System.out.print("Podaj numer ISBN książki: ");
        String isbn = scanner.nextLine();

        Book book = new Book(title, author, year, isbn, true);
        library.addBook(book);
        System.out.println("Książka została dodana do biblioteki.");
    }

    /**
     * Usuwa książkę z biblioteki.
     */
    private static void removeBook() {
        System.out.println("\n=== USUWANIE KSIĄŻKI ===");
        System.out.print("Podaj numer ISBN książki do usunięcia: ");
        String isbn = scanner.nextLine();

        List<Book> foundBooks = library.searchBooksByISBN(isbn);
        if (!foundBooks.isEmpty()) {
            Book bookToRemove = foundBooks.get(0);
            library.removeBook(bookToRemove);
            System.out.println("Książka została usunięta z biblioteki.");
        } else {
            System.out.println("Książka o podanym numerze ISBN nie została znaleziona.");
        }
    }

    /**
     * Wyszukuje książki po tytule.
     */
    private static void searchBooksByTitle() {
        System.out.println("\n=== WYSZUKIWANIE KSIĄŻEK PO TYTULE ===");
        System.out.print("Podaj tytuł książki: ");
        String title = scanner.nextLine();

        List<Book> foundBooks = library.searchBooksByTitle(title);
        if (!foundBooks.isEmpty()) {
            System.out.println("Znalezione książki:");
            for (Book book : foundBooks) {
                System.out.println(book.getTitle() + " - " + book.getAuthor());
            }
        } else {
            System.out.println("Nie znaleziono książek o podanym tytule.");
        }
    }

    /**
     * Wyszukuje książki po autorze.
     */
    private static void searchBooksByAuthor() {
        System.out.println("\n=== WYSZUKIWANIE KSIĄŻEK PO AUTORZE ===");
        System.out.print("Podaj autora książki: ");
        String author = scanner.nextLine();

        List<Book> foundBooks = library.searchBooksByAuthor(author);
        if (!foundBooks.isEmpty()) {
            System.out.println("Znalezione książki:");
            for (Book book : foundBooks) {
                System.out.println(book.getTitle() + " - " + book.getAuthor());
            }
        } else {
            System.out.println("Nie znaleziono książek napisanych przez podanego autora.");
        }
    }

    /**
     * Wypożycza książkę.
     */
    private static void borrowBook() {
        System.out.println("\n=== WYPOŻYCZANIE KSIĄŻKI ===");
        System.out.print("Podaj numer ISBN książki do wypożyczenia: ");
        String isbn = scanner.nextLine();

        if (library.borrowBook(isbn)) {
            System.out.println("Książka została wypożyczona.");
        } else {
            System.out.println("Nie udało się wypożyczyć książki. Sprawdź dostępność lub numer ISBN.");
        }
    }

    /**
     * Zwraca wypożyczoną książkę.
     */
    private static void returnBook() {
        System.out.println("\n=== ZWRACANIE KSIĄŻKI ===");
        System.out.print("Podaj numer ISBN książki do zwrotu: ");
        String isbn = scanner.nextLine();

        if (library.returnBook(isbn)) {
            System.out.println("Książka została zwrócona.");
        } else {
            System.out.println("Nie udało się zwrócić książki. Sprawdź numer ISBN lub czy książka jest wypożyczona.");
        }
    }
}

    
}
