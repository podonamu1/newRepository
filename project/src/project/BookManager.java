package project;

import java.util.*;

public class BookManager {
	public Map<String, Book> books;
	
	public BookManager() {
		books = new HashMap<>();
	}
	
	public void addBook(String id, String name, String author, int price) {
		if (books.containsKey(id)) {
			throw new IllegalArgumentException("Books already contain id " + id);
		}
		books.put(id, new Book(id, name, author, price));
	}
	
	public Book searchBook(String id) {
		if (!books.containsKey(id)) {
			throw new IllegalArgumentException("Books don't contain id " + id);
		}
		return books.get(id);
	}
	
	public void removeBook(String id) {
		if (!books.containsKey(id)) {
			throw new IllegalArgumentException("Books don't contain id " + id);
		}
		books.remove(id);
	}
}
