package libProject;

import java.util.ArrayList;
import java.util.List;

public class Controller {

	public static void main(String[] args) {
		BookDB bookDB = new BookDB();	//책 DB 객체생성
		
		bookDB.insert(new Book("전쟁과 평화1"));	//책 DB에 책 객체저장
		bookDB.insert(new Book("전쟁과 평화2"));
		bookDB.insert(new Book("전쟁과 평화3"));
		List<Book> searchBooks = bookDB.search("전쟁과 평화");	//책 DB에서 책 검색
		
		for(Book b:searchBooks) {
			System.out.println(b.title);
		}	//책 검색 결과 출력
		System.out.println("---------------------------------");
		
		MemberDB memberDB = new MemberDB();	//회원 DB 객체생성
		
		memberDB.insert(new Member("김자바"));	//회원 DB 객체생성
		memberDB.insert(new Member("이자바"));
		memberDB.insert(new Member("박자바"));
		List<Member> searchMembers = memberDB.search("자바");	//회원 DB 객체생성
		
		for(Member m:searchMembers) {
			System.out.println(m.name);
		}	//회원 DB 객체생성
	}

}