package libProject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controller {

	public static void main(String[] args) {
		Osystem osys = new Osystem(); // 화면출력 객채생성
		int menu;// 화면 메뉴선택에 활용할 메뉴
		Scanner scan = new Scanner(System.in);// 메뉴 입력시 사용할 스캐너
		BookDB bookDB = new BookDB(); // 책 DB 객체생성

		// bookDB.insert(new Book("전쟁과 평화1")); //책 DB에 책 객체저장
		// bookDB.insert(new Book("전쟁과 평화2"));
		// bookDB.insert(new Book("전쟁과 평화3"));
		List<Book> searchBooks = bookDB.search("전쟁과 평화"); // 책 DB에서 책 검색

		for (Book b : searchBooks) {
			System.out.println(b.title);
		} // 책 검색 결과 출력
		System.out.println("---------------------------------");

		MemberDB memberDB = new MemberDB(); // 회원 DB 객체생성

		memberDB.insert(new Member("김자바")); // 회원 DB 객체생성
		memberDB.insert(new Member("이자바"));
		memberDB.insert(new Member("박자바"));
		List<Member> searchMembers = memberDB.search("자바"); // 회원 DB 객체생성

		for (Member m : searchMembers) {
			System.out.println(m.name);
		} // 회원 DB 객체생성

		// -----------------메인시작-----------------------
		main: while (true) {
			observer: while (true) {//----------------------비회원 while-------------------
				osys.observer_main();//비회원 메인화면
				menu = scan.nextInt();
				scan.nextLine();
				switch (menu) {//1.도서검색 2.회원가입 3.로그인 4.관리자로그인 5.아이디/비밀번호 찾기
				case 1://1.도서검색
					osys.observer_search();//비회원 도서검색 화면
					menu = scan.nextInt();
					scan.nextLine();
					switch(menu) {//1.제목 2.저자 3.출판사 4.주제 5.인덱스 6.ISBN 7.전체 도서목록 0.이전화면으로
					case 1://제목
						//제목 검색 메서드
						break;
					case 2://저자
						//저자 검색 메서드
						break;
					case 3://출판사
						//출판사 검색 메서드
						break;
					case 4://주제
						//주제 검색 메서드
						break;
					case 5://인덱스
						//인덱스 검색 메서드
						break;
					case 6://ISBN
						//ISBN검색 메서드
						break;
					case 7://전체 도서목록
						//전체도서목록 출력메서드
						break;
					case 0://이전화면으로
						System.out.println("이전화면으로 돌아갑니다.");
						continue observer;
					}
					break;
					
				case 2://회원가입
					osys.observer_signin();//회원가입 화면
					//회원가입 메서드
					break;
				case 3://로그인
					System.out.println("아이디를 입력하세요.");
					String id = scan.nextLine();
					System.out.println("비밀번호를 입력하세요.");
					String pass = scan.nextLine();
					//로그인 메서드
					break observer;//성공시 비회원메뉴 종료 
				case 4://관리자로그인
					System.out.println("아이디를 입력하세요.");
					id = scan.nextLine();
					System.out.println("비밀번호를 입력하세요.");
					pass = scan.nextLine();
					//로그인 메서드
					break observer;//성공시 비회원메뉴 종료 
				case 5://아이디 비밀번호찾기
					osys.observer_findMember();//정보찾기 화면
					menu = scan.nextInt();
					scan.nextLine();
					switch(menu) {//1. 아이디 찾기 2.비밀번호 찾기 0. 이전화면
					case 1://아이디 찾기
						osys.observer_findId();//아이디찾기 화면
						//아이디 찾기 메서드
					case 2://비밀번호 찾기
						osys.observer_findPass();//비밀번호찾기 화면
						//비밀번호 찾기 메서드
					case 0://이전화면
						System.out.println("이전화면으로 돌아갑니다.");
						continue observer;
					}
					break;
				case 0://프로그램 종료
					System.out.println("프로그램을 종료합니다...");
					break main;
				}//end switch
				break;
			} //--------------------------비회원 while end-----------------------
			member: while (true) {
				osys.member_main();
				menu = scan.nextInt();
				scan.nextLine();
				switch(menu) {//1.도서검색대출 2.빌린도서 3.도서반납 4.회원정보 5.건의사항 9.로그아웃 0.종료");
					case 1://도서검색대출
						osys.member_search();//회원 도서검색화면
						menu = scan.nextInt();
						scan.nextLine();
						switch(menu) {//1.제목 2.저자 3.출판사 4.주제 5.인덱스 6.ISBN 7.전체 도서목록 0.이전화면으로
						//아래에 대출기능도 추가
						case 1://제목
							//제목 검색 메서드
							break;
						case 2://저자
							//저자 검색 메서드
							break;
						case 3://출판사
							//출판사 검색 메서드
							break;
						case 4://주제
							//주제 검색 메서드
							break;
						case 5://인덱스
							//인덱스 검색 메서드
							break;
						case 6://ISBN
							//ISBN검색 메서드
							break;
						case 7://전체 도서목록
							//전체도서목록 출력메서드
							break;
						case 0://이전화면으로
							System.out.println("이전화면으로 돌아갑니다.");
							continue member;
						}//end switch
						break;
					case 2://빌린도서
						//빌린도서 출력 메서드
						break;
					case 3://도서반납
						//빌린도서 출력 메서드
						//도서반납 메서드
						break;
					case 4://회원정보
						osys.member_inform();
						menu = scan.nextInt();
						scan.nextLine();
						switch(menu) {//1.회원정보 조회 2.회원정보 수정 0. 이전화면
						case 1://회원정보 조회
							osys.member_myinform();//회원정보 조회 화면
							//회원정보 조회 메서드
						case 2://회원정보 수정
							osys.observer_findPass();//회원정보 수정 화면
							//회원정보 수정 메서드
						case 0://이전화면
							System.out.println("이전화면으로 돌아갑니다.");
							continue member;
						}
						break;
					case 5://건의사항
						osys.member_request();
						//겅늬사항 메서드
						break;
					case 9://로그아웃
						break;
					case 0://종료
						System.out.println("프로그램을 종료합니다...");
						break main;
				}//end switch
				break;
			} //-----------------------------회원 while end-----------------------
			admin: while (true) {
				break;
			} //--------------------------------관리자 while end-------------------------
		} // end while_main

	}// end main

}// end class