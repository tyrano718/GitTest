package libProject;

import java.util.ArrayList;
import java.util.List;

public class BookDB extends DB{
	List<Book> bookList;
	
	public BookDB() {
		this.bookList = new ArrayList();
	}

	@Override
	List search(String title) {
		List<Book> searchList = new ArrayList<Book>();
		for(Book b:bookList) {
			if(b.title.contains(title)) searchList.add(b);
		}
		return searchList;
	}

	@Override
	void insert(Data data) {
		bookList.add((Book)data);
	}

	@Override
	void delete(Data data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	void update(Data data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	List searchAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	List align() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
