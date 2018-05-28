package libProject;

import java.util.ArrayList;
import java.util.List;

public class Controller {

	public static void main(String[] args) {
		BookDB bookDB = new BookDB();	//å DB ��ü����
		
		bookDB.insert(new Book("����� ��ȭ1"));	//å DB�� å ��ü����
		bookDB.insert(new Book("����� ��ȭ2"));
		bookDB.insert(new Book("����� ��ȭ3"));
		List<Book> searchBooks = bookDB.search("����� ��ȭ");	//å DB���� å �˻�
		
		for(Book b:searchBooks) {
			System.out.println(b.title);
		}	//å �˻� ��� ���
		System.out.println("---------------------------------");
		
		MemberDB memberDB = new MemberDB();	//ȸ�� DB ��ü����
		
		memberDB.insert(new Member("���ڹ�"));	//ȸ�� DB ��ü����
		memberDB.insert(new Member("���ڹ�"));
		memberDB.insert(new Member("���ڹ�"));
		List<Member> searchMembers = memberDB.search("�ڹ�");	//ȸ�� DB ��ü����
		
		for(Member m:searchMembers) {
			System.out.println(m.name);
		}	//ȸ�� DB ��ü����
	}

}