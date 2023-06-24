package library;

public class Book {

    /**
     * Klasa reprezentująca pojedynczą książkę w bibliotece.
     */
    public class Book {
        private String title;
        private String author;
        private int year;
        private String isbn;
        private boolean available;

        /**
         * Konstruktor tworzący nową książkę.
         *
         * @param title     tytuł książki
         * @param author    autor książki
         * @param year      rok wydania książki
         * @param isbn      numer ISBN książki
         * @param available dostępność książki (true - dostępna, false - wypożyczona)
         */
        public Book(String title, String author, int year, String isbn, boolean available) {
            this.title = title;
            this.author = author;
            this.year = year;
            this.isbn = isbn;
            this.available = available;
        }

        /**
         * Zwraca tytuł książki.
         *
         * @return tytuł książki
         */
        public String getTitle() {
            return title;
        }

        /**
         * Zwraca autora książki.
         *
         * @return autor książki
         */
        public String getAuthor() {
            return author;
        }

        /**
         * Zwraca rok wydania książki.
         *
         * @return rok wydania książki
         */
        public int getYear() {
            return year;
        }

        /**
         * Zwraca numer ISBN książki.
         *
         * @return numer ISBN książki
         */
        public String getISBN() {
            return isbn;
        }

        /**
         * Sprawdza dostępność książki.
         *
         * @return true, jeśli książka jest dostępna; false, jeśli książka jest
         *         wypożyczona
         */
        public boolean isAvailable() {
            return available;
        }

        /**
         * Ustawia dostępność książki.
         *
         * @param available dostępność książki (true - dostępna, false - wypożyczona)
         */
        public void setAvailable(boolean available) {
            this.available = available;
        }
    }

}
