package seminars.fourth.book;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class BookServiceTest {

    InMemoryBookRepository imbr;
    Book bookTest;

    @BeforeEach
    void setup() {
        imbr = new InMemoryBookRepository();
        bookTest = new Book("3", "Book3", "Author3");
    }

    @Test
    void bookServiceFindBiIdTest() {
        BookRepository bookRepository = mock(BookRepository.class);
        BookService bookService = new BookService(bookRepository);
        Book book = bookService.findBookById("1");
        when(bookRepository.findById("1")).thenReturn(book);

        verify(bookRepository).findById("1");
        assertThat(bookRepository.findById("1")).isEqualTo(book);
    }

    @Test
    void bookServiceFindAllTest() {
        BookRepository bookRepository = mock(BookRepository.class);
        BookService bookService = new BookService(bookRepository);
        List<Book> list = bookService.findAllBooks();
        when(bookRepository.findAll()).thenReturn(list);

        verify(bookRepository).findAll();
        assertThat(bookRepository.findAll()).isEqualTo(list);
    }

    @Test
    void bookServiceFindBiIdRealDataTest() {
        BookRepository bookRepository = mock(BookRepository.class);
        BookService bookService = new BookService(bookRepository);
        Book book = imbr.findById("1");
        bookRepository.findById("1");
        when(bookRepository.findById("1")).thenReturn(book);

        verify(bookRepository).findById("1");
        assertThat(bookRepository.findById("1")).isEqualTo(bookService.findBookById("1"));
    }

    @Test
    void bookServiceFindAllRealDataTest() {
        BookRepository bookRepository = mock(BookRepository.class);
        BookService bookService = new BookService(bookRepository);
        List<Book> list = imbr.findAll();
        bookRepository.findAll();
        when(bookRepository.findAll()).thenReturn(list);

        verify(bookRepository).findAll();
        assertThat(bookRepository.findAll()).isEqualTo(bookService.findAllBooks());
    }

    @Test
    void bookGetIdTest() {
        assertThat(bookTest.getId()).isEqualTo("3");
    }

    @Test
    void bookGetTitleTest() {
        assertThat(bookTest.getTitle()).isEqualTo("Book3");
    }

    @Test
    void bookGetAuthorTest() {
        assertThat(bookTest.getAuthor()).isEqualTo("Author3");
    }

    @Test
    void bookSetIdTest() {
        bookTest.setId("5");
        assertThat(bookTest.getId()).isEqualTo("5");
    }

    @Test
    void bookSetTitleTest() {
        bookTest.setTitle("Title5");
        assertThat(bookTest.getTitle()).isEqualTo("Title5");
    }

    @Test
    void bookSetAuthorTest() {
        bookTest.setAuthor("Author5");
        assertThat(bookTest.getAuthor()).isEqualTo("Author5");
    }
}