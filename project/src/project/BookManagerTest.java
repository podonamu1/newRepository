package project;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BookManagerTest {
	
	private BookManager bookManager;
	
	@BeforeEach
	void setUp() throws Exception {
		bookManager = new BookManager();
	}

	@Test
	void testAddBook() {
		System.out.println("Book 입력 테스트 시작");
		bookManager.addBook("1", "자바 기초", "Jane", 2021);
		Book book = bookManager.books.get("1");
		assertTrue(book.getId().equals("1"));
		assertTrue(book.getName().equals("자바 기초"));
		assertTrue(book.getAuthor().equals("Jane"));
		assertEquals(book.getYear(), 2021);
		System.out.println("Book 입력 테스트 완료 { id = '" + book.getId() + "', name = '"
			+ book.getName() + "', author = '" + book.getAuthor() + "', year = " 
			+ book.getYear() + " }"
		);
		
		System.out.println("Book 중복 입력 테스트 시작 { id = '1' name = '파이썬 기초', author = 'Song', year = 2020 }");
		assertThrows(IllegalArgumentException.class, () -> bookManager.addBook("1", "파이썬 기초", "Song", 2020), "같은 ID 사용 불가");
		System.out.println("같은 ID 입력 불가 id = '1'");
		System.out.println("Book 중복 입력 테스트 완료");
	}

	@Test
	void testSearchBook() {
		System.out.println("Book 검색 테스트 시작");
		bookManager.addBook("1", "자바 기초", "Jane", 2021);
		Book book = bookManager.searchBook("1");
		assertTrue(book.getId().equals("1"));
		assertTrue(book.getName().equals("자바 기초"));
		assertTrue(book.getAuthor().equals("Jane"));
		assertEquals(book.getYear(), 2021);
		System.out.println("Book 검색 테스트 완료 { id = '" + book.getId() + "', name = '"
			+ book.getName() + "', author = '" + book.getAuthor() + "', year = " 
			+ book.getYear() + " }"
		);
		
		System.out.println("Book 없는 것 검색 테스트 시작 id = '2'");
		assertThrows(IllegalArgumentException.class, () -> bookManager.searchBook("2"), "없는 ID 검색 불가");
		System.out.println("id = '2' 없는 것 검색 불가");
		System.out.println("Book 없는 것 검색 테스트 완료");
	}

	@Test
	void testRemoveBook() {
		System.out.println("Book 삭제 테스트 시작");
		bookManager.addBook("1", "자바 기초", "Jane", 2021);
		Book book = bookManager.books.get("1");
		assertTrue(book.getId().equals("1"));
		assertTrue(book.getName().equals("자바 기초"));
		assertTrue(book.getAuthor().equals("Jane"));
		assertEquals(book.getYear(), 2021);
		System.out.println("Book 입력 완료 { id = '" + book.getId() + "', name = '"
			+ book.getName() + "', author = '" + book.getAuthor() + "', year = " 
			+ book.getYear() + " }"
		);
		
		bookManager.addBook("2", "DB 기초", "Yoon", 2022);
		book = bookManager.books.get("2");
		assertTrue(book.getId().equals("2"));
		assertTrue(book.getName().equals("DB 기초"));
		assertTrue(book.getAuthor().equals("Yoon"));
		assertEquals(book.getYear(), 2022);
		System.out.println("Book 입력 완료 { id = '" + book.getId() + "', name = '"
			+ book.getName() + "', author = '" + book.getAuthor() + "', year = " 
			+ book.getYear() + " }"
		);
		
		book = bookManager.searchBook("1");
		assertTrue(book.getId().equals("1"));
		assertTrue(book.getName().equals("자바 기초"));
		assertTrue(book.getAuthor().equals("Jane"));
		assertEquals(book.getYear(), 2021);
		System.out.println("Book 검색 완료 { id = '" + book.getId() + "', name = '"
			+ book.getName() + "', author = '" + book.getAuthor() + "', year = " 
			+ book.getYear() + " }"
		);
		
		book = bookManager.searchBook("2");
		assertTrue(book.getId().equals("2"));
		assertTrue(book.getName().equals("DB 기초"));
		assertTrue(book.getAuthor().equals("Yoon"));
		assertEquals(book.getYear(), 2022);
		System.out.println("Book 검색 완료 { id = '" + book.getId() + "', name = '"
			+ book.getName() + "', author = '" + book.getAuthor() + "', year = " 
			+ book.getYear() + " }"
		);
		
		System.out.println("Book 삭제 시작 id = '2'");
		bookManager.removeBook("2");
		System.out.println("Book 삭제 완료");
		
		System.out.println("Book 검색 시작 id = '1'");
		book = bookManager.searchBook("1");
		assertTrue(book.getId().equals("1"));
		assertTrue(book.getName().equals("자바 기초"));
		assertTrue(book.getAuthor().equals("Jane"));
		assertEquals(book.getYear(), 2021);
		System.out.println("Book 검색 완료 { id = '" + book.getId() + "', name = '"
			+ book.getName() + "', author = '" + book.getAuthor() + "', year = " 
			+ book.getYear() + " }"
		);
		
		System.out.println("Book 검색 시작 id = '2'");
		assertThrows(IllegalArgumentException.class, () -> bookManager.searchBook("2"), "없는 ID 검색 불가");
		System.out.println("Book 검색 불가");
		
		System.out.println("Book 삭제 테스트 완료");
	}

}
