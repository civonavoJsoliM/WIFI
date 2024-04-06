package logic;

import data.Author;
import data.Book;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LibraryService {
    public List<Book> getBooksFromCertainAuthor(List<Book> books, Author author) {
        return books.stream()
                .filter(book -> book.author().equals(author))
                .collect(Collectors.toList());
    }

    public List<Author> getAuthorsWhoWroteMoreThenOneBook(List<Book> books) {
        return books.stream()
                .collect(Collectors.groupingBy(Book::author, Collectors.counting()))
                .entrySet().stream()
                .filter(authorLongEntry -> authorLongEntry.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}
