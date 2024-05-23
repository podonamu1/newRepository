package project;

public class Book {
	private String id;
	private String name;
	private String author;
	private int year;
	
	public Book(
			String _id,
			String _name,
			String _author,
			int _year
	) {
		id = _id;
		name = _name;
		author = _author;
		year = _year;
	}
	
	public String getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public int getYear() {
		return year;
	}
	
}
