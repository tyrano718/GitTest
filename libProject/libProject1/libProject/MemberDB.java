package libProject;

import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MemberDB extends DB{
	List<Member> memberList;
	Scanner scanner = new Scanner(System.in);
	String id = "";
	String password = "";
	String name = "";
	String ssn = "";
	String tel = "";
	public MemberDB() {
		memberList = new ArrayList<>();
	}

	@Override
	List search(String str) {
		List<Member> searchList = new ArrayList<Member>();
		for(Member m:memberList) {
			if(m.getName().contains(str)) searchList.add(m);
		}
		return searchList;
	}

	@Override
	void insert(Data data) {
		memberList.add((Member)data);
	}

	@Override
	void delete(Data data) {
		memberList.remove((Member)data);
	}

	@Override
	void update(Data data) {
		
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
Data input() {
	System.out.println("아이디를 입력해주세요");
	id = scanner.nextLine();
	System.out.println("비밀번호를 입력해주세요");
	password = scanner.nextLine();
	System.out.println();
	String passright = scanner.nextLine();
	Member m = new Member(id, password, name, ssn, tel);
	return m;
}
}
