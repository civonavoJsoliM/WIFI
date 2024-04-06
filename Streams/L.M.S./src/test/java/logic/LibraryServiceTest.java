package logic;

import data.Author;
import data.Book;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class LibraryServiceTest {

    @ParameterizedTest
    @MethodSource("initialParameters")
    void getBooksFromCertainAuthor(List<Book> books, Author author, List<Book> expected) {
        LibraryService libraryService = new LibraryService();
        List<Book> booksFromCertainAuthor = libraryService.getBooksFromCertainAuthor(books, author);
        assertEquals(expected, booksFromCertainAuthor);
    }
    static Stream<Arguments> initialParameters() {
        return Stream.of(
                Arguments.of(List.of(new Book(1, "Mindfuck", 1, new Author("Milos", "Serbia", "18.09.1998")),
                        new Book(2, "Hallo", 2, new Author("Stefana", "Serbia", "14.08.2000")),
                        new Book(4, "Ciao", 4, new Author("Stefana", "Serbia", "14.08.2000")),
                        new Book(5, "Adios", 5, new Author("Stefana", "Serbia", "14.08.2000")),
                        new Book(3, "Hola", 3, new Author("Marina", "Serbia", "25.09.1994"))),
                        new Author("Stefana", "Serbia", "14.08.2000"),
                        List.of(new Book(2, "Hallo", 2, new Author("Stefana", "Serbia", "14.08.2000")),
                        new Book(4, "Ciao", 4, new Author("Stefana", "Serbia", "14.08.2000")),
                        new Book(5, "Adios", 5, new Author("Stefana", "Serbia", "14.08.2000")))),
                Arguments.of(List.of(), new Author("Milos", "Serbia", "18.09.1998"), List.of()),
                Arguments.of(List.of(new Book(1, "Mindfuck", 1, new Author("Milos", "Serbia", "18.09.1998")),
                        new Book(2, "Hallo", 2, new Author("Stefana", "Serbia", "14.08.2000")),
                        new Book(4, "Ciao", 4, new Author("Stefana", "Serbia", "14.08.2000")),
                        new Book(5, "Adios", 5, new Author("Stefana", "Serbia", "14.08.2000")),
                        new Book(3, "Hola", 3, new Author("Marina", "Serbia", "25.09.1994"))),
                        new Author("Pera", "Austria", "01.01.1991"),
                        List.of())
        );
    }

    @ParameterizedTest
    @MethodSource("initialBooks")
    void getAuthorsWhoWroteMoreThenOneBook(List<Book> books, List<Author> expected) {
        LibraryService libraryService = new LibraryService();
        List<Author> authorsWithMoreThenOneBook = libraryService.getAuthorsWhoWroteMoreThenOneBook(books);
        assertEquals(expected, authorsWithMoreThenOneBook);
    }
    static Stream<Arguments> initialBooks() {
        Author a1 = new Author("Stefana", "Serbia", "14.08.2000");
        Author a2 = new Author("Milos", "Serbia", "18.09.1998");
        Author a3 = new Author("Marina", "Serbia", "25.09.1994");
        return Stream.of(
                Arguments.of(List.of(
                        new Book(1, "Mindfuck", 1, a2),
                        new Book(2, "Hallo", 2, a3),
                        new Book(4, "Ciao", 4, a3),
                        new Book(5, "Adios", 5, a3),
                        new Book(3, "Hola", 3, a1)),

                        List.of(a3)),
                Arguments.of(List.of(new Book(1, "Mindfuck", 1, a2),
                        new Book(6, "Gracias", 6, a2),
                        new Book(2, "Hallo", 2, a1),
                        new Book(4, "Ciao", 4, a1),
                        new Book(5, "Adios", 5, a1),
                        new Book(3, "Hola", 3, a3),
                        new Book(7, "Bonita", 7, a3)),
                        List.of(a3, a1, a2)),
                Arguments.of(List.of(), List.of()),
                Arguments.of(List.of(
                        new Book(1, "Mindfuck", 1, a2),
                        new Book(2, "Hallo", 2, a3),
                        new Book(4, "Ciao", 4, a1)),
                        List.of())
        );
    }
}