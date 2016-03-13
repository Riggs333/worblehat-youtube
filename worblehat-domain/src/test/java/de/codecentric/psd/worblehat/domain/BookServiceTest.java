package de.codecentric.psd.worblehat.domain;

import de.codecentric.psd.worblehat.domain.*;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.*;

public class BookServiceTest {

	private BorrowingRepository borrowingRepository;

	private BookRepository bookRepository;

	private BookService bookService;

	private Book testBook;


	private static final String BORROWER_EMAIL = "someone@codecentric.de";

	@Before
	public void setup() throws Exception {
		borrowingRepository = mock(BorrowingRepository.class);
		bookRepository = mock(BookRepository.class);
		bookService = new StandardBookService(borrowingRepository, bookRepository);
	}

	@Test
	public void shouldReturnAllBooksOfOnePerson() {
		Book testBook = new Book("title", "author", "edition", "isbn", 2016);
		Borrowing borrowing = new Borrowing(testBook, BORROWER_EMAIL, new DateTime());
		List<Borrowing> result = Collections.singletonList(borrowing);
		when(borrowingRepository.findBorrowingsByBorrower(BORROWER_EMAIL))
		.thenReturn(result);
		bookService.returnAllBooksByBorrower(BORROWER_EMAIL);
		verify(borrowingRepository).delete(borrowing);
	}

}