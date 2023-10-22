package seminars.fourth.book;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class BookServiceTest {

    @Test
    void bookServiceFindBiIdTest() {
        BookRepository bookRepository = mock(BookRepository.class);
        BookService bookService = new BookService(bookRepository);
        InMemoryBookRepository imbr = new InMemoryBookRepository();
        Book book = imbr.findById("1");
        bookRepository.findById("1");
        when(bookRepository.findById("1")).thenReturn(book);
//        System.out.println(bookRepository.findById("1"));
        verify(bookRepository).findById("1");
        assertThat(bookRepository.findById("1")).isEqualTo(bookService.findBookById("1"));
    }

    @Test
    void bookServiceFindAllTest() {
        BookRepository bookRepository = mock(BookRepository.class);
        BookService bookService = new BookService(bookRepository);
        InMemoryBookRepository imbr = new InMemoryBookRepository();
        List<Book> list = imbr.findAll();
        bookRepository.findAll();
        when(bookRepository.findAll()).thenReturn(list);

        verify(bookRepository).findAll();
        assertThat(bookRepository.findAll()).isEqualTo(bookService.findAllBooks());
    }
}