package libProject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookDB extends DB{
	List<Book> bookList;
	
	//검색, 전체검색, 정렬 미완성
	
	public BookDB() {
		this.bookList = new ArrayList();
	}

	//검색
	@Override
	List search(String title) {
		List<Book> searchList = new ArrayList<Book>();
		for(Book b:bookList) {
			if(b.title.contains(title)) searchList.add(b);
		}
		return searchList;
	}

	//도서 자료 입력받고 가공, 데이터반환
	Data input() {
		//변수 선언
		Scanner scan = new Scanner(System.in);
		String title="";
		String author="";
		int subject=0;
		String publisher="";
		//입력시작
		System.out.print("제목 :");
		title = scan.nextLine();
		System.out.println();
		System.out.print("저자 :");
		author = scan.nextLine();
		System.out.println();
		//철학 종교 사회학 자연과학 기술과학 예술 언어 문학 역사
		System.out.println("분야 리스트");
		System.out.println("1.철학 2.종교 3.사회학 4.자연과학");
		System.out.println("5.기술과학 6.예술 7.언어 8.문학 9.역사");
		System.out.print("분야 :");
		subject = scan.nextInt();
		System.out.println();
		System.out.print("출판사 :");
		publisher = scan.nextLine();
		System.out.println();
		Book b = new Book(title,author,subject,publisher); 
		return b;
	}
	
	//리스트 삽입
	@Override
	void insert(Data data) {
		bookList.add((Book)data);
	}

	//삭제
	@Override
	void delete(Data data) {
		Book b = (Book)data;//get,set이용을 위한 형변환		
		bookList.remove(b);
	}

	@Override
	void update(Data data) {
		Book b = (Book)data;//get,set이용을 위한 형변환
		Scanner scan = new Scanner(System.in);
		//수정시작
		System.out.printf("현재 입력된 제목 : %s%n",b.getTitle());
		System.out.print("수정하실 제목 :");
		b.setTitle(scan.nextLine());
		System.out.println();
		
		System.out.printf("현재 입력된 저자 : %s%n",b.getAuthor());
		System.out.print("수정하실 저자 :");
		b.setAuthor(scan.nextLine());
		System.out.println();
		//철학 종교 사회학 자연과학 기술과학 예술 언어 문학 역사
		System.out.println("분야 리스트");
		System.out.println("1.철학 2.종교 3.사회학 4.자연과학");
		System.out.println("5.기술과학 6.예술 7.언어 8.문학 9.역사");
		System.out.printf("현재 입력된 분야 : %s%n",b.change_subject(b.getSubject()));
		System.out.print("수정하실 분야 :");
		b.setSubject(scan.nextInt());
		System.out.println();
		System.out.printf("현재 입력된 출판사 : %s%n",b.getPublisher());
		System.out.print("수정하실 출판사 :");
		b.setPublisher(scan.nextLine());
		System.out.println();
	}

	//전체검색
	@Override
	List searchAll() {
		// TODO Auto-generated method stub
		for(int i=0;i<bookList.size();i++) {
			System.out.println((Book)bookList.get(i));
		}
		return null;
	}

	//정렬
	@Override
	List align() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
