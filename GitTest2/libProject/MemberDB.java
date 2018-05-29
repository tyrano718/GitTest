package com.javalec.ex0529;

import java.util.*;

public class MemberDB extends DB {
	List<Member> memberList;
	// 변수 선언
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
	List<Member> search(String str) { // 회원 전체검색
		List<Member> searchList = new ArrayList<Member>();
		for (Member m : memberList) {
			if (m.getName().contains(str))
				searchList.add(m);
		}
		return searchList;
	}

	Data input() { // 회원가입 메서드
		System.out.println("아이디를 입력해주세요"); // 아이디 입력
		id = scanner.nextLine();
		while (true) { // 비밀번호 확인 과정을 위한 반복
			System.out.println("비밀번호를 입력해주세요"); // 비밀번호 입력
			password = scanner.nextLine();
			System.out.println("비밀번호를 한번 더 입력해주세요");
			String passright = scanner.nextLine();
			if (passright.equals(password)) {
				System.out.println("비밀번호를 확인하였습니다.");
				break; // 비밀번호 확인이 맞으면 다음 단계로
			} else {
				System.out.println("비밀번호가 틀렸습니다. 다시 입력해주세요.");
				continue; // 비밀번호 확인이 틀리면 다시 비밀번호 입력 단계로
			}
		}
		System.out.println("이름을 입력해주세요.");
		name = scanner.nextLine();
		System.out.println("생년월일을 입력해주세요.");
		ssn = scanner.nextLine();
		System.out.println("전화번호를 입력해주세요.");
		tel = scanner.nextLine();

		Member m = new Member(id, password, name, ssn, tel);
		return m;
	}

	@Override
	void insert(Data data) {
		memberList.add((Member) data);
	}

	@Override
	void delete(Data data) {
		Member m = (Member) data;
		memberList.remove(m);
	}

	@Override
	void update(Data data) { // 회원 정보 수정 메서드
		Member m = (Member) data;
		System.out.println("수정을 원하시는 항목을 입력해주세요.");// 1.아이디 2.비밀번호 3.이름 4.생년월일 5.전화번호
		int menu = scanner.nextInt();
		scanner.nextLine();
		switch (menu) {
		case 1: // 아이디 수정
			System.out.println("수정하실 아이디를 입력해주세요.");
			System.out.println("아이디 : " + m.getId());
			m.setId(scanner.nextLine());
			System.out.println("수정되셨습니다. 아이디 : " + m.getId());
			break;
		case 2: // 비밀번호 수정
			while (true) {
				System.out.println("수정하실 비밀번호를 입력해주세요.");
				m.setPassword(m.getPassword());
				System.out.println("비밀번호를 한번 더 입력해주세요");
				String passright = scanner.nextLine();
				if (passright.equals(m.getPassword())) {
					System.out.println("비밀번호를 확인하였습니다.");
					break;
				} else {
					System.out.println("비밀번호가 틀렸습니다. 다시 입력해주세요.");
					continue;
				}
			}
			break;
		case 3: // 이름 수정
			System.out.println("수정하실 이름을 입력해주세요.");
			System.out.println("이름 : " + m.getName());
			m.setName(scanner.nextLine());
			System.out.println("수정되셨습니다. 이름 : " + m.getName());
			break;

		case 4: // 생년월일 수정
			System.out.println("수정하실 생년월일를 입력해주세요.");
			System.out.println("생년월일 : " + m.getSsn());
			m.setSsn(scanner.nextLine());
			System.out.println("수정되셨습니다. 생년월일 : " + m.getSsn());
			break;
		case 5: // 전화번호 수정
			System.out.println("수정하실 전화번호를 입력해주세요.");
			System.out.println("전화번호 : " + m.getTel());
			m.setTel(scanner.nextLine());
			System.out.println("수정되셨습니다. 전화번호 : " + m.getTel());
			break;
		case 0:
			System.out.println("이전메뉴로 이동합니다.");
			break;
		default:
			System.out.println("잘못 입력하셨습니다. 다시 메뉴를 선택해주세요.");
			break;
		}
	}

	int Login(String id, String password) { // 로그인 메서드
		Member m = new Member(id, password, name, ssn, tel);
		int login = 0;
		login1: while (true) {

			System.out.println("아이디를 입력하세요. 이전메뉴로 이동(0)");// 아이디 입력
			String idInput = scanner.nextLine();
			int premenu = Integer.parseInt(idInput);
			if (premenu == 0) {
				login = 0;
				break login1;

			}
			for (int i = 0; i < memberList.size(); i++) {
				if (m.getId().equals(idInput)) {
					System.out.println("비밀번호를 입력하세요."); // 비밀번호 입력
					String passInput = scanner.nextLine();
					if (m.getPassword().equals(passInput)) { // 아이디와 비밀번호가 일치할때
						System.out.println(m.getName() + "님이 로그인 하셨습니다.");
						System.out.println("회원 메뉴로 이동합니다.");
						login = 2;
						break login1;
					} else {
						System.out.println("비밀번호를 잘못 입력하셨습니다. 다시 입력해주세요.");
						continue; // 비밀번호가 일치하지 않을때 다시 비밀번호 입력
					}
				} else {
					System.out.println("존재하지 않는 아이디입니다. 다시 입력해주세요.");
					continue login1; // 아이디가 일치하지 않을때 다시 아이디입력부터
				}
			}
		}
		return login;
	}

	void Logout() {
		while (true) {
			System.out.println("로그아웃 하시겠습니까? y/n");
			String out = scanner.nextLine();
			if (out.equals("y")) {
				System.out.println("로그아웃 되었습니다.");
				break;
			} else if (out.equals("n")) {
				System.out.println("로그아웃을 취소하셨습니다.");
				break;
			} else {
				System.out.println("잘못 입력하셨습니다. y/n으로 입력해주세요.");
				continue;
			}
		}
	}

	@Override
	List<Member> searchAll() {
		for (int i = 0; i < memberList.size(); i++) {
			System.out.println((Member) memberList.get(i));
		}
		return null;
	}

	@Override
	List align() {
		// TODO Auto-generated method stub
		return null;
	}
}
